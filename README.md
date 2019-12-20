# Spring Boot App Help Desk 🧰🎫

Simple app to study Java 8 with Spring boot. 

## Build With 

- [Java 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Mongo DB](https://www.mongodb.com/)
- [JWT](https://github.com/jwtk/jjwt)
- Building Area ⛏️

## Enviroment
- Java 8 SDK
- Mongodb
- Maven

## Installation

Download this repo to your workspace, and run folow command to start mongo and start app:

```sh
mongod
mvn install / mvn clean install
mvn spring-boot:run
```

## API Usage

Replace contents of `{{host}}`[/api/auth](/api/auth) with your project's host:

Generate user token
```json
{
	"email":"admin@helpdesk.com",
	"password":123456
}
```
Building Area ⛏️

Building Area ⛏️

Building Area ⛏️


## TODO

- Implement unit tests
- Refactor methods in @controllers
- Build ticket functions

## Contributing

Please contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and [open a pull request](https://github.com/wanderaraujo/help-desk-backend).