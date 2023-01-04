docker run --name easyfarming -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=easyfarming -e MYSQL_USER=easyfarming -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7
cd generator/
python3 main.py