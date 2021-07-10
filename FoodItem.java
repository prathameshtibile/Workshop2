package Food_DeliverySystem;

public class FoodItem {
	 enum Taste {
	        SALTY, SWEET, SPICY
	  }

	    enum Category {
	        STARTER, MAIN_COURSE, DESERT, JUICES
	    }

	    int price;
	    Taste taste;
	    //    int quantity;
	    Category foodCategory;
	    String name;

	    @Override
	    public String toString() {
	        return "FoodItem{" +
	                "price=" + price +
	                ", taste='" + taste + '\'' +
//	                ", quantity=" + quantity +
	                ", foodCategory='" + foodCategory + '\'' +
	                ", name='" + name + '\'' +
	                '}';
	    }
}
