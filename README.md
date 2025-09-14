# Caloru

**Caloru** is a simple, web-based caloric tracker.

## Tech Stack

- **Django**: Backend framework for creating and managing web applications.
- **PostgreSQL**: Database to store user information, food logs, and caloric data.
- **Bootstrap**: Frontend framework to style and create a responsive interface.

## Installation

This section describes steps needed to deploy the service at 127.0.0.1:8000.

1. **Install Dev Containers VS Code extension**
2. **Ctrl+Shift+P > Dev Containers: Open Folder in Container...**

## TODOs

### Set up proper development server

Currently not everything is hot-reloaded, e.g. changing HTML templates requires rebuilding the whole image.

The solution is to use `python3 manage.py runserver` with `Debug=True` in development mode. However, from the initial investigation it seems that serving static files using Django's built-in development server might be tricky.

Another issue is that according to Django's documentation static files should be stored in per-application basis in which case a collectstatic which would prevent the hot-reloading.

It is important to note that in production mode we should use uvicorn with `Debug=False`.

https://docs.djangoproject.com/en/5.1/ref/django-admin/

https://docs.djangoproject.com/en/5.1/howto/static-files/

### Move from pylint + black + isort to ruff
