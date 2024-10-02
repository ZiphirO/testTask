docker run --name testTusk_DB -e POSTGRES_PASSWORD=123 -e POSTGRES_USER=postgres -p 5444:5432 -d postgres
docker start testTusk_DB
mvn test
mvn spring-boot:run