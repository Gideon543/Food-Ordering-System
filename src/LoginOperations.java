
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JTextField;

/**
 *
 * @author Gideon Bonsu
 */
public class LoginOperations {
    public static ArrayList<SignUpOperations.Staff> signedUpStaff;
    public static LinkedList<SignUpOperations.Student> signedUpStudents;
    
    public LoginOperations(){
        SignUpOperations fromSignUp = new SignUpOperations();
        this.signedUpStudents = fromSignUp.getSignedUpStudents();
        this.signedUpStaff = fromSignUp.getSignedUpStaff();
    }
    
     public void verifyStaff(JTextField userName, JTextField passWord){
	String username = userName.getText();
	String password = passWord.getText();
	for (SignUpOperations.Staff s : signedUpStaff) {
            if (username.equals(s.getName()) && password.equals(s.getPassword())){ //checks if username is valid
               this.goToAdministratorWindow();
               return;
            }	
        }
    }
    
    public void verifyStudent(JTextField userName, JTextField passWord){
        String username = userName.getText();
        String password = passWord.getText();   
        for (SignUpOperations.Student s : signedUpStudents) {
                   //verification process
            if (username.equals(s.getUsername()) && password.equals(s.getPassword())){ //checks if username is valid
                this.goToFoodSection(s); 
                return;
            }	
        }
    }
    
    public void goToSignUpWindow(){
        SignUp signUp = new SignUp();
        signUp.setVisible(true);
    }
    
    public void goToAdministratorWindow(){
        Administrator openAdminMenu = new Administrator();
        openAdminMenu.setVisible(true);
    }
    
    private void goToFoodSection(SignUpOperations.Student s){
        FoodSection openMenu = new FoodSection(s);
        openMenu.setVisible(true);
    }
   
}
