cd easyfarming
docker-compose up
cd ../generator
docker-compose down -v
docker-compose up
cd ../easyfarming
mvn spring-boot:run
cd ../generator
./main.sh