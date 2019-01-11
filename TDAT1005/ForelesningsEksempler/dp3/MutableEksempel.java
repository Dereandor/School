package dp3;

public class MutableEksempel {

	private String name;

	MutableEksempel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// this setter can modify the name
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		MutableEksempel obj = new MutableEksempel("Ola");
		System.out.println(obj.getName());

		obj.setName("Hans");
		System.out.println(obj.getName());
	}
}
