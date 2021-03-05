
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JTextArea;

/**
 *
 * @author Gideon Bonsu
 */
public class FoodSectionOperations {
     public static Queue<String> allOrdersFromStudents = new LinkedList<String>();
     private SignUpOperations.Student loggedInStudent;
     private ArrayList<String> availableMeals;
     private OrdersByStudent studentOrders;
     
     public FoodSectionOperations(SignUpOperations.Student loggedInStudent){
        AdministratorOperations fromAdministrator = new  AdministratorOperations();
        this.studentOrders = new OrdersByStudent(loggedInStudent);
        this.availableMeals = fromAdministrator.getAvailableMeals();
        this.loggedInStudent = loggedInStudent;  
     }
     
     public FoodSectionOperations(){
     
     }
     
     public void goToLoginWindow(){
        OrderForm openOrderForm = new OrderForm();
        openOrderForm.setVisible(true);
    }
    
    public void displayStudentOrders(JTextArea seeOrdersArea){
         
        if (studentOrders == null){
            seeOrdersArea.append("No Ordered Meals Available.\n");
            return;
        } else{
            Queue<String> ordersByStudent = studentOrders.getStudentOrders();
            for(int i = 0; i < ordersByStudent.size(); i++){
                String mealOrdered = ordersByStudent.peek();
                seeOrdersArea.append(mealOrdered+"\n");
                ordersByStudent.remove();
            }
        }
    }
    
    public void displayAvailableMeals(JTextArea textArea, int index){
        if (availableMeals.isEmpty()){
            textArea.append("No Meal Available.\n");
        } else{
            textArea.append(availableMeals.get(index));
        }
    }
    
    public void addOrder(JTextArea textArea){
        String fieldText = textArea.getText();
        if(studentOrders == null && loggedInStudent == null){
            allOrdersFromStudents.add(fieldText + "\nOrdered by: Unknown Student");
        } else if(fieldText.equals("No Meal Available.\n") && studentOrders != null){
            return;
        } else{
            studentOrders.placeOrder(fieldText);
            allOrdersFromStudents.add(fieldText + "\nOrdered by: " + this.loggedInStudent.getName());
        }
    }
    
    public Queue getAllOrders(){
        return allOrdersFromStudents;
    }
 
    public class OrdersByStudent {
        Queue<String> studentOrders = new LinkedList<String>(); //for storing the orders	
        SignUpOperations.Student student;
        
        OrdersByStudent(){}

	OrdersByStudent(SignUpOperations.Student s) {
                this.student = s;
	}

	//Placing the order
	public void placeOrder(String s) {
            studentOrders.add(s + "  " + "\nOrdered By: "+ student.getName()+ "\n");
	}
        
        public Queue<String> getStudentOrders(){
            return studentOrders;
        }
        
    }
}
