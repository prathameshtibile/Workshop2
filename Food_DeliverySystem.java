package Food_DeliverySystem;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Food_DeliverySystem {
	
	 Scanner s = new Scanner(System.in);
	 FoodStore foodStore = FoodStore.getInstance();

	    public static void main(String[] args) {
	        System.out.println("Welcome to food delivery system.");
	        Food_DeliverySystem foodDeliverySystem = new Food_DeliverySystem();
	        foodDeliverySystem.addFoodList();
	    }

	    public void addFood() {
	        FoodItem foodItem = new FoodItem();

	        System.out.print("Enter food name: ");
	        String foodName = s.next();
	        foodName += s.nextLine();
	        foodItem.name = foodName;

	        foodItem.price = enterPrice();

	        System.out.println("Enter food taste:");
	        System.out.println("Enter 1 for Salty");
	        System.out.println("Enter 2 for Sweet");
	        System.out.println("Enter 3 for Spicy");

	        int foodTaste = s.nextInt();
	        if (foodTaste == 1) {
	            foodItem.taste = FoodItem.Taste.SALTY;
	        } else if (foodTaste == 2) {
	            foodItem.taste = FoodItem.Taste.SWEET;
	        } else if (foodTaste == 3) {
	            foodItem.taste = FoodItem.Taste.SPICY;
	        }

	        System.out.println("Enter food category: ");
	        System.out.println("Enter 1 for Starter");
	        System.out.println("Enter 2 for Main Course");
	        System.out.println("Enter 3 for Desert");
	        System.out.println("Enter 4 for Juices");

	        int foodCategory = s.nextInt();
	        if (foodCategory == 1) {
	            foodItem.foodCategory = FoodItem.Category.STARTER;
	        } else if (foodCategory == 2) {
	            foodItem.foodCategory = FoodItem.Category.MAIN_COURSE;
	        } else if (foodCategory == 3) {
	            foodItem.foodCategory = FoodItem.Category.DESERT;
	        } else if (foodCategory == 4) {
	            foodItem.foodCategory = FoodItem.Category.JUICES;
	        }

	        foodStore.add(foodItem);
	    }

	    public void addFoodList() {
	        boolean flag = true;
	        while (flag) {
	        	System.out.println("Enter 1 to add food.");
	            System.out.println("Enter 2 to display all food item.");
	            System.out.println("Enter 3 to display starter.");
	            System.out.println("Enter 4 to display main course.");
	            System.out.println("Enter 5 to display desert.");
	            System.out.println("Enter 6 to display juices.");
	            System.out.println("Enter 7 to place order.");
	            System.out.println("Enter 8 to quit/exit.");
	            int option = s.nextInt();
	            switch (option) {
	                case 1:
	                	addFood();
	                    break;
	                case 2:
	                    foodStore.displayStarter();
	                    break;
	                case 3:
	                    foodStore.displayMainCourse();
	                    break;
	                case 4:
	                    foodStore.displayDesert();
	                    break;
	                case 5:
	                    foodStore.displayJuice();
	                    break;
	                case 6:
	                	foodStore.print();
	                    break;
	                case 7:
	                    foodStore.placeOrder();
	                    break;
	                case 8:
	                    flag = false;
	                    break;
	                default:
	                    flag = false;
	                    System.out.println("Invalid input.");
	            }
	        }
	    }

	    public int enterPrice() {
	        int foodPrice = 0;
	        do {
	            try {
	                System.out.print("Enter food price : ");
	                foodPrice = s.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Enter proper input");
	            }
	            s.nextLine();
	        } while (foodPrice <= 0);
	        return foodPrice;
	    }
}

