
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Gideon Bonsu
 */
public class SignUpOperations {
    public static LinkedList<Student> signedUpStudents = new LinkedList<Student>();
    public static ArrayList<Staff> signedUpStaff = new ArrayList<Staff>();
    
    public SignUpOperations(){
        this.signedUpStaff.add(new Staff("Administrator","Administrator","admin"));
    }
    
    public void signInNewIndividual(JTextField nameField, JTextField userNameField, JTextField passwordField){
      String textFieldName     = nameField.getText();
      String textFieldUsername = userNameField.getText();
      String textFieldPassword = passwordField.getText();
      Student newStudent = new Student(textFieldName, textFieldUsername, textFieldPassword);
      signedUpStudents.add(newStudent);
      System.out.println(newStudent);
    }
    
    public void goToLoginWindow(){
       OrderForm window = new OrderForm();
       window.setVisible(true);
    }
    
    public LinkedList getSignedUpStudents(){
        return signedUpStudents;
    }
    
    public ArrayList getSignedUpStaff(){
        return signedUpStaff;
    }
    
    public class Student {
	private String studentName;
	private String studentUsername;
	private String password; 

	Student(){};

	Student(String studentName, String studentUsername, String password){
		this.studentName = studentName;
		this.studentUsername = studentUsername;
		this.password = password;
	}

	public String getUsername() {
		return studentUsername;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return studentName;
	}

	public void setUserName(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String studentName) {
		this.studentName = studentName;
	}

	public String toString(){
		return "Name: " + getName() + "\nUsername: " + getUsername() + "\nPassword: " + getPassword();
	}

    }
    
    public class Staff {
	private String staffName;
        private String staffUsername;
	private String password; 

	Staff(){};

	Staff(String name, String staffUsername, String password){
		this.staffName = name;
                this.staffUsername = staffUsername;
		this.password = password;
	}

	public String getName() {
		return staffName;
	}
        
        public String getUsername() {
		return staffName;
	}

	public String getPassword() {
		return password;
	}
        
	public void setUsername(String staffUsername) {
		this.staffUsername = staffUsername;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public void setName(String staffName) {
		this.staffName = staffName;
	}

	public String toString(){
		return "Name: " + getName() + "\nUsername: " + getUsername() + "\nPassword: " + getPassword();
	}

    }
}
