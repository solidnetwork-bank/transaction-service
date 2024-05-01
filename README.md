# card-service

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
docker build -t "solidnetworkxyz/card-service:1.3" .
````

# run
````
docker run --rm -it -p 80:80 solidnetworkxyz/card-service:1.3
````
# login
````
docker login -u solidnetworkxyz
````

# push
````
docker push solidnetworkxyz/card-service:1.3
````

