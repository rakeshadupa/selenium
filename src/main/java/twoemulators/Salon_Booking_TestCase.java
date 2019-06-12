package twoemulators;



public class Salon_Booking_TestCase {

	public static void main(String[] args) {
		
	
		Runnable r1 = new Book_Salon_Customer();
		Runnable r2=new Receive_Request_Salon();
		

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

	}
}