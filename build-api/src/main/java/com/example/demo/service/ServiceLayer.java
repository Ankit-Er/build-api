package com.example.demo.service;

import com.example.demo.classes.CreateOrder;
import com.example.demo.classes.RespOrder;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;

    public String saveItems(List<CreateOrder> orderItem) {
        try {
            for (CreateOrder createOrder : orderItem) {
                Order order = new Order();
                order.setOrderDate(createOrder.getOrderDate());
                orderRepo.save(order);
                List<Item> allItems = readyItems(createOrder.getItems(), order);
                itemRepo.saveAll(allItems);

            }
            return "Order List Created Successfully!!";
        } catch (Exception e) {
            return "Failed !!";
        }
    }

    private List<Item> readyItems(List<Item> items, Order order) {
        List<Item> newItems = new ArrayList<>();
        for (Item i : items) {
            i.setOrder(order);
            newItems.add(i);
        }
        return newItems;
    }

    public List<RespOrder> getOrders() {
        List<RespOrder> respOrderList = new ArrayList<>();

        List<Order> orderList = orderRepo.findAll();
        for (Order o : orderList) {

            RespOrder respOrder = new RespOrder();
            respOrder.setItemList(itemRepo.findByOrderOrderId(o.getOrderId()));
            respOrder.setOrderDate(o.getOrderDate());
            respOrder.setOrderId(o.getOrderId());
            respOrder.setOrderStatus(o.isOrderStatus());

            respOrderList.add(respOrder);
        }

        return respOrderList;
    }

    public RespOrder getOrder(int orderId) {

        Order o = orderRepo.findById(orderId).orElse(null);
        if(o==null)
            return null;
        RespOrder respOrder = new RespOrder();
        respOrder.setItemList(itemRepo.findByOrderOrderId(o.getOrderId()));
        respOrder.setOrderDate(o.getOrderDate());
        respOrder.setOrderId(o.getOrderId());
        respOrder.setOrderStatus(o.isOrderStatus());

        return respOrder;
    }
}
