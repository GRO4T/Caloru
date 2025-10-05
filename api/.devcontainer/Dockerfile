FROM mcr.microsoft.com/devcontainers/python:1-3.11-bookworm

RUN mkdir /app

USER vscode
ENV HOME="/home/vscode"
ENV PATH="$HOME/.local/bin:$HOME/.venv/bin:$PATH"
ENV VIRTUAL_ENV="$HOME/.venv"
WORKDIR $HOME

RUN wget -qO- https://astral.sh/uv/0.8.17/install.sh | sh

COPY pyproject.toml uv.lock $HOME/
RUN uv python install 3.13 && \
    uv sync --no-group prod

WORKDIR /app/caloru
ENTRYPOINT ["uvicorn", "--reload", "caloru.asgi:application", "--host", "0.0.0.0", "--port", "8000"]
