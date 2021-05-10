package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Table(name="tbl_items")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;      //(PK)

    private String itemName;
    private double itemUnitPrice;
    private int itemQuantity;

    @JsonIgnore
    @ManyToOne
    private Order order;
}
