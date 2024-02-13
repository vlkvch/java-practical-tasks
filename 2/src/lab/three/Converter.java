package lab.three;

class Converter {
	private double sum;

	public Converter(double sum) {
		this.sum = sum;
	}

	public double convertTo(String val) {
		double converted = 0;

		switch(val) {
			case "RUB":
				converted = sum * 32.29;
				break;
			case "USD":
				converted = sum * 0.4;
				break;
			case "EUR":
				converted = sum * 0.36;
				break;
			case "UAH":
				converted = sum * 14.63;
				break;
		}

		return converted;
	}
}
