FROM alpine:3.21 AS install_deps

RUN mkdir /app
WORKDIR /app

RUN wget -qO- https://astral.sh/uv/0.8.17/install.sh | sh
ENV PATH="/root/.local/bin:$PATH"

RUN uv python install 3.13 && \
    apk update && \
    apk add \
        build-base \
        libpq-dev

COPY pyproject.toml uv.lock /app/

RUN uv sync --no-dev

FROM alpine:3.21

COPY --from=install_deps /app/.venv /app
ENV VIRTUAL_ENV="/app/.venv"
ENV PATH="/app/.venv/bin:$PATH"

COPY caloru /app/caloru
COPY scripts /app/scripts

WORKDIR /app/caloru
EXPOSE 8000
ENTRYPOINT ["uvicorn", "--reload", "caloru.asgi:application", "--host", "0.0.0.0", "--port", "8000"]
