# Weather API - Provincia Seguros

Martin de Amorin
<martindeamorin@gmail.com>

## Requisitos

Esta aplicacion se puede levantar a traves de docker-compose o compliando directamente manualmente.

En el caso de que se compile manualmente se requiere tener instalado el JDK de Java 8, en caso de levantar con Docker se requiere tener instalado Docker y Docker Compose.

## Levantar el proyecto

El proyecto se levanta en el puerto 8080, asegurarse de que este liberado antes de intentar levantar el proyecto.

Antes de ejecutar los comandos debemos tener en cuenta las varaibles de entorno. Son 4:

- **ACCU_API_KEY**: Api Key de AccuWeather
- **ACCU_API_URL**: URL base de la API de AccuWeather
- **DB_USERNAME**: User de la base H2
- **DB_PASSWORD**: Password de la base H2

### Docker

Reemplazar en el archivo .env el template por los valores reales que se requieren. Este archivo lo va a levantar docker-compose para setear las variables de entorno. Tener en cuenta que si los valores estan mal o no se setean el contenedor no va a levantar ya que se requiere que los test pasen.

Desde la raiz del proyecto ejecutar

```
    docker-compose -f docker/docker-compose.yml build
    docker-compose -f docker/docker-compose.yml up
```

### Manual

Debemos setear en nuestro entorno las variables, una forma de hacerlo es de la siguiente manera:

```
    export ACCU_API_KEY=123456
```

Si no las seteamos de esta manera el Resolver de las properties de Spring Boot va a tirar error ya que no puede resolver la referencia.

Para levantar el proyecto con los tests:
```
    ./mvnw install
    java -jar target/weather-0.0.1-SNAPSHOT.jar
```

## Documentacion

Una vez levantado el proyecto podemos encontar el [Swagger](http://localhost:8080/swagger-ui).

Alli se podran ver los endpoints, lo que el endpoint espera y devuelve, tambien se podra probar la API y hacer requests.

