package Food_DeliverySystem;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class FoodStore {
	  Scanner scanner = new Scanner(System.in);
	  Set<FoodItem> foodList = new HashSet<>();
	  OrderStore orderStore = OrderStore.getInstance();
	    
	    private static FoodStore instance;

	    private FoodStore()
	    {
	    	
	    }
	    
	    synchronized static FoodStore getInstance() {
			 if(instance == null)
			 {
				 instance = new FoodStore();
			 }
			 return instance;	 
		 }
	    

	    public void add(FoodItem foodItem) {
	        foodList.add(foodItem);
	    }

	    public void remove(FoodItem foodItem) {
	        foodList.remove(foodItem);
	    }

	    public void displayStarter() {
	        foodList.stream().filter(x -> x.foodCategory == FoodItem.Category.STARTER).forEach(System.out::println);
	    }

	    public void displayMainCourse() {
	        foodList.stream().filter(x -> x.foodCategory == FoodItem.Category.MAIN_COURSE).forEach(System.out::println);
	    }

	    public void displayDesert() {
	        foodList.stream().filter(x -> x.foodCategory == FoodItem.Category.DESERT).forEach(System.out::println);
	    }

	    public void displayJuice() {
	        foodList.stream().filter(x -> x.foodCategory == FoodItem.Category.JUICES).forEach(System.out::println);
	    }

	    public void print() {
	        foodList.stream().forEach(System.out::println);
	    }

	    public void placeOrder() {
	        Order order = new Order();
	        boolean flag = true;

	        System.out.print("Enter your order ID : ");
	        order.setOrderId(scanner.nextInt());

	        System.out.print("Enter delivery address : ");
	        scanner.nextLine();
	        String address = scanner.nextLine();
	        order.setDeliveryAddress(address);

	        while (flag) {
	            System.out.println("Press 1 to place order\nPress 2 to exit");
	            int ch = scanner.nextInt();
	            if (ch == 1) {
	                System.out.print("Enter a food name : ");
	                String foodName = scanner.next();

	                FoodItem foodItem = getFoodItem(foodName);

	                System.out.print("Enter quantity : ");
	                int quantity = scanner.nextInt();
	                order.orderList.put(foodItem, quantity);

	            } else {
	            	break;
	               // flag = false;
	                
	            }
	        }
	        order.setTotalPrice(order.calculateTotalPrice());
	        System.out.println("Order placed successfully");
	        orderStore.addOrder(order);
	       // System.out.println(orderStore);
	        
	    }

	    public FoodItem getFoodItem(String foodName) {
	        for (FoodItem foodItem : foodList) {
	            if (foodItem.name.equals(foodName)) {
	                return foodItem;
	            }
	        }
	        return null;
	    }
}
