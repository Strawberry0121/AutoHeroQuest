FROM eclipse-temurin:21-jdk

WORKDIR /app

# Gradle wrapper ファイルも含めて全てコピー
COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

<<<<<<< HEAD
CMD ["java", "-jar", "build/libs/AutoHeroQuest-0.0.1-SNAPSHOT.jar"]
=======
CMD ["java", "-jar", "build/libs/AutoHeroQuest-0.0.1-SNAPSHOT.jar"]
>>>>>>> f678c1a (Initial commit with src and gradle folders)
