FROM maven:3.5.4-jdk-8 as builder

ENV SERVICE_DIR /opt/service
WORKDIR ${SERVICE_DIR}

COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
COPY . .

RUN mvn -B -e -o -T 1C package

FROM openjdk:8-jdk
ENV SERVICE_DIR /opt/service
ENV SERVICE_JAR service.jar

RUN mkdir -p ${SERVICE_DIR}

WORKDIR ${SERVICE_DIR}

COPY --from=builder ${SERVICE_DIR}/target/${SERVICE_JAR} .
COPY --from=builder ${SERVICE_DIR}/conf/application.conf ./conf/application.conf

CMD java ${JAVA_OPTS} \
    -server -Xms128m -Xmx128m \
    -Djava.security.egd=file:/dev/./urandom \
    -jar ${SERVICE_DIR}/${SERVICE_JAR}