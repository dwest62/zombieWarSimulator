/**
 * Represents a Tank subtype of Zombie.
 */
public class Tank extends Zombie {
	private static int n = 0;
	public Tank() {
		super(150, 20, "Tank " + n++);
	}
}
