/**
 * Represents a Survivor subtype of Character.
 *
 * Used in anticipation of future changes in distinguishing between Zombie and Survivor subtypes.
 */
public class Survivor extends Character {
	private static int n = 0;
	Survivor(int health, int attack, String name) {
		super(health, attack, name);
	}
}
