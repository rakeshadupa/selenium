package twoemulators;

public class Stylist_Booking_TestCase {

	public static void main(String[] args) {
		
	
		
	
		Runnable r1=new Book_Stylist_Customer();
		Runnable r2=new Receive_Request_stylist();
		Thread a1=new Thread(r1);
		Thread a2=new Thread(r2);
		a1.start();
		a2.start();
		
	
	}
}
