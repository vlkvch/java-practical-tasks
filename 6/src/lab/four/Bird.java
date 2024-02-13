package lab.four;

class Bird extends Animal {
	public Bird(String name, String species) {
		super(name, species);
	}

	public String move() {
		return "*Птица летит*";
	}

	public String sound() {
		return "*Звук птицы*";
	}
}
