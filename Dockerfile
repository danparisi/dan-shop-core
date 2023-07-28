FROM amazoncorretto:17

EXPOSE 8080 5005

ENV JAVA_EXTRA_OPTS ""
ENV JAVA_OPTS "-verbose:gc \
             -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
             -Dcom.sun.management.jmxremote \
             -Dcom.sun.management.jmxremote.local.only=false \
             -Dcom.sun.management.jmxremote.ssl=false \
             -Dcom.sun.management.jmxremote.authenticate=false \
             -Dcom.sun.management.jmxremote.port=9010 \
             -Dcom.sun.management.jmxremote.rmi.port=9011 \
             -Djava.rmi.server.hostname=localhost \
             -Xmx512m \
             -XX:CompressedClassSpaceSize=50m \
             -XX:-TieredCompilation"

ENV SERVICE "java \
              \${JAVA_OPTS} \
              \${JAVA_EXTRA_OPTS} \
              -jar \
              /opt/service.jar"

ADD target/*.jar.original /opt/service.jar

ENTRYPOINT ["java","${JAVA_OPTS}","${JAVA_EXTRA_OPTS}","-jar", "/opt/service.jar"]