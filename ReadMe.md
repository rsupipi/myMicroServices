# Data JPA

## Add dependancies.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

here we are using in memory database(h2)

## Configurations
***apllication.property***
```properties
# === add jpa configuration ===
#= enable sql log in =
spring.jpa.show-sql=true

#= enable h2 console =
spring.h2.console.enabled=true
```

## JPA Annotations

`@Entity`:

`@Id` : mark it as a primary key

`@GeneratedValue`: 

## insert user Data

***Entity class: User1.java***
```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data   //  lombok
@AllArgsConstructor //  lombok
@NoArgsConstructor  //  lombok
@Entity     //  data jpa
public class User1 {

    /* make this a primary key**/
    @Id     //  data jpa
    @GeneratedValue
    private int id;

    @Size(min = 2 , message = "Name should have at least 2 char") // validate the size for 2 letters
    private String name;

    @Past // validate this should be a past date
    private Date birthDate;

    /**generate setters and getters*/
}
```

***insert data :***
error: 
```sql
insert into user values(3,sysdate(), "mala");
```
Don't add double quotes "mala" in sql file, add single quotes.
```sql
insert into user values(3,sysdate(), 'mala');
```

*data.sql*
```sql
insert into user1 values(1,sysdate(), 'pipi');
insert into user1 values(2,sysdate(), 'sama');
insert into user1 values(3,sysdate(), 'mala');
```

output:
run the application, the table had created in memory. `45_created table.PNG`

url: http://localhost:8080/h2-console/
***connect to h2 db***
jdbc URL:
`jdbc:h2:mem:testdb`

`45_H2_login.PNG`, `46_h2_db_select.PNG`

## CURD

***UserRepository.java***
```java
import com.pipi.bean.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;

//  [this is an interface]             [user repo]  [bean class, primary key]
public interface UserRepository extends JpaRepository<UserJPA, Integer> {
    
}
```

```java
@RestController
public class UserJPAController {

    @Autowired
    private UserRepository userRepository;

    // get all ==================================================
    @GetMapping("jpa/users")
    public List<UserJPA> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // get by ID ==================================================
    @GetMapping("jpa/users/{id}")
    public Optional<UserJPA> retrieveUser2(@PathVariable int id) {
        Optional<UserJPA> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // save  ==================================================
    @PostMapping("jpa/user")
    public UserJPA createUser1(@RequestBody UserJPA user) {
        UserJPA userJPA = userRepository.save(user);
        return user;
    }

    // delete ==================================================
    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}

```

###1. Read
output:
`47_jpa_read.PNG` `48_jpa_read_id.PNG`

### 2. Delete
output:
`49_jpa_delete_id.PNG`

###3. create
output:
`50_jpa_create.PNG`

###4. Update
send requst with a id. then it'll update the particular row.

output:
`51_jpa_update.PNG`

## ID generation

`51_hibernate _sequence.PNG`
* Here it'll generate the id by 1 and increment by 1. 
* Although we manually entered data 100 or some thing, when it adds through jpa, it begins from 1.

## RelationsShips
`53_relationShips.PNG`

# 1. Many to One
