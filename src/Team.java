import java.util.ArrayList;
import java.util.List;

/**
 * Represents a team of Characters.
 */
public class Team {

    //characters on the team
    private final List<Character> members;
    private final List<Character> graveyard = new ArrayList<>();
    
    /**
     * Constructs a team using the provided List of Characters.
     *
     * @param members The List of Characters who are members of the team.
     */
    public Team(List<Character> members){
        this.members = members;
    }
    
    
    /**
     * Initiates a round of battle between this team and the provided defending team. This team attacks each member
     * of the defending team damaging them according to sum of the attack power of the members in this team. If an
     * opposing team member's health drops to 0, they are moved from members to the graveyard
     * {@link #moveToGraveyard(Character defender)}.
     *
     * @param defenderTeam The team which will be attacked.
     * @return True if no members of the defending team remain alive, otherwise false.
     */
    public boolean battle(Team defenderTeam){
        // Creates a copy of the defender team members so that the original may be modified during iteration.
        List<Character> defenders = new ArrayList<>(defenderTeam.getMembers());
   
        // The sum of the attack power of each character in this team.
        int totalTeamAttackPower = this.getMembers().stream()
            .reduce(0, (accum, c) -> accum + c.getAttack(), Integer::sum);
        
        // Loops over each defender and checks if they are dead (in the graveyard). If they are not, they take damage
        // equal to this team's total attack power.
        for(Character defender: defenders)
            if (!defenderTeam.getGraveyard().contains(defender) && defender.takeDamage(totalTeamAttackPower) == 0)
                defenderTeam.moveToGraveyard(defender);
        
        return defenderTeam.getSize() == 0;
    }
    
    /**
     * Get the count of alive members in the team.
     *
     * @return The int representing the number of alive team members.
     */
    public int getSize(){
        return members.size();
    }
    
    /**
     * Moves a Character from the list of team members to the list of fallen members termed the "graveyard".
     *
     * @param character The character who has fallen.
     */
    public void moveToGraveyard(Character character) {
        this.graveyard.add(character);
        this.getMembers().remove(character);
    }
    
    /**
     * Returns a list of Characters representing fallen team members.
     *
     * @return The list of fallen team members.
     */
    public List<Character> getGraveyard() {
        return this.graveyard;
    }
    
    /**
     * Returns a List of Characters representing team members (who are alive).
     *
     * @return The list of team members.
     */
    public List<Character> getMembers(){
        return this.members;
    }
}
