package com.pipi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * This call contain jpa configurations
 */

@Data   //  lombok
@AllArgsConstructor //  lombok
@NoArgsConstructor  //  lombok
@Entity     //  data jpa
public class UserJPA {

    /* make this a primary key**/
    @Id     //  data jpa
    @GeneratedValue
    private int id;

    private String name;

    private Date birthDate;

    /**generate setters and getters*/
}
