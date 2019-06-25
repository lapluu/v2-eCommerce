package com.lapluu.eCommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Data
@Entity(name = "Category")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String name , subCategory, imagePath;

    Category(){
        this.name=null;
        this.subCategory=null;
        this.imagePath=null;
    }
    public String toString() {
        return String.format("%s, %s %s",
                name, subCategory, imagePath);
    }
}
