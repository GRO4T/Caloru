FROM python:3.11.5-alpine3.18

RUN mkdir /app
WORKDIR /app

COPY . /app/

RUN pip install -r requirements.txt

WORKDIR /app/caloru

RUN python manage.py migrate
RUN python manage.py loaddata products

EXPOSE 8000

CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]