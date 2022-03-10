
public abstract class Individual<T> extends Customer {
	private int numberOfDays;
	private T id;
	
	public Individual( T id,int numberOfDays,String carModel, int carModelYear, double basePrice) {
		super(carModel,carModelYear,basePrice);
		this.numberOfDays=numberOfDays;
		this.id=id;

		this.calculatePrice();
	}
	
	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}


}
