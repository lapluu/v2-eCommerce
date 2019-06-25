package com.lapluu.eCommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String login_name;
    private final String email;
    private final String password;
    private final String status;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private final Profile profile;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private final Address address;
    @CreationTimestamp
    @JsonIgnore
    private Timestamp creation_date;
    @UpdateTimestamp
    @JsonIgnore
    private Timestamp modified_date;

    User(){
        this.login_name=null;
        this.email=null;
        this.password=null;
        this.status=null;
        this.profile=null;
        this.address=null;
    }
    @Override
    public String toString() {
        return String.format(" %s, %s, %s,%s,%s ",
                login_name, email, password, status, profile);
    }
}
