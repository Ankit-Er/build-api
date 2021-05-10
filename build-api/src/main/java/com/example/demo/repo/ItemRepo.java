package com.example.demo.repo;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {

    //@Query("from Order where orderId =: orderId")
    List<Item> findByOrderOrderId(@Param("orderId") Integer orderId);

}
