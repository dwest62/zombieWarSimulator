/**
 * Represents a Tank subtype of Zombie.
 */
public class CommonInfect extends Character {
	private static int n = 0;

	public CommonInfect() {
		super(30, 5, "Common Infect " + n++);
	}
}
