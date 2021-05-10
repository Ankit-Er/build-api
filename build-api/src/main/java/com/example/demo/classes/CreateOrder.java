package com.example.demo.classes;

import com.example.demo.entity.Item;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateOrder {
    private Date orderDate;
    private List<Item> items;

}
