package lab.four;

class Cat extends Animal {
	public Cat(String name, String species) {
		super(name, species);
	}

	public String move() {
		return "*Кот бежит*";
	}

	public String sound() {
		return "Мяу!";
	}
}
