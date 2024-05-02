package edu.iu.habahram.databsedemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(schema = "flowers", name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;

    private int flowerId;
    private int recipientId;
    private int orderId;
    private Date deliveryDate;
    private int recipientAddressId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getRecipientAddressId() {
        return recipientAddressId;
    }

    public void setRecipientAddressId(int recipientAddressId) {
        this.recipientAddressId = recipientAddressId;
    }
}
