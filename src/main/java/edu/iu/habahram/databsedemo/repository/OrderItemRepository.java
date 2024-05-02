package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    @Query("SELECT oi FROM OrderItem oi " +
            "JOIN Order o ON oi.orderId = o.id " +
            "JOIN Customer c ON o.customerUserName = c.username " +
            "WHERE c.username = :username")
    List<OrderItem> findOrderItemsByCustomerUserName(@Param("username") String username);
}