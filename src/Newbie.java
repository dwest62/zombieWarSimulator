/**
 * Represents a Newbie subtype of Survivor
 */
public class Newbie extends Survivor {
	private static int n = 0;
	public Newbie() {
		super(20, 2, "Newbie " + n++);
	}
}
