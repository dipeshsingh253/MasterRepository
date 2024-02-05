# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Final Words

- Use this command to run and display the logs in newrelic platform
- ``java -javaagent:"C:\Program Files\New Relic\newrelic\newrelic.jar" -jar app.jar``
- here the `C:\Program Files\New Relic\newrelic\` contains a newrelic.yml which provides configuration for our app. 
- you can create a directory newrelic in the project root and put this zip there and modify the configurations accordingly.
- In order to display the logs dynamically while development from an IDE you should use following steps :
    - go to edit run configurations
    - add the VM options as `-javaagent:"C:\Program Files\New Relic\newrelic\newrelic.jar"`
    - and that's all , now running the application from IDE should work.