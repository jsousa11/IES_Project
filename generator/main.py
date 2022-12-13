import random
import time

import pika
import wikipedia



class Message_Generator:
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='generator')

    def send_message(self, message):
        self.channel.basic_publish(exchange='', routing_key='generator', body=message)
        print(" [x] Sent %r" % message)

    def temperature(self):
        while True:
            avg_temp = 25
            temp = round(avg_temp + random.uniform(-25, 10))
            json_temp = '{"temperature": %dªC}' % temp
            self.channel.basic_publish(exchange='', routing_key='generator', body=json_temp)
            print(" [x] Sent %r" % json_temp)
            time.sleep(1)


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
    #generator = Message_Generator()
    #generator.temperature()
    details = info()
    details.info()

if __name__ == '__main__':
    main()
