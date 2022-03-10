
@SuppressWarnings("serial")
public class Exceptions extends Exception {
	public Exceptions() {
		super();
	}
	
	public Exceptions(String messageString) {
		super(messageString);
	}
	
	
	public void printStackTrace() {
		
		System.out.println("Invalid Customer ID");
	}
	
	
}
