#Sample MicroProfile With JavaEE 8 and Java 11 and Liberty 20



# Build
maven:

mvn package
java -jar {path to jar}.jar

docker:
mvn clean package && docker build -t org.mehrabi/MicroProfileSamle .

# RUN

docker rm -f MicroProfileSamle || true && docker run -d -p 8080:8080 -p 4848:4848 --name MicroProfileSamle org.mehrabi/MicroProfileSamle 