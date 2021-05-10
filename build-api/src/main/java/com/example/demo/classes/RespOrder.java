package com.example.demo.classes;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RespOrder extends Order {
    private Date orderDate;
    private List<Item> items;
}
