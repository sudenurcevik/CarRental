
public class NonmemberIndividual<T> extends Individual<T> {

	public NonmemberIndividual(T id, int numberOfDays, String carModel, int carModelYear, double basePrice) {
		super(id, numberOfDays, carModel, carModelYear, basePrice);
	}

	@Override
	public void calculatePrice() {
		// TODO Auto-generated method stub
		setCalculatedPrice((getNumberOfDays()*getDailyPrice()));
	}

}
