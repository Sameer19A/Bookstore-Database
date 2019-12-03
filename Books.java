import java.util.Scanner;

public class Books {
	private static int ID;
	private static String Title;
	private static String Author;
	private static int QTY;
	
	
	public Books() {
		//empty constructor that does not take any arguments
	}
	
	
	public Books(int BookID, String title, String author, int quantity) {
		ID = BookID;
		Title = title;
		Author = author;
		QTY = quantity;
	}//end of constructor books
	
	
	public static void setID (int BookID) {
		ID = BookID;
	}//
	
	public static void setTitle (String title) {
		Title = title;
	}//
	
	public static void setAuthor (String author) {
		Author = author;
	}//
	
	public static void setQTY (int quantity) {
		QTY = quantity;
	}//
	
	public int getID() {
		return ID;
	}//end of getID
	
	
	public String getTitle() {
		return Title;
	}//
	
	public String getAuthor() {
		return Author;
	}//
	
	public int getQTY() {
		return QTY;
	}//
	
	
//	public String toString() {
//		return String.format("");
//	}//end of toString method
	
	public void EnterID() {
		System.out.println("Please enter the id of the book:\n");
		Scanner IDInput = new Scanner(System.in);
		int ID = IDInput.nextInt();
		Books.setID(ID);
	}//end of Enter ID method
	
	public void EnterTitle() {
		System.out.println("Please enter the Title of the book:");
		Scanner TitleInput = new Scanner(System.in);
		String Title = TitleInput.next();
		Books.setTitle(Title);
		//Books BookObj = new Books(ID, null, null, 0);
			
	}//end of Enter Title method	

	public void EnterAuthor() {
		System.out.println("Please enter the Author of the book:");
		Scanner AuthInput = new Scanner(System.in);
		String Author = AuthInput.next();
		Books.setAuthor(Author);
		//Books BookObj = new Books(ID, null, null, 0);
			
	}//end of Enter Author method	

	public void EnterQTY() {
		System.out.println("Please enter the Quantity of the book:");
		Scanner QtyInput = new Scanner(System.in);
		int QTY = QtyInput.nextInt();
		Books.setQTY(QTY);
		//Books BookObj = new Books(ID, null, null, 0);
			
	}//end of Enter Author method
	
	
	
}//end of class books
