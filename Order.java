package Food_DeliverySystem;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
	 public enum OrderStatus {
	        PENDING, DELIVERED;
	    }

	    HashMap<FoodItem, Integer> orderList = new HashMap<>();
	    private Integer totalPrice;
	    private String deliveryAddress;
	    private Integer orderId;
	    private OrderStatus orderStatus = OrderStatus.PENDING;


	    public Integer getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(Integer orderId) {
	        this.orderId = orderId;
	    }

	    public int calculateTotalPrice() {
//	        int x = orderList.entrySet().stream().map(item -> item.getKey().price).reduce(0, (total, item) -> total + item);
	        int totalPrice = orderList.entrySet().stream().map(item -> item.getKey().price * item.getValue()).reduce(0, (total, item) -> total + item);
	        return totalPrice;
	    }


	    public Integer getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(Integer totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public String getDeliveryAddress() {
	        return deliveryAddress;
	    }

	    public void setDeliveryAddress(String deliveryAddress) {
	        this.deliveryAddress = deliveryAddress;
	    }

	    @Override
	    public String toString() {
	        return "Order{" +
	                "totalPrice=" + totalPrice +
	                ", deliveryAddress='" + deliveryAddress + '\'' +
	                ", orderId=" + orderId +
	                ", orderStatus=" + orderStatus +
	                '}';
	    }
}

