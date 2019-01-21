package dp8.arv.binding.late;

public class HumanKlient {

	public static void main(String args[]) {
		/*
		 * Reference is of Human type and object is Boy type
		 */
		Boy boy = new Boy();
		/*
		 * Reference is of HUman type and object is of Human type.
		 */
		Human human = new Human();
		boy.walk();
		human.walk();
	}
}
