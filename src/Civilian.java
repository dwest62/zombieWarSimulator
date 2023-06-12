/**
 * Represents a Civilian subtype of Survivor.
 */
public class Civilian extends Survivor {
	private static int n = 0;
	public Civilian() {
		super(50, 5, "Civilian " + n++);
	}
}
