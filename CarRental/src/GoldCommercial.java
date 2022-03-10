
public class GoldCommercial extends Commercial {
	
	
	
	
	public GoldCommercial(String id, int numberOfMonths, String carModel, int carModelYear, double basePrice) {
		super(id, numberOfMonths, carModel, carModelYear, basePrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double discount() {
		return (getCalculatedPrice()/4);
	}

}
