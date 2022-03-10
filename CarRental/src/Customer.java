
public abstract class Customer implements ICustomer {

	private String carModel;
	private int carModelYear;
	private double basePrice;
	private double calculatedPrice;
	private double dailyPrice;
	
	

	public Customer(String carModel, int carModelYear, double basePrice) {
		super();
		this.carModel = carModel;
		this.carModelYear = carModelYear;
		this.basePrice = basePrice;
		this.dailyPrice=this.getBasePrice()*this.calculateYearRatio();
		
		
		
	}

	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public int getCarModelYear() {
		return carModelYear;
	}


	public void setCarModelYear(int carModelYear) {
		this.carModelYear = carModelYear;
	}


	public double getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}



	
	public double getCalculatedPrice() {
		return calculatedPrice;
	}


	public void setCalculatedPrice(double calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}
	
	
	public double getDailyPrice() {
		return dailyPrice;
	}


	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}



	public double calculateYearRatio() {
		double modelYearRatio=0;
		if (getCarModelYear()==2022) {
			modelYearRatio=1;
		}
		else if (getCarModelYear() == 2020 || getCarModelYear()==2021) {
			modelYearRatio=0.95;
		}
		else if (getCarModelYear()>=2017 && getCarModelYear()<=2019) {
			modelYearRatio=0.9;
		}
		return modelYearRatio;
	}
	
	
}
