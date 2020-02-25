# HATEOAS
**Hypermedia as the Engine of Application State**

*A client interacts with a REST API entirely through the responses provided dynamically by the server.*
*Put even more simply: You shouldn't need any documentation or out-of-band information to use a REST API.*

***pom.xml***
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-hateoas</artifactId>
		</dependency>
```

***UserController***
```java
    @GetMapping("/users3/{id}")
    public Resource<User> retrieveUser3(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        Resource resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

```
***output***
13_HETEOAS.PNG