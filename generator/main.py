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
        while True:
            avg_temp = 25
            temp = round(avg_temp + random.uniform(-25, 10))
            json_temp = '{"temperature": %dªC}' % temp
            self.channel.basic_publish(exchange='', routing_key='generator', body=json_temp)
            print(" [x] Sent %r" % json_temp)
            time.sleep(1)


def main():
    generator = Message_Generator()
    generator.temperature()


if __name__ == '__main__':
    main()
