import java.util.random.RandomGenerator;

public enum Weapon {
	AXE("Axe",20, .90),
	PISTOL("Pistol", 40, .75),
	SHOTGUN("Shotgun",90, .45);
	
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
