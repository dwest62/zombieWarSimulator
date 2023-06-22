/**
 * Represents a Survivor subtype of Character.
 *
 * Used in anticipation of future changes in distinguishing between Zombie and Survivor subtypes.
 */
public class Survivor extends Character {
	private static int n = 0;
	private Weapon weapon;
	Survivor(int health, int attack, String name) {
		super(health, attack, name);
	}

	/**
	 * If user has a weapon, use weapon's attack. Otherwise, use character's base attack
	 *
	 * @return attack value
	 */

	@Override
	public int getAttack() {
		return this.weapon != null ? weapon.getAttack() : super.getAttack();
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
