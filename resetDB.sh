 #!/bin/bash

docker stop prot-db
docker rm prot-db
docker run -d --name prot-db -e POSTGRES_PASSWORD=prot123 -e POSTGRES_USER=prot -p 127.0.0.1:25432:5432 postgres:9.5