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
	public int getAttack() {
		return isHit() ? this.attack : 0;
	}
	
	public boolean isHit() {
		return Math.random() <= accuracy;
	}
	
	public static Weapon getRandom() {
		return values()[RandomGenerator.getDefault().nextInt(0, values().length)];
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
