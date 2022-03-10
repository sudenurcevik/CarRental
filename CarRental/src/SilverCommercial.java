
public class SilverCommercial extends Commercial{

	

	public SilverCommercial(String id, int numberOfMonths, String carModel, int carModelYear, double basePrice) {
		super(id, numberOfMonths, carModel, carModelYear, basePrice);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double discount() {
		
		return (getCalculatedPrice()/5);
	}
	
}
