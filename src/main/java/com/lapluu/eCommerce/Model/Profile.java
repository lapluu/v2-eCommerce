package com.lapluu.eCommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;



@Data
@Entity
//@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
//@Table(name="users_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "last_name")
    private final String  lastName;
   // @Column(name = "first_name")
    private final String  firstName;
    private final Gender gender;
    private @JsonIgnore @LastModifiedDate Timestamp modified_date;

    public static enum Gender {
        MALE, FEMALE;
    }
    Profile() {
        this.lastName = null;
        this.firstName = null;
        this.gender = null;
    }
    @Override
    public String toString() {
        return String.format(" %s, %s, %s ",
                lastName, firstName, gender.name());
    }
}
