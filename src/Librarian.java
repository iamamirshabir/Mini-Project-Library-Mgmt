
import java.util.List;
import java.util.*;

public class Librarian extends Person {
	Scanner input=new Scanner(System.in);
	private String loginID,password;
	public static List<Student> issueBook(){
		Scanner input=new Scanner(System.in);
		//System.out.println("Enter the name of student.");
		int i=Student.searchStudent();
		//System.out.println("Enter book title:  ");
		//String atitle=input.nextLine();
		int j=Book.searchBook();
		if(j>0)
		Student.booksissued.add(Book.books.get(j).getTitle());
		return Student.stds;
	}
	
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 

}
