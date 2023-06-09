import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieWarSimulator {
    public static void main(String[] args){
        int zombieTeamSize = generateTeamSize();
        int survivorTeamSize = generateTeamSize();

        Team teamZombie = generateZombieTeam(zombieTeamSize);
        Team teamSurvivor = generateSurvivorTeam(survivorTeamSize);

        teamSurvivor.battle(teamZombie);

        System.out.println("Zombie team size: " + teamZombie.getSize() + "\nSurvivor size: " + teamSurvivor.getSize());

    }

    public static int generateTeamSize(){
        return 1 + (int)(Math.random() *20);
    }

    public static Team generateZombieTeam(int x){
        List<Character> zombieMembers = new ArrayList<>();
        int zombieType;
        for (int i = 0; i < x; i++){
            zombieType = (int)(Math.random()*2);
            switch(zombieType){
                case 0:
                    zombieMembers.add(new CommonInfect());
                    break;
                case 1:
                    zombieMembers.add(new Tank());
                    break;
            }
        }
        return new Team(zombieMembers);
    }

    public static Team generateSurvivorTeam(int sizeTeam){
        List<Character> survivorMembers = new ArrayList<>();
        int survivorType;
        for(int i = 0; i < sizeTeam; i++){
            survivorType = (int)(Math.random() * 3);
            switch(survivorType){
                case 0:
                    survivorMembers.add(new Civilian());
                    break;
                case 1:
                    survivorMembers.add(new Mercenary());
                    break;
                case 2:
                    survivorMembers.add(new Newbie());
                    break;
            }
        }
        return new Team(survivorMembers);
    }
}
