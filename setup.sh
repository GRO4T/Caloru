#!/bin/bash
(
    cd ./caloru || exit

    python manage.py collectstatic --noinput 

    python manage.py migrate

    python manage.py loaddata users
    python manage.py loaddata products
    python manage.py loaddata consumed_products

    python manage.py ensure_superuser --no-input \
        --username "$DJANGO_SUPERUSER_USERNAME" \
        --email "$DJANGO_SUPERUSER_EMAIL" \
        --password "$DJANGO_SUPERUSER_PASSWORD"
)