import random
import time

import pika


class Message_Generator:
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='generator')

    def send_message(self, message):
        self.channel.basic_publish(exchange='', routing_key='generator', body=message)
        print(" [x] Sent %r" % message)
    def temperature(self):
        import requests
        import json
        station_id = "1210702"
        url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json"
        response = requests.get(url)
        data = response.json()
        days = data.keys()
        temp = data[sorted(days)[-1]][station_id]["temperatura"]
        hum = data[sorted(days)[-1]][station_id]["humidade"]
        weather = {
            "temperature": temp,
            "humidity": hum
        }
        json_weather = json.dumps(weather)
        self.channel.basic_publish(exchange='', routing_key='generator', body=json_weather)
        print(" [x] Sent %r" % json_weather)

    def dump(self):
        import requests
        import json
        station_id = "1210702"
        url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json"
        response = requests.get(url)
        data = response.json()
        days = data.keys()
        for d in days:
            temp = data[d][station_id]["temperatura"]
            hum = data[d][station_id]["humidade"]
            weather = {
                "temperature": temp,
                "humidity": hum
            }
            json_weather = json.dumps(weather)
            self.channel.basic_publish(exchange='', routing_key='generator', body=json_weather)
            print(" [x] Sent %r" % json_weather)


def main():
    generator = Message_Generator()
    generator.dump()

    while True:
        generator.temperature()
        time.sleep(1)


if __name__ == '__main__':
    main()
