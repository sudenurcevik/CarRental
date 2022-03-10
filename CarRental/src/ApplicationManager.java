import java.io.IOException;
import java.util.ArrayList;

public class ApplicationManager {
	private static ArrayList<Individual<?>> properIndividualCustomers = new ArrayList<>();
	private static ArrayList<Commercial> properCommercialCustomers = new ArrayList<>();

	private static ArrayList<Character> validTypeChars = new ArrayList<>();

	private static boolean stringNumericTest(String code) {
		for (int i = 0; i < code.length(); i++) {
			if (!Character.isDigit(code.charAt(i)))
				return false;
		}
		return true;
	}

	public static boolean isValid(String id, String type) throws Exceptions {

		validTypeChars.add('S');
		validTypeChars.add('G');
		validTypeChars.add('P');

		if (type.equals("Individual")) {
			if (id.startsWith("M") && id.length() == 12) {
				if (stringNumericTest(id.substring(1))) {
					return true;
				} else {
					throw new Exceptions();
				}
			} else if (id.length() == 11 && stringNumericTest(id)) {
				return true;
			} else {
				throw new Exceptions();
			}

		} else if (type.equals("Commercial")) {
			if (validTypeChars.contains(id.charAt(0)) && id.length() == 8 && stringNumericTest(id.substring(1))) {
				return true;
			}

			else {
				throw new Exceptions();
			}
		} else {
			throw new Exceptions();
		}

	}

	public static void createCustomers() throws IOException {
		for (String customer : FileIO.read()) {
			String[] parameters = customer.split(",");

			try {
				if (isValid(parameters[1], parameters[0])) {
					if (parameters[0].equals("Individual")) {
						if (parameters[1].startsWith("M")) {
							properIndividualCustomers.add(new IndividualMember<String>(parameters[1],
									Integer.parseInt(parameters[2]), parameters[3], Integer.parseInt(parameters[4]),
									Double.parseDouble(parameters[5])));
							// properIndividualCustomers.get(properIndividualCustomers.size()-1).calculatePrice();
						} else {
							properIndividualCustomers.add(new NonmemberIndividual<Double>(
									Double.parseDouble(parameters[1]), Integer.parseInt(parameters[2]), parameters[3],
									Integer.parseInt(parameters[4]), Double.parseDouble(parameters[5])));
						}
					} else if (parameters[0].equals("Commercial")) {
						char type = parameters[1].charAt(0);
						switch (type) {
						case 'S': {
							properCommercialCustomers.add(
									new SilverCommercial(parameters[1], Integer.parseInt(parameters[2]), parameters[3],
											Integer.parseInt(parameters[4]), Double.parseDouble(parameters[5])));
							properCommercialCustomers.get(properCommercialCustomers.size() - 1).calculatePrice();
							break;
						}
						case 'G': {
							properCommercialCustomers.add(
									new GoldCommercial(parameters[1], Integer.parseInt(parameters[2]), parameters[3],
											Integer.parseInt(parameters[4]), Double.parseDouble(parameters[5])));
							break;
						}
						case 'P': {
							properCommercialCustomers.add(new PlatiniumCommercial(parameters[1],
									Integer.parseInt(parameters[2]), parameters[3], Integer.parseInt(parameters[4]),
									Double.parseDouble(parameters[5])));
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + type);
						}
					}
				}
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (Exceptions e) {

				e.printStackTrace();
			}

		}
	}

	public static void display() {

		int commercialRentalMonth = 0;
		int silverCommercialCustomers = 0;
		int goldCommercialCustomers = 0;
		int platiniumCommercialCustomers = 0;
		int individualRentalDay = 0;
		int individualNonMemberCustomers = 0;
		int individualMemberCustomers = 0;
		int index = 1;
		int rentCode = 1000000;

		for (Commercial customer : properCommercialCustomers) {
			commercialRentalMonth += customer.getNumberOfMonths();
			if (customer.getClass().getName().equals("SilverCommercial")) {
				silverCommercialCustomers++;
			} else if (customer.getClass().getName().equals("GoldCommercial")) {
				goldCommercialCustomers++;
			} else if (customer.getClass().getName().equals("PlatiniumCommercial")) {
				platiniumCommercialCustomers++;
			}
		}

		for (Individual<?> individual : properIndividualCustomers) {
			individualRentalDay += individual.getNumberOfDays();

			if (individual.getClass().getName().equals("NonmemberIndividual")) {
				individualNonMemberCustomers++;
			} else {
				individualMemberCustomers++;
			}

		}

		System.out.println("WELCOME!!!\n");
		System.out.println("Total number of cars rented: "
				+ (properCommercialCustomers.size() + properIndividualCustomers.size()) + "\n");
		System.out.println("Total number of commercial rentals: " + properCommercialCustomers.size() + "\n");
		System.out.println("Total number of commercial rental-months: " + commercialRentalMonth + "\n");
		System.out.println("Total number of individual rentals: " + (properIndividualCustomers.size()) + "\n");
		System.out.println("Total number of individual rental-days: " + individualRentalDay + "\n");
		System.out.println("Total number of individual non-member customer: " + individualNonMemberCustomers + "\n");
		System.out.println("Total number of member customer: " + individualMemberCustomers + "\n");
		System.out.println("Total number of silver commercial customers: " + silverCommercialCustomers + "\n");
		System.out.println("Total number of gold commercial customers: " + goldCommercialCustomers + "\n");
		System.out.println("Total number of platinium commercial customers: " + platiniumCommercialCustomers + "\n\n");
		System.out.println("Individual Rentals: \n");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %20s %20s %20s %20s %20s %20s %20s", "No", "Rental Code", "Customer ID", "isMember",
				"Number of Days", "Car Model", "Model Year", "Rental Price");
		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Individual<?> individual : properIndividualCustomers) {
			String checkString = individual.getClass().getName();

			if (checkString.equals("NonmemberIndividual")) {
				checkString = "non-member";
			} else {
				checkString = "Normal member";
			}
			System.out.format("%5d %20d %20s %20s %20d %20s %20d %20f", index, rentCode, individual.getId(),
					checkString, individual.getNumberOfDays(), individual.getCarModel(), individual.getCarModelYear(),
					individual.getCalculatedPrice());
			System.out.println();
			index++;
			rentCode++;
		}

		System.out.println("\n\nCommercial Rentals: \n");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %20s %20s %20s %20s %20s %20s %20s", "No", "Rental Code", "Customer ID", "isMember",
				"Number of Days", "Car Model", "Model Year", "Rental Price");
		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");

		index = 1;
		for (Commercial commercial : properCommercialCustomers) {
			String checkString = commercial.getClass().getName();

			if (checkString.equals("SilverCommercical")) {
				checkString = "Silver member";
			} else if (checkString.equals("GoldCommercical")) {
				checkString = "Gold member";
			} else if (checkString.equals("PlatiniumCommercial")) {
				checkString = "Platinium member";
			}
			System.out.format("%5d %20d %20s %20s %20d %20s %20d %20f", index, rentCode, commercial.getId(),
					checkString, commercial.getNumberOfMonths(), commercial.getCarModel(), commercial.getCarModelYear(),
					commercial.getCalculatedPrice());
			System.out.println();
			index++;
			rentCode++;
		}

	}
}
