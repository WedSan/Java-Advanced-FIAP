# PokeApi Classroom

Project to show the call external API's through libraries, like OpenFeign, Rest Client and Rest Template

## Tasks
  Endpoint that retrieves a random Pokémon. ✅



## Endpoints

    Using rest client Libray
    {ServerUrl}:8080/pokemons/restclient/random

    Using Rest Template Libray
    {ServerUrl}:8080/pokemons/resttemplate/random

    Using Open Feign Libray
    {ServerUrl}:8080/pokemons/openfeign/random

## How to insantiate the DB

To start the database, simply run the following command:

`
  docker-compose up -d
`

This will launch the database container in detached mode. No need to modify the `application.properties` file, as it is already pre-configured to work with the Dockerized database.
