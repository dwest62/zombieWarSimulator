public enum Weapon {
	AXE("Axe",30, 1),
	PISTOL("Pistol", 50, .80),
	SHOTGUN("Shotgun",100, .50);
	
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
		return Math.random() > accuracy;
	}
	
	public static Weapon getRandom() {
		return values()[(int) (Math.random()*(values().length - 1))];
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
