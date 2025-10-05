#!/bin/bash
(
    cd ./caloru || exit

    python manage.py loaddata users
    python manage.py loaddata food_items
)
