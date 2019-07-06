# gomo-code-challenge

## Prerequisites
- Java 8+ (I have tested using 12.0.1)
- (Optional) Maven if you don't want to use the wrapper provided in this repo. Remember
to replace `mvnw` with `mvn` for everything below.

## How to build
Run the following on the main directory:
```
mvnw clean install
```

## How to run tests
Do note that the build command above will run tests as well so not needed if you
ran the above.

Run the following on the main directory:
```
mvnw clean test
```

## How to run
Run the following on the main directory after you have built it with your arguments:
```
java -jar target/uvt-0.0.1-SNAPSHOT.jar 0-1000 2000-3000 2500-4000
```

Do note that only the result is present in the standard output so you can directly
pipe the result or use it elsewhere. If there is an error then the UVT returned
will be -1.

If you want to access the logs check the logs folder for `uvt.log`