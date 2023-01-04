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

## Run the app on the VM

1. Run the command, putting the user of your UA account

```
ssh ies@deti-ies-06.ua.pt
```

2. Then enter the password: ``` tiku9-zapy8 ```
3. Navigate to the ./IES/IES_Project directory
4. Then just run docker:

```
sudo docker-compose down -v
```

```
sudo docker-compose build
```

```
sudo docker-compose up
```

5. In the browser, if you navigate to the link: 192.168.160.227:8090/ you will be able to see the site running.

## Run the app on localhost
### Compile easyfarming

1. When compiling easyfarming, it will delete the target folder if it exists, and generate it again based on the easyfarming code, containing a jar file.
2. To do this, just run the following command in the ./easyfarming directory:

```
mvn clean package -DskipTests
```

2. Compile docker

1. Before compiling docker it is necessary to have the desired easyfarming jar file (to obtain it just follow the steps seen above)
2. To compile docker, just run the following command in the project's root directory:

```
docker-compose build
```

### Run docker

1. To run docker just run the following command in the root directory of the project:

```
docker-compose down -v
```

```
docker-compose up
```

2. To delete the database:

```
docker-compose down -v
```

3. To delete docker:

```
docker rm -f $(docker ps -aq)
```

4. Observe the results Website http://localhost:8090/

## Another way to run the app
1. You can use in one terminal the file run1.sh:
```
./run1.sh
```
2. And then you use the file run2.sh in another terminal:
```
./run2.sh
```
## Access to the website
- To use __Pedro__ profile, do Login with the email "pedro@email.com" and password "the_farmer123"
- To use __Ana__ profile, do Login with the email "ana@email.com" and password "aninha123"
- To try the upload feature, click on the button "Try Now"
- Because is your first time using the app, the tables of our database are empty. You can use de images in the folder "images" to test the upload feature, filling the database. Feel free to use your own images!
