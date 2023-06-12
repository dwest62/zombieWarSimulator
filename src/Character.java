/**
 * Represents a base Character class.
 */
public class Character {
    private String name = "";
    private int health;
    private final int attack;

    public Character(int health, int attack){
        this.health = health;
        this.attack = attack;
    }
    
    public Character(int health, int attack, String name) {
        this.health = health;
        this.attack = attack;
        this.name = name;
    }
    
    /**
     * Set the character's health to their current health minus the value of the attack with a floor of 0.
     *
     * @param attack The amount of damage this Character will take.
     * @return The new health of the character.
     */
    public int takeDamage(int attack){
        this.health -= attack;
        if(this.health < 0){
            this.health = 0;
        }
        return this.health;
    }
    
    /**
     * Gets the character's attack stat.
     *
     * @return The int representing the character's attack stat.
     */
    public int getAttack() {
        return this.attack;
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
    
    public String getName() {
        return this.name;
    }
    
}
