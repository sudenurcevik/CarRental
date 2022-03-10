import java.io.IOException;

public class Rent_a_CarApplication {

	public static void main(String[] args) {
		try {
			ApplicationManager.createCustomers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplicationManager.display();
	}

}
