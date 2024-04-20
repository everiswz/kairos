# Ecommerce-price-kairos

Service to consult the current price of a product on a specific date/time.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/es/java/technologies/downloads/#java17)
- [Maven 3.9.5](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `/boot/src/main/java/com.kairos.ecommerce.price.EcommercePriceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to OpenShift

The easiest way to deploy the application to OpenShift is to use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/everiswz/kairos
```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "ecommerce-price-kairos"
* A BuildConfig called "ecommerce-price-kairos"
* DeploymentConfig called "ecommerce-price-kairos"
* Service called "ecommerce-price-kairos"

If you want to access the app from outside your OpenShift installation, you have to expose the secommerce-price-kairos service:

```shell
oc expose ecommerce-price-kairos --hostname=www.example.com
```
## Unit test

The JUnit unit tests are located as usual in their respective package, under  /[maven-module]/src/test/java i.e. under package com.kairos.ecommerce.price

## Integration test

The JUnit integration tests are located under /boot/src/test/java/com.kairos.ecommerce.price.IntegrationTest
You can run and debug them individually.
