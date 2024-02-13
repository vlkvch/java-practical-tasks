package lab.four;

class Fish extends Animal {
	public Fish(String name, String species) {
		super(name, species);
	}

	public String move() {
		return "*Рыбка плывет.*";
	}

	public String sound() {
		return "Бульк.";
	}
}
