package com.lapluu.eCommerce.Model;



import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity(name = "Faq")
@Table(name = "faq")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String title,description;


    Faq(){
        this.description=null;
        this.title=null;
    }
    @Override
    public String toString() {
        return String.format(" %s, %s, %s ",
                id, title, description);
    }
}
