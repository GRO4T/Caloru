FROM python:3.11.5-bullseye

RUN mkdir /app
WORKDIR /app

COPY requirements.txt /app/requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

COPY caloru /app/caloru
COPY setup.sh /app
RUN ./setup.sh

WORKDIR /app/caloru
EXPOSE 8000
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
