Инструкция по развертыванию:

    Java 8
    MySql >= v5.6
    Git
    Gradle >= v2.6
    Tomcat
    Apache server

 Все sql скрипты находятся в папке : java+php+banksystem / src / main / resources / db / migration /
- В файле application.properties необходимо указать данные для подключения к mysql
- Созданы два пользователя:
1. логин: admin, пароль: admin
2. логин: azamat, пароль: test

-  Backend(JAVA services) развернуть на tomcat.  Необходимо поднять сервер на порте 8181. В Intellij Idea можно указать параметр --server.port=8181
-  Frontend находится в папке java+php+banksystem / azamat.banking.frontend /
-  Frontend необходимо развернуть на apache server(WAMP, XAMP ...) Порт по умолчанию