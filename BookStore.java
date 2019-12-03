import java.sql.*;
import java.util.Scanner;

public class BookStore {



	public static void main(String[] args) {
		int Choice;
		
		Books NewBook = new Books(); //Book instance using the no parameter constructor 
		
		System.out.println("Select what you would like to do from the menu below, only enter the number:");
		System.out.println("1. Enter book\n2. Update book\n3. Delete book\n4. Search books\n0. Exit");
			
		Scanner UserInput = new Scanner(System.in);
		Choice = UserInput.nextInt();
		
		switch (Choice) {
			case 0: 
				System.out.println("");
				break;
				
			/*Create separate methods to ask the user to enter id, title, author and qty*/					
			case 1:  //Enter new book
				NewBook.EnterID(); //call enterID method using NewBook constructor to prompt use rot enter book ID
				NewBook.EnterTitle();
				NewBook.EnterAuthor();
				NewBook.EnterQTY();
				BookStore_DB(NewBook.getID(),NewBook.getTitle(),NewBook.getAuthor(),NewBook.getQTY());
				//	BookStore_DB(ID,Title,Author,QTY);
				break;
				
			case 2: //update book 
				NewBook.EnterID(); //call enterID method using NewBook constructor to prompt use rot enter book ID
				NewBook.EnterTitle();
				NewBook.EnterAuthor();
				NewBook.EnterQTY();
			//	BookStore_DB(ID,Title,Author,QTY);
				 break;
				 
			case 3:  //delete book
				NewBook.EnterTitle();
				//BookStore_DB(ID,Title,Author,QTY);
				break;
				
			case 4:
//				System.out.println("Please enter the Title of the book you want to search for:");
//				Scanner TitleSearch = new Scanner(System.in);
//				String Search = TitleSearch.next();
				NewBook.EnterTitle();
				//BookStore_DB(Search);
				

			
		}//end of switch
	
	}//end of method main


	private static int Choice;
	

//}	//end of class BookStore

//public static void EnterID() {
//	System.out.println("Please enter the id of the book:");
//	Scanner IDInput = new Scanner(System.in);
//	int ID = IDInput.nextInt();
//	Books.setID(ID);
	//Books BookObj = new Books(ID, null, null, 0);
		
//}//end of Enter ID method
	
	
//public static void EnterTitle() {
//	System.out.println("Please enter the Title of the book:");
//	Scanner TitleInput = new Scanner(System.in);
//	String Title = TitleInput.next();
//	Books.setTitle(Title);
//	//Books BookObj = new Books(ID, null, null, 0);
//		
//}//end of Enter Title method	
//
//public static void EnterAuthor() {
//	System.out.println("Please enter the Author of the book:");
//	Scanner AuthInput = new Scanner(System.in);
//	String Author = AuthInput.next();
//	Books.setAuthor(Author);
//	//Books BookObj = new Books(ID, null, null, 0);
//		
//}//end of Enter Author method	
//
//public static void EnterQTY() {
//	System.out.println("Please enter the Quantity of the book:");
//	Scanner QtyInput = new Scanner(System.in);
//	int QTY = QtyInput.nextInt();
//	Books.setQTY(QTY);
//	//Books BookObj = new Books(ID, null, null, 0);
//		
//}//end of Enter QTY method
	
public static void BookStore_DB(int ID, String Title, String Author, int QTY) {

		try (
			// Step 1: Allocate a database 'Connection' object
			//name of database is ebookstore
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false" , "myuser" , "Sam786!" );

			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			) {
			// Step 3 & 4: Execute a SQL INSERT|DELETE statement using executeUpdate(),
			// which returns an int indicating the number of rows affected.
			// DELETE records with id>=3000 and id<4000
			if (Choice == 1) {
				String sqlInsert = "insert into books "	+ "values (" + ID + ",'" + Title  +  "','" + Author + "'," + QTY +")";
				//System.out.println("The SQL query is: " + sqlInsert);
				int Result = stmt.executeUpdate(sqlInsert);
				//System.out.println(countInserted + " records inserted.\n");
				String strSelect = "select * from books" ;
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);
			}//end of if
			
			if (Choice == 2) {
				//must add choices to choose what to update
				int Number = 0;
				String TitleUpdate = "";
				String sqlInsert = "update books set " + ID + "=" + Number + "where " + Title + "=" + "'" + TitleUpdate +"')";

				int Result = stmt.executeUpdate(sqlInsert);
				//System.out.println(countInserted + " records inserted.\n");
				String strSelect = "select * from books" ;
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);
			}//end of if

			if (Choice == 3) {	
				String sqlDelete = "delete from books where id>=8000" ;
				int countDeleted = stmt.executeUpdate(sqlDelete);
				//System.out.println(countDeleted + " records deleted.\n");
			
				// Issue a SELECT to check the changes
				String strSelect = "select * from books" ;
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);
			}//end of if
			
			if (Choice == 4) {	
				// Issue a SELECT to check the changes
				String strSelect = "select * from books" ;
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);
				// Move the cursor to the next row
				while (rset.next()) {
					System.out.println(rset.getInt("id") + ", " + rset.getString ("author") + ", " + rset.getString("title") + ", "	+ rset.getInt("qty"));
				}//end of while
			
			}//end of if

		}//end of try
		catch (SQLException ex) {
				ex.printStackTrace();
				}
				// Step 5: Close the resources - Done automatically by try-with-resources
			
	}//end of method Bookstore_DB
}//end of class boosktore



