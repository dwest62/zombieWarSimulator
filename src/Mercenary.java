/**
 * Represents a Mercenary subtype of Survivor.
 */
public class Mercenary extends Survivor {
	private static int n = 0;
	public Mercenary() {
		super(100, 10, "Mercenary " + n++);
	}
}
