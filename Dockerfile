FROM alpine:3.21 AS install_deps

ARG APP_ENV="prod"

RUN mkdir /app
WORKDIR /app

RUN wget -qO- https://astral.sh/uv/0.8.17/install.sh | sh
ENV PATH="/root/.local/bin:$PATH"

RUN uv python install 3.13

COPY pyproject.toml uv.lock /app/
RUN if [ "$APP_ENV" = "prod" ]; then \
        apk update && \
        apk add \
            build-base \
            libpq-dev && \
        uv sync --no-dev; \
    elif [ "$APP_ENV" = "dev" ]; then \
        uv sync --no-group prod; \
    fi

FROM alpine:3.21

COPY --from=install_deps /app/.venv /app
ENV VIRTUAL_ENV="/app/.venv"
ENV PATH="/app/.venv/bin:$PATH"

COPY caloru /app/caloru
COPY setup.sh load_test_data.sh /app/

WORKDIR /app/caloru
EXPOSE 8000
ENTRYPOINT ["uvicorn", "--reload", "caloru.asgi:application", "--host", "0.0.0.0", "--port", "8000"]
