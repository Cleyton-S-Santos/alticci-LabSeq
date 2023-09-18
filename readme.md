# Alticci Sequence

![](https://img.shields.io/docker/automated/creito/labseq?style=plastic)
![](https://img.shields.io/github/languages/top/Cleyton-S-Santos/alticci-LabSeq?style=plastic)
![](https://img.shields.io/github/last-commit/Cleyton-S-Santos/alticci-LabSeq/main?style=plastic)

This software is a **REST API** to find the number from **Alticci sequence**.
It is defined by:
> n=0 => a(0) = 0  
> n=1 => a(1) = 1  
> n=2 => a(2) = 1  
> n>2 => a(n) = a(n-3) + a(n-2)

## Documentation

Made with OpenApi (Swagger):
> /swagger-ui/index.html

Endpoint:
> GET /labseq/<INDEX_NUMBER>

## Run instructions

+ With Docker

```bash
docker pull creito/labseq
docker run -p <DESIRED_PORT>:8081 --name <CONTAINER_ALIAS> creito/labseq
```

+ Without Docker

```bash
git clone https://github.com/Cleyton-S-Santos/alticci-LabSeq.git
cd alticci-LabSeq
mvn clean package
java -jar target/labseq-0.0.1-SNAPSHOT.jar
```

### Technologies used

+ [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
+ [Spring Boot](https://spring.io/projects/spring-boot)
+ [Maven](https://maven.apache.org/)
+ [Lombok](https://projectlombok.org/)
