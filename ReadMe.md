# Authentication

1. Basic authentication.
send user id & password.

2. digest authentication.
password digest is created and the digest is send across. the actual is not send

3. 

# 1. Basic authentication.

*Add dependancy to pom.xml*
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

* when we start the spring project it generate a default security password each time.
41_default_password.PNG

now call a URI and it'll give a unauthorized error. 42_unauthorize.PNG

we should add `generated security password` here. the default user will be `user`
43_add_basicAuthentication.PNG