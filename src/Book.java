
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
	final static String FILENAME="C:/Users/Aamir/Desktop/Book.txt";
	Scanner input=new Scanner(System.in);
	public String title,author,publisher,ID;
	public int price;
	static List<Book> books= new ArrayList<Book>();
	public static List<Book> readList(){
            List<Book> bks= new ArrayList<Book>();
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			String sCurrentLine;
			sCurrentLine=br.readLine();
			while(sCurrentLine!=null) {
				Book abook=new Book();
				String line[]=sCurrentLine.split(",");
				abook.setID(line[0]);
				abook.setTitle(line[1]);
				abook.setAuthor(line[2]);
				abook.setPublisher(line[3]);
				String a=line[4];
				abook.setPrice(Integer.parseInt(a));
				bks.add(abook);
				sCurrentLine=br.readLine();
			}fr.close();
                        br.close();
                }
		catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error! csv file not found at >>"+FILENAME);
		}
return bks;
}
	public static void saveList() {
		BufferedWriter bw=null;
		FileWriter fw=null;
		try {
			File file=new File(FILENAME);
                        if(!file.exists()) {
				file.createNewFile();
			}
                        fw=new FileWriter(file.getAbsoluteFile(),false);
			
                      bw=new BufferedWriter(fw);
			for(int i=0;i<books.size();i++) {
			bw.write(books.get(i).getID()+",");
			bw.write(books.get(i).getTitle()+",");
			bw.write(books.get(i).getAuthor()+",");
			bw.write(books.get(i).getPublisher()+",");
			bw.write(books.get(i).getPrice()+"");
			bw.newLine();
                        }
                        //bw.flush();
                        bw.close();
            }
			catch(IOException e) {
				e.printStackTrace();
			}/*
			finally {
				try {
					if(bw!= null)
						bw.close();
					if(fw!= null)
						fw.close();
				}
				catch(IOException e) {
					e.printStackTrace();
                }	}*/
			
			}
	public static void displayBook(int i) {
		Book b=Book.books.get(i);
		System.out.println("| "+b.getID()+"   \t\t| "+b.getTitle()+"\t\t| "+b.getAuthor()+"\t\t| "+b.getPublisher()+"\t\t| "+b.getPrice());
	}

	public static List<Book> addBook() {
		Scanner input=new Scanner(System.in);
		Book b=new Book();
		System.out.println("Enter title of the Book:  ");
		b.setTitle(input.nextLine());
		System.out.println("Enter author's of the Book:  ");
		b.setAuthor(input.nextLine());
		System.out.println("Enter publisher of the Book:  ");
		b.setPublisher(input.nextLine());
		System.out.println("Enter price of the Book:  ");
		b.setPrice(input.nextInt());
		b.setID("ULB0"+(books.size()+1));
		books.add(b);
		return books;
	}
	
	public static int searchBook() {
            Scanner input=new Scanner(System.in);
            System.out.println("Enter title of the Book:");
            String atitle=input.nextLine();
		int index=-1;
		for(int i=0;i<books.size();i++) {
			if(atitle.equalsIgnoreCase(books.get(i).getTitle())) {

				index=i;
			}
			else {
			}
		}if(index==-1)
			System.out.println("Book is not found!");
if(index>=0) {
	System.out.println("Book found!");
	Book.displayBook(index);}	
	return index;
	}
	public static List<Book> replaceBook() {
		int j=Book.searchBook();
		if(j>=0)
			{
			books.remove(j);
			books=Book.addBook();}
		else 
			System.out.println("Book not found!");
		return books;
	}
	public static void displayList(){
		Main.hashLine();
		System.out.println("| Book ID"+"               "+"| Title "+"               "+"| Author"+"               "+"| Pubisher"+"               "+"| Price                |");
		Main.hashLine();
        for(int i=0;i<books.size();i++)
        	Book.displayBook(i);
        Main.hashLine();
	}
	public static List<Book> removeBook() {
		int i=Book.searchBook();
		if(i>0)
			{
			books.remove(i);
			}
		return books;}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
