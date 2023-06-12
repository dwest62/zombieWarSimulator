/**
 * Represents a Zombie subtype of Character.
 *
 * Used in anticipation of future changes in distinguishing between Zombie and Survivor subtypes.
 */
public class Zombie extends Character {
	public Zombie(int health, int attack, String name) {
		super(health, attack, name);
	}
}
