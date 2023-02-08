# PetVax

PetVax is an application that intends to make pet vaccinations more manageable and accessible.

## Package
This project has been implemented to run within a Docker container to allow for an easier executable package for its consumers.

The container contains the following images:
* MySQL
* phpmyadmin/phpmyadmin

### Docker Container
The Docker container is created via a docker-compose.yml file, which can be used to create the container more easily. To do so, you'll need to perform the following steps:

Pre-Condition:
1. Docker installed locally
2. Repository cloned locally

Steps:
1. In a terminal window, navigate to the docker directory
2. Execute `docker compose up`

One the command is executed:
1. Images will be pulled down and container will be spun up
2. SQL statements with the .sql files will be executed

### Calling endpoints in Postman
1. Run the 'VaccinationsApplication' file
2. In Postman, create a request such as:
   `http://localhost:8080/vaccinations?name=Bordetella`