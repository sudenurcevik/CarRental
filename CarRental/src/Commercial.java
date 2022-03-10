
public abstract class Commercial extends Customer implements ICommercial{
	private int numberOfMonths;
	private String id;

	

	

	public Commercial(String id,int numberOfMonths,String carModel, int carModelYear, double basePrice) {
		super(carModel, carModelYear, basePrice);
		this.id=id;
		this.numberOfMonths=numberOfMonths;
		this.calculatePrice();
		
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}
	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}
	


	public void calculatePrice() {
		
		double price=0.0;
		price= getDailyPrice()*30*getNumberOfMonths();
		this.setCalculatedPrice(price);
		setCalculatedPrice(price-discount());
		
		
	}
	public abstract double discount();
	
	

}
