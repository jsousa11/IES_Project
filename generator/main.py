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

class Forum_Generator:
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='forum')

    def send_message(self, message):
        self.channel.basic_publish(exchange='', routing_key='forum', body=message)
        print(" [x] Sent %r" % message)

    def forum_generator(self):

        adjectives = ['happy', 'strong', 'big', 'small', 'fast', 'slow']
        nouns = ['flower', 'dog', 'car', 'bike', 'tree', 'river', 'sea', 'sun', 'moon', 'star', 'farmer']
        usernames = []

        for i in range(6):
            adjective_index = random.randint(0, len(adjectives) - 1)
            noun_index = random.randint(0, len(nouns) - 1)
            adjective = adjectives[adjective_index]
            noun = nouns[noun_index]
            username = adjective + '_' + noun + '_' + str(random.randint(0, 1000))
            usernames.append(username)

        intros = ['Hello!', 'Hi!', 'Hey!', 'Howdy!', 'Greetings!', 'Salutations!', 'What\'s up?!', 'What\'s new?!']
        plants = ['rose', 'tulip', 'daisy', 'orchid', 'sunflower', 'lily', 'daffodil', 'carnation', 'dandelion', 'iris', 'lavender', 'tomato', 'sweet potato', 'cucumber', 'bamboo', 'bearberry', 'cherry', 'cedar', 'cotton plant', 'brown daisy', 'eucaliptus', 'eytelia', 'fig', 'garlic', 'hogweed']
        questions = ['Do you have tips to use in my', 'Someone can help me with my', 'What do you think about', 'How should I take care of my']

        answers = ['It is best to water your plant thoroughly, allowing the water to reach the roots. Avoid letting the plants sit in standing water, as this can lead to root rot.  ',
                   'There are many natural and safe ways to get rid of pests on your plants. One option is to use a mixture of water and dish soap as a natural insecticide. You can also try using natural predators, such as ladybugs, to control pests. ',
                   'Well-draining soil is best for your plant. You can create your own soil by mixing equal parts potting soil, perlite, and coarse sand. ',
                   'There are several methods you can use to propagate your plants, including rooting stem cuttings, dividing plants, and layering. ',
                   'You can use a fertilizer that is high in nitrogen, such as 10-10-10, to help your plant grow. ',
                   'You can use a fertilizer that is high in phosphorus, such as 0-20-20, to help your plant bloom. ',
                   'You can use a fertilizer that is high in potassium, such as 0-0-60, to help your plant grow strong. ',
                   'You can use a fertilizer that is high in magnesium, such as 0-0-10, to help your plant grow strong. ',
                   'Do not overwater your plant. If the soil is too wet, the roots will not be able to breathe and the plant will not be able to absorb nutrients. ',
                   'Do not underwater your plant. If the soil is too dry, the roots will not be able to absorb nutrients and the plant will not be able to grow. ',
                   'You can use a fertilizer that is high in calcium, such as 0-0-10, to help your plant grow. ',
                   'Try to keep your plant in a location that receives at least 6 hours of sunlight each day. ',
                   'Don\'t forget to water your plant! ',
                   'Don\'t forget to fertilize your plant! ',
                   'Don\'t forget to prune your plant! ',
                   'Don\'t put your plant in direct sunlight. ',
                   'Don\'t put your plant in a location that receives too much sunlight. ',
                   'Don\'t put your plant in a location that receives too little sunlight. ',
                   'Love your plant choice! Keep up the good work! ',
                   'I\'m sure your plant will be beautiful! ',
                   'I\'m sure your plant will be healthy! ',
                   'I\'m sure your plant will be strong! ',
                   'I\'m thinking about getting that plant too!. Good luck! '
                   ]

        intro_index = random.randint(0, len(intros) - 1)
        plants_index = random.randint(0, len(plants) - 1)
        questions_index = random.randint(0, len(questions) - 1)
        list_answers = []

        question = intros[intro_index] + ' ' + questions[questions_index] + ' ' + plants[plants_index] + '?'

        for i in range(0, 5):
            intro_index = random.randint(0, len(intros) - 1)
            answer_index = random.randint(0, len(answers) - 1)
            answer = intros[intro_index] + ' ' + answers[answer_index]
            list_answers.append(answer)

        forum = {
            "username": usernames[0],
            "question": question,
            "username1": usernames[1],
            "answer1": list_answers[0],
            "username2": usernames[2],
            "answer2": list_answers[1],
            "username3": usernames[3],
            "answer3": list_answers[2],
            "username4": usernames[4],
            "answer4": list_answers[3],
            "username5": usernames[5],
            "answer5": list_answers[4]
        }

        json_forum = json.dumps(forum)

        self.channel.basic_publish(exchange='', routing_key='forum', body=json_forum)
        print(" [x] Sent %r" % forum)

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
    #user = Username_Generator()
    forum = Forum_Generator()
    generator = Message_Generator()
    generator.dump()

    while True:
        #user.username_generator()
        forum.forum_generator()
        generator.weather()
        time.sleep(5)

    details = info()
    details.info()

if __name__ == '__main__':
    main()
