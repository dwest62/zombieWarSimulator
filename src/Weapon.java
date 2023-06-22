import java.util.random.RandomGenerator;

public enum Weapon {
	ASSAULTRIFLE("Assault Rifle", 70, .65),
	AXE("Axe",20, .90),
	CROWBAR("Crowbar", 17, .92),
	PISTOL("Pistol", 30, .75),
	SHOTGUN("Shotgun",80, .45);
	
	
	
	private final int attack;
	private final double accuracy;
	private final String name;

	Weapon(String name, int attack, double accuracy) {
		this.attack = attack;
		this.accuracy = accuracy;
		this.name = name;
	}


	//If player hits target, attack is returned. Otherwise, it's a miss - no attack returned
	public int getAttack() {
		return isHit() ? this.attack : 0;
	}

	/*
	Returns random accuracy between 0-1.
	Hit example: Axe has an accuracy of .9, Method returns .8
	Miss example: Axe has an accuracy of .9, Method returns .95
	 */
	public boolean isHit() {
		return Math.random() <= accuracy;
	}

	//Picks a random weapon from the enum list and returns it
	public static Weapon getRandom() {
		return values()[RandomGenerator.getDefault().nextInt(0, values().length)];
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
