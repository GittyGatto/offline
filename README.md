# create docker container

    docker run -d --name prot-db -e POSTGRES_PASSWORD=prot123 -e POSTGRES_USER=prot -p 127.0.0.1:25432:5432 postgres:9.5

# maven clean install call without tests

    mvn clean install -DskipTests

# development

Start a webpack-dev-server for combined javascript/css resources with hot reloading

    npm start 


npm install
npm run build
npm start