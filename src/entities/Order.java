package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date orderTime;
    private OrderStatus orderStatus;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Date orderTime, OrderStatus orderStatus, Client client) {
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.calculateSubTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(orderTime));
        sb.append("\nOrder status: ");
        sb.append(orderStatus);
        sb.append("\nClient: ");
        sb.append(client);
        sb.append("\nOrder items:");
        for (OrderItem orderItem : orderItems) {
            sb.append(orderItem);
        }
        sb.append("\nTotal price: R$");
        sb.append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}
