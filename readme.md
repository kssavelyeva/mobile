# #
`# > Maven-строки для запуска: #`# #

- Chrome

 mvn -Dtest=EmptyFieldError -Dbrowser=chrome verify

- Firefox

mvn -Dtest=EmptyFieldError -Dbrowser=firefox verify

- Opera

mvn -Dtest=EmptyFieldError -Dbrowser=opera verify

Если тесты на Opera не запускаются, то можно изменить версию selenium-opera-driver в файле pom.xml, например, на: 3.14.0, 3.7.1, 3.12.0.