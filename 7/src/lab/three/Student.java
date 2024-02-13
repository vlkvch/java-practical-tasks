package lab.three;

class Student {
	private String fio;
	private String group;
	private byte[] grades;

	public Student(String fio, String group, byte[] grades) {
		this.fio = fio;
		this.group = group;
		this.grades = grades;
	}

	public String getInfo() {
		String info = fio + "\s" + group;
		for (byte grade : grades)
			info += "\s" + grade;
		info += "\n";
		return info;
	}
}
