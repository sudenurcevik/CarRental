
public class PlatiniumCommercial extends Commercial {
	
	

	public PlatiniumCommercial(String id, int numberOfMonths, String carModel, int carModelYear, double basePrice) {
		super(id, numberOfMonths, carModel, carModelYear, basePrice);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double discount() {
		return (getCalculatedPrice()*3/10);
	}

}
