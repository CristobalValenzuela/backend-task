# BACKEND

Artefacto que procesa las peticiones desde el Frontend

## Modificar archivo de propiedades

Modificar archivo application.properties con el host, puerto, database, username y password correspondiente a la base de datos Mysql a utilizar.

```sh
spring.datasource.url=jdbc:mysql://mysql:3306/coopeuch
spring.datasource.username=coopeuch
spring.datasource.password=coopeuch
```

## Compilacion

```sh
mvn clean install -U
```
## Ejecucion de forma local

```sh
java -jar /target/backend-task-0.0.1-SNAPSHOT.jar
```

## Empaquetar y ejecutar imagen Docker
### Crear imagen Docker
```sh
make docker-build
```
### Iniciar imagen Docker
```sh
make doker-up
```

## Swagger

El puerto corresponde al establecido en el archivo application.properties
```sh
server.port=8080
```

http://localhost:8080/swagger-ui.html#