# Easy Farming

Easy Farming - Online advice system for agriculture that allows the user to enter information about their crops and receive notifications for their management.


## Project team:

| Role 	        |Name 	          |Email 	                  |NMEC   |
|---------------|-----------------|-------------------------|-------|
| DevOps        |João Sousa 	    |jsousa11@ua.pt 	        |103415 |
| Architect     |Catarina Marques	|catarina.a.marques@ua.pt |81382  |
| Team Manager  |Vânia Morais     |vania.morais@ua.pt       |102382 |

*Everyone is Product Owner and Developer.

## Project resources:

Atlassian Scrum Board: https://easyfarming.atlassian.net/jira/core/projects/EAS/board

Report: https://docs.google.com/document/d/1XZqbB-mA_-0y-NWJ4Dap0eEtpzrNtgahLEfi6SbkrNM/edit

Presentation: https://www.canva.com/design/DAFWD6LsCbc/jMYKfYPBi2eupubWetbiHQ/edit?utm_content=DAFWD6LsCbc&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

## Correr a app na VM

1. Executar o comando, colocando o user da sua conta da UA

```
ssh  ies@deti-ies-06.ua.pt
```

2. De seguida inserir a password: ``` tiku9-zapy8 ```
3. Navegar para o diretório ./IES/Project_IES
4. Depois é só correr o docker:

```
sudo docker-compose down -v
```

```
sudo docker-compose build
```

```
sudo docker-compose up
```

5. No browser se navegar no link: 192.168.160.227:8090/ irá conseguir ver o site a correr.

## Correr a app em localhost
### Compilar o easyfarming

1. Ao compilar o easyfarming, irá eliminar a pasta target caso exista, e gera-lo de novo com base no código do easyfarming, contendo este um ficheiro jar.
2. Para isto basta correr o seguinte comando no diretório ./easyfarming:

```
mvn clean package -DskipTests
```

2. Compilar o docker

1. Antes de compilar o docker é necessario ter o ficheiro jar do easyfarming pretendido (para obte-lo basta executar os passos vistos anteriormmente)
2. Para compilar o docker basta correr o seguinte comando no diretório raiz do projeto:

```
docker-compose build
```

### Executar o docker

1. Para correr o docker basta correr o seguinte comando no diretório raiz do projeto:

```
docker-compose down -v
```

```
docker-compose up
```

2. Para eliminar a base de dados:

```
docker-compose down -v
```

3. Para eliminar docker: 

```
docker rm -f $(docker ps -aq)
```

4. Observar os resultados Website http://localhost:8090/

## Another way to run the app
You can use the file run.sh:
```
./run.sh
```

## Access to the website
- To use __Pedro__ profile, do Login with the email "pedro@email.com" and password "the_farmer123"
- To use __Ana__ profile, do Login with the email "ana@email.com" and password "aninha123"
- To try the upload feature, click on the button "Try Now"
- Because is your first time using the app, the tables of our database are empty. You can use de images in the folder "images" to test the upload feature, filling the database. Feel free to use your own images!
