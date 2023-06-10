import java.util.ArrayList;
import java.util.List;

public class Team {

    //characters on the team
    private final List<Character> members;
    private final List<Character> graveyard = new ArrayList<>();

    public Team(List<Character> members){
        this.members = members;
    }

    /*
    One team battles another team. It is one round. Each member on the first team attacks each member on the other team.
    Before each attack, the other team member is checked to see if they are alive. If they are, they are attacked. If
    their health after the attack is 0, they are added to the "graveyard", and removed from the otherTeam at the end
    of the battle.
     */
    public boolean battle(Team otherTeam){
<<<<<<< HEAD
        List<Character> otherTeamMembers = otherTeam.getMembers().stream().toList();
        for(Character teamMember: this.getMembers())
            for(Character otherTeamMember: otherTeamMembers)
                if(teamMember.attack(otherTeamMember) == 0) otherTeam.moveToGraveyard(otherTeamMember);
=======
        List<Character> deadList = new ArrayList<>();
        
        for(Character teamMember: this.getMembers())
            for(Character otherTeamMember: otherTeam.getMembers())
                if(otherTeamMember.isAlive()) {
                    //if(teamMember.attack(otherTeamMember) == 0) otherTeam.moveToGraveyard(otherTeamMember);
                    if (teamMember.attack(otherTeamMember) == 0) deadList.add(otherTeamMember);
                }
        for(Character deceased : deadList){
            otherTeam.moveToGraveyard(deceased);
        }
>>>>>>> d04a0693860e42bf7590908e03cf0a885028a968
        
        return otherTeam.getSize() == 0;
    }

    public int getSize(){
        return members.size();
    }
    
    public boolean moveToGraveyard(Character character) {
        this.graveyard.add(character);
        return this.getMembers().remove(character);
    }
    
    public List<Character> getGraveyard() {
        return this.graveyard;
    }

    public List<Character> getMembers(){
        return this.members;
    }
}
