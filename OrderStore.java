package Food_DeliverySystem;
import java.util.HashSet;
import java.util.Set;

public class OrderStore {
	 Set<Order> orderSet = new HashSet<>();
	 private static OrderStore instance;
	 
	 private OrderStore(){
		 
	 }
	 
	 synchronized static OrderStore getInstance() {
		 if(instance == null)
		 {
			 instance = new OrderStore();
		 }
		 return instance;	 
	 }

	    public void addOrder(Order order) {
	        orderSet.add(order);
	    }

	    public void display() {
	    }

}
