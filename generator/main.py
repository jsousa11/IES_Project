import random
import time
import pika
import wikipedia
import requests
import json

class Message_Generator:
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='generator')

    def send_message(self, message):
        self.channel.basic_publish(exchange='', routing_key='generator', body=message)
        print(" [x] Sent %r" % message)
    def weather(self):
        station_id = "1210702"
        url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json"
        response = requests.get(url)
        data = response.json()

        url2 = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json"
        response2 = requests.get(url2)
        data2 = response2.json()


        days = data.keys()
        temp = data[sorted(days)[-1]][station_id]["temperatura"]
        hum = data[sorted(days)[-1]][station_id]["humidade"]
        precip = float(data2["data"][0]["precipitaProb"])

        weather = {
            "temperature": temp,
            "humidity": hum,
            "precipitation": precip
        }
        json_weather = json.dumps(weather)
        self.channel.basic_publish(exchange='', routing_key='generator', body=json_weather)
        print(" [x] Sent %r" % json_weather)


    def dump(self):
        station_id = "1210702"
        url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json"
        response = requests.get(url)
        data = response.json()
        days = data.keys()

        url2 = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json"
        response2 = requests.get(url2)
        data2 = response2.json()

        for d in days:
            temp = data[d][station_id]["temperatura"]
            hum = data[d][station_id]["humidade"]
            precip = float(data2["data"][0]["precipitaProb"])

            weather = {
                "temperature": temp,
                "humidity": hum,
                "precipitation": precip
            }

            json_weather = json.dumps(weather)
            self.channel.basic_publish(exchange='', routing_key='generator', body=json_weather)
            print(" [x] Sent %r" % json_weather)





class info:
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='info')

    def send_message(self, message):
        self.channel.basic_publish(exchange='', routing_key='info', body=message)
        print(" [x] Sent %r" % message)

    def info(self):
        print (wikipedia.summary("plant orchid"))


def main():
    generator = Message_Generator()
    generator.dump()

    while True:
        generator.weather()
        time.sleep(100)
        
    details = info()
    details.info()

if __name__ == '__main__':
    main()
