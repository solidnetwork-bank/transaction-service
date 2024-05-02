# transaction-service

# REMEMBER UPDATE VERSION
- pom.xml
- README
- commit
- tag


# Generate Jar before build
````
./.mvn/mvnw -B package --file pom.xml
````

# build
````
docker build -t "solidnetworkxyz/transaction-service:1.0" .
````

# run
````
docker run --rm -it -p 80:80 solidnetworkxyz/transaction-service:1.0
````
# login
````
docker login -u solidnetworkxyz
````

# push
````
docker push solidnetworkxyz/transaction-service:1.0
````

