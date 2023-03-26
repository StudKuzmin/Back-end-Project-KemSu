FROM mysql:latest

#RUN apt update && apt install mysql-server -y

COPY ./kardio.sql ./docker-entrypoint-initdb.d/
#COPY ./script/push.sh ./TESTDB/

# Убирает символ возврата каретки ^M. Проблема из-за Windows
#RUN sed -i -e 's/\r$//' ./TESTDB/push.sh
#RUN mysql -u root -p3572 < ./kardio.sql

#EXPOSE 3306

#ENTRYPOINT service mysql start && /bin/bash