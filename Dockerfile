FROM maven:3.8.3-openjdk-17 AS maven_build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn clean package -DskipTests
FROM maven:3.8.3-openjdk-17 AS maven_build2
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-Dserver.port=9090:9090","-cp","app:app/lib/*","com.miracle.claim.ClaimsApplication"]
