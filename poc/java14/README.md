# Java 14

Code voorbeelden voor het Java 14 artikel


# Build and run

- open een terminal
- ga naar de `java14` directory in dit project
- run de volgende FROM 8-jdk-alpine
MAINTAINER IvoNet <webmaster@ivonet.nl>
 
```bash
$ docker run -it --rm              \
      -v $(pwd)/src/main/java:/src \
      openjdk:14 /bin/bash
$ cd /src

```
- voor de commando's uit zoals in het artikel besproken in het Java Magazine
