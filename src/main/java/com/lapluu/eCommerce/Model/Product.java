package com.lapluu.eCommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String name, description, color, size;
    private final double price;
    private final ProductStatus status;
    private final int quantity;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private final Category category ;
    @CreationTimestamp
    @JsonIgnore
    private Timestamp creation_date;
    @CreationTimestamp
    @JsonIgnore
    private Timestamp modified_date;

    public static enum ProductStatus{
        INSTOCK,
        OUTOFSTOCK,
        BACKLOG,
        AVAILABLE,
        NEEDORDER
    }

    Product(){
        this.name = null;
        this.description = null;
        this.color=null;
        this.status=null;
        this.quantity=0;
        this.price = 0.0;
        this.size=null;
        this.category=null;
    }
    @Override
    public String toString() {
        return String.format(" %s, %s, %s,%s,%s, %s,%s , $s",
                name, description, color, status, quantity, price,size, category);
    }

}
