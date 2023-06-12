/**
 * Represents a Tank subtype of Zombie.
 */
public class CommonInfected extends Character {
	private static int n = 0;

	public CommonInfected() {
		super(30, 5, "Common Infect " + n++);
	}
}
