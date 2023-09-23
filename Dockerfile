FROM python:3.11.5-bullseye

RUN mkdir /app
WORKDIR /app

COPY . /app/

RUN pip install -r requirements.txt

RUN /app/setup.sh

EXPOSE 8000

CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
