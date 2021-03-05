
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gideon Bonsu
 */
public class AdministratorOperations {
     public static ArrayList<String> availableMeals =  new ArrayList<String>(3);
     private Queue<String> ordersByStudents;
     private Object [] ordersByStudents_copy;
     
     public AdministratorOperations(){
         FoodSectionOperations fromFoodOperations = new FoodSectionOperations();
         this.ordersByStudents= fromFoodOperations.getAllOrders();
         this.ordersByStudents_copy = ordersByStudents.toArray();
     }
     
    public void goToLoginWindow(){
        OrderForm openOrderForm = new OrderForm();
        openOrderForm.setVisible(true);
    }
    
    public void displayOrderedMeals(JTextArea seeOrdersArea){
       // if (ordersByStudents_copy.){
           // seeOrdersArea.append("No Meals Ordered\n");
       // } else{
            for(int i = 0; i < ordersByStudents_copy.length; i++){
                Object mealOrdered = ordersByStudents_copy[i];
                seeOrdersArea.append(mealOrdered+"\n"+ "\n");
            }
        //}
    }
       
    public void addToAvailableMeals(JTextField mealField, JTextField priceField){
        String meal = mealField.getText();
        String price = priceField.getText();
        System.out.println(price);
        if (meal.equals("")){
            return;
        }
         Meal availableMeal = new Meal(meal,Integer.parseInt(price));
         availableMeals.add(availableMeal.toString());
    }
    
    public ArrayList getAvailableMeals(){
        return availableMeals;
    }
    
    public void clearTextFields(JTextField mealTextField, JTextField priceTextField){
        mealTextField.setText("");
        priceTextField.setText("");
    }
    
    // To create different meals.
    public class Meal {
        private String name;
        private double price;

        Meal(){}

        Meal(String name, int price){
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public void setPrice(int price){
            this.price = price;
        }
        
        public void setName(String name){
            this.name = name;
        }
         
        public String toString(){
		return "Name: " + getName() + "\n" + "Price: " + getPrice()+ " Cedis";
	}
    }

}
