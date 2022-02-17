
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
	 Scanner input=new Scanner(System.in);
	final static String sFILENAME="C:/Users/Aamir/Desktop/Students.txt";
	private String rollno,deptt;
	public static  List<String> booksissued=new ArrayList<String>();;
	public static List<Student> stds=new ArrayList<Student>();
	
	public static void booksIssued() {
		for(int i=0;i<Student.stds.size();i++) {
			for(int j=0;i<Student.stds.get(i).booksissued.size();j++) {
			if(Student.stds.get(i).booksissued.get(j)!=null) {
				System.out.println(Student.stds.get(i).getName()+"---HAS---"+Student.stds.get(i).booksissued.get(j));
			}
		}
			}
	}
	
	public static List<Student> readList(){
		List<Student> sts=new ArrayList<Student>();
            FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(sFILENAME);
			br=new BufferedReader(fr);
			String sCurrentLine;
			sCurrentLine=br.readLine();
			while(sCurrentLine!=null) {
				Student astd=new Student();
				String line[]=sCurrentLine.split(",");
				astd.setName(line[0]);
				astd.setRollno(line[1]);
				astd.setDeptt(line[2]);
				
				sts.add(astd);
				sCurrentLine=br.readLine();
			}fr.close();
                        br.close();
                }
		catch (IOException e) {
				e.printStackTrace();
		}
return sts;
}
	public static void saveList() {
		BufferedWriter bw=null;
		FileWriter fw=null;
		try {
			File file=new File(sFILENAME);
			if(!file.exists()) {
				file.createNewFile();
			}
			fw=new FileWriter(file.getAbsoluteFile());
			bw=new BufferedWriter(fw);
			for(int i=0;i<stds.size();i++) {
			bw.write(stds.get(i).getName()+",");
			bw.write(stds.get(i).getRollno()+",");
			bw.write(stds.get(i).getDeptt());
                        bw.newLine();
			}
                        //bw.flush();
                        bw.close();
                        fw.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			/*finally {
				try {
					if(bw!= null)
						bw.close();
					if(fw!= null)
						fw.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}*/
			}
	public static void displayStudent(int i) {
		Student a=Student.stds.get(i);
		System.out.println("| "+a.getName()+"\t\t| "+a.getRollno()+"\t\t| "+a.getDeptt());
	}
	public static void displaylist() {
		Main.hashLine();
		System.out.println("| Name              "+"| Roll No            "+" | Department                    | ");
		Main.hashLine();
		for(int i=0;i<Student.stds.size();i++) {
			displayStudent(i);
		}
		Main.hashLine();
	}

	public static List<String> addBook(int index){
		Student.booksissued.add(Book.books.get(index).getTitle());
		return booksissued;
	}
	public static int searchStudent() {
            Scanner input=new Scanner(System.in);
                 String  atitle;
            	System.out.println("Enter the name of the student.");
                atitle=input.nextLine();
		int index=-1;
		for(int i=0;i<stds.size();i++) {
		if(atitle.equalsIgnoreCase(stds.get(i).getName())){
			
			index=i;
			}
		 }
		if(index<0)
			System.out.println("Student not found!");
            if(index>=0){
                System.out.println("Student found!");
Student.displayStudent(index);}
                return index;
}
	public static List<Student> removeStudent() {
		int i=Student.searchStudent();
		if(i>=0)
			{
			stds.remove(i);
			}
		return stds;
	}
	public static void addStudent() {
		Scanner input=new Scanner(System.in);
		Student st=new Student();		
		System.out.println("Enter Name of Student:");
		st.setName(input.nextLine());
		System.out.println("Enter Roll Number of Student:  ");
		st.setRollno(input.nextLine());
		System.out.println("Enter Department of Student:  ");
		st.setDeptt(input.nextLine());
		stds.add(st);
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getDeptt() {
		return deptt;
	}
	public void setDeptt(String deptt) {
		this.deptt = deptt;
	}


}
