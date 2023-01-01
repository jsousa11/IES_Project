FROM python:3.8.10

COPY requirements.txt /requirements.txt

RUN pip install -r requirements.txt

ADD main.py /

CMD ["python3", "main.py"]