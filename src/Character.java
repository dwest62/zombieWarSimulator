public class Character {
    private int health;
    private int attack;

    public Character(int health, int attack){
        this.health = health;
        this.attack = attack;
    }

    public int takeDamage(int attack){
        this.health -= attack;
        return this.health;
    }

    public int attack(Character otherCharacter){
        otherCharacter.takeDamage(this.attack);
        return otherCharacter.getHealth();
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public int getHealth(){
        return this.health;
    }
}
