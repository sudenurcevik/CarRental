
public class IndividualMember<T> extends Individual<T> implements IMember{

	public IndividualMember(T id, int numberOfDays, String carModel, int carModelYear, double basePrice) {
		super(id, numberOfDays, carModel, carModelYear, basePrice);
		
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void calculatePrice() {
		double price=0.0;
		price= getNumberOfDays()*getDailyPrice();
		this.setCalculatedPrice(price);
		setCalculatedPrice(price-discount());
		
	}

	@Override
	public double discount() {
		// TODO Auto-generated method stub
		return (getCalculatedPrice()/10);
	}
	

}
