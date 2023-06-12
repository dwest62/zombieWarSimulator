import java.util.ArrayList;
import java.util.List;

/**
 * Simulates a war between Zombies and Survivors. Generates a random team of zombies and a random team of survivors.
 * The teams then battle until there is a victor.
 */
public class ZombieWarSimulator {
	/**
	 * Main entry point to the application.
	 */
	public static void main(String[] args) {
		
		// Give each team a random size.
		int zombieTeamSize = generateTeamSize();
		int survivorTeamSize = generateTeamSize();
		
		// Generate random teams of zombies and survivors.
		Team teamZombie = generateZombieTeam(zombieTeamSize);
		Team teamSurvivor = generateSurvivorTeam(survivorTeamSize);
		
		// Report initial sizes to user.
		System.out.print("There are " + survivorTeamSize + " survivors trying to make it to safety.");
		System.out.print(" ("+ teamSurvivor.getMembers().stream()
			.filter(m -> m.getClass().equals(Newbie.class))
			.count()+ " Newbies, ");
		System.out.print(teamSurvivor.getMembers().stream()
			.filter(m -> m.getClass().equals(Civilian.class))
			.count()+ " Civilians, ");
		System.out.print(teamSurvivor.getMembers().stream()
			.filter(m -> m.getClass().equals(Mercenary.class))
			.count()+ " Mercenaries");
		System.out.println(")");
		System.out.print("But, there are " + zombieTeamSize + " zombies waiting for them. (");
		System.out.print(teamZombie.getMembers().stream()
			.filter(m -> m.getClass().equals(CommonInfect.class))
			.count()+ " Common Infected, ");
		System.out.println(teamZombie.getMembers().stream()
			.filter(m -> m.getClass().equals(Tank.class))
			.count()+ " Tanks)");
		
		
		// The survivors start.
		TeamType currTeam = TeamType.SURVIVOR;
		
		// Begin the war, looping until a team has no survivors.
		boolean warOver = false;
		while(!warOver) {
			// Have the current team take their turn battling the other.
			warOver = currTeam.equals(TeamType.SURVIVOR) ? teamSurvivor.battle(teamZombie) :
				teamZombie.battle(teamSurvivor);
			
			// Flip the teams. The defenders will be the attackers and vice versa.
			currTeam = currTeam.equals(TeamType.SURVIVOR) ? TeamType.ZOMBIES : TeamType.SURVIVOR;
		}
		
		// Report how many (if any) survivors made it out alive.
		System.out.println("It seems " + teamSurvivor.getSize() +
			(teamSurvivor.getSize() == 1 ? " has " : " have ") + "made it to safety.");
	}
	
	/**
	 * Generates an int between 1 and 20 to randomize the team size.
	 *
	 * @return A random int between 1 and 20.
	 */
	public static int generateTeamSize(){
		return 1 + (int)(Math.random() *20);
	}
	
	/**
	 * Generates a random team of zombies of various subtypes.
	 *
	 * @param size The size of the team.
	 * @return The random team of zombie characters.
	 */
	public static Team generateZombieTeam(int size){
		List<Character> zombieMembers = new ArrayList<>();
		int zombieType;
		for (int i = 0; i < size; i++){
			zombieType = (int)(Math.random()*2);
			switch (zombieType) {
				case 0 -> zombieMembers.add(new CommonInfect());
				case 1 -> zombieMembers.add(new Tank());
			}
		}
		return new Team(zombieMembers);
	}
	
	/**
	 * Generates a random team of survivors of various subtypes.
	 *
	 * @param size The size of the team.
	 * @return The random team of survivors.
	 */
	public static Team generateSurvivorTeam(int size){
		List<Character> survivorMembers = new ArrayList<>();
		int survivorType;
		for(int i = 0; i < size; i++){
			survivorType = (int)(Math.random() * 3);
			switch (survivorType) {
				case 0 -> survivorMembers.add(new Civilian());
				case 1 -> survivorMembers.add(new Mercenary());
				case 2 -> survivorMembers.add(new Newbie());
			}
		}
		return new Team(survivorMembers);
	}
	
}