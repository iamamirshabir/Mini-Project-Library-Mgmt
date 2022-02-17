
import java.util.*;

public class Main {
    
public static void main(String args[])
{
    Scanner input = new Scanner(System.in);
char ch1 = '0',ch2= '0',ch3 ='0',ch4= '0',ch ='Y';
hashLine();
hashLine();
System.out.println("Welcome!");
System.out.println("»To make choices you are only allowed to make digit choices.");
System.out.println("»IMPORTANT! if records are modified, you need to save them before program is closed or machine shut down.");
Student.stds=Student.readList();
Book.books=Book.readList();
do {
	do{
		hashLine();
System.out.println("1. To Manage books:");
System.out.println("2. To issue a Book:");
System.out.println("3. To Manage Student Records:");
System.out.println("4. To view Financial record:");
System.out.println("0. To exit.");
hashLine();
ch1= input.next().charAt(0);}
while(ch1<'0'||ch1>'4');
switch(ch1){
case '1':{
	do {hashLine();
System.out.println("1. To search a book.");
System.out.println("2. To update a book. ");
System.out.println("3. To remove a book. ");
System.out.println("4. To add book:");
System.out.println("5. To save record:");
System.out.println("6. To display list:");

ch2= input.next().charAt(0);
hashLine();
switch(ch2) {
case '1':{
	Book.searchBook();}
	break;
case '2':{
	Book.replaceBook();}
	break;
case '3':{
	Book.removeBook();}
	break;
case '4':
	Book.addBook();
	break;
case '5':
	Book.saveList();
	System.out.println("Done.");
	break;
case '6':
	System.out.println("Done! ");
	Book.displayList();
	break;
}}
	while(ch2<'1'||ch2>'6');
}	break;
case '2':
	Librarian.issueBook();
	break;
case '3':{
	do {hashLine();
System.out.println("1. To add a student.");
System.out.println("2. To remove a student:");
System.out.println("3. To search a student:");
System.out.println("4. To save List");
System.out.println("5. To display List");
ch3= input.next().charAt(0);
	}while(ch3<'1'||ch3>'5');
	switch(ch3) {
	case '1':
		Student.addStudent();
		break;
	case '2':
		Student.removeStudent();
		break;
	case '3':
		Student.searchStudent();
		break;
	case '4':
		Student.saveList();
		break;
	case '5':
		Student.displaylist();
	}
	}break;
case '4':{
	do {	hashLine();
System.out.println("1. To calculate stock price.");
System.out.println("2. To add funds:");
System.out.println("3. To add expenses:");
System.out.println("4. To check account balance");
           ch4= input.next().charAt(0);
       	hashLine();
	}
	while(ch4<'1'||ch4>'4');
	switch(ch4) {
	case '1':
		Cash.calStock();
		System.out.println("Total value=  "+Cash.stockprice);
		break;
	case '2':
		Cash.addFunds();
		System.out.println("Done!");
		break;
	case '3':
		Cash.minusExp();
		System.out.println("Done");
		break;
	case '4':
		System.out.println("Total balance= "+Cash.balance);
		break;
	}break;

}
}
//Student.booksIssued();
ch=cont();
}
while(ch=='Y'||ch=='y');
}
public static void hashLine() {
	System.out.println(">------------------------------------------------------------------------------------------------------------<");
}
public static char cont() {
	Scanner input=new Scanner(System.in);
	char temp;
	do {
	System.out.println(">> Do you wanna continue?  (Y/N)");
 temp=	input.next().charAt(0);
if(temp!='Y'&&temp!='y'&&temp!='N'&&temp!='n')
	System.out.println("Invalid Choice!MAKE SENSE.");
}
while(temp!='Y'&&temp!='y'&&temp!='N'&&temp!='n');
return temp;
}
}
