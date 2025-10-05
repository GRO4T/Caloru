RUFF_CMD := "uv run ruff"
DJANGO_MANAGE_CMD := "uv run python3 manage.py"

default:
    just --list

fmt:
    {{RUFF_CMD}} format --diff
    {{RUFF_CMD}} check --select I

fmt_fix:
    {{RUFF_CMD}} format
    {{RUFF_CMD}} check --select I --fix

lint:
    {{RUFF_CMD}} check

lint_fix:
    {{RUFF_CMD}} check --fix

test:
    cd caloru && {{DJANGO_MANAGE_CMD}} test

makemigrations:
    cd caloru && {{DJANGO_MANAGE_CMD}} makemigrations

migrate:
    cd caloru && {{DJANGO_MANAGE_CMD}} migrate
