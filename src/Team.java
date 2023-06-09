import java.util.ArrayList;
import java.util.List;

public class Team {

    //characters on the team
    private List<Character> members;

    public Team(List<Character> members){
        this.members = members;
    }

    /*
    One team battles another team. It is one round. Each member on the first team attacks each member on the other team.
    Before each attack, the other team member is checked to see if they are alive. If they are, they are attacked. If
    their health after the attack is 0, they are added to the "deadList," and removed from the otherTeam at the end
    of the battle.
     */
    public boolean battle(Team otherTeam){
        //size of attacking team
        int thisTeamLength = this.members.size();
        //size of team being attacked
        int otherTeamLength = otherTeam.getSize();

        //List of characters on team being attacked
        List<Character> otherTeamMembers = otherTeam.getMembers();
        //List of characters on team being attacked
        List<Character> deadList = new ArrayList<>();

        for(int i = 0; i < thisTeamLength; i++){
            //current attacker
            Character curThisTeam = this.members.get(i);
            for(int j = 0; j < otherTeamLength; j++){
                //current character on other team being attacked
                Character curOtherTeam = otherTeamMembers.get(j);
                //if they are still alive, they should be attacked
                if(curOtherTeam.getHealth() > 0) {
                    curThisTeam.attack(curOtherTeam);
                    //if this attack killed them, they will later need to be removed from the team
                    if(!curOtherTeam.isAlive()){
                        deadList.add(curOtherTeam);
                    }
                }
            }
        }
        //Each character that died is removed from the otherTeam
        for(Character chrctr : deadList){
            otherTeamMembers.remove(chrctr);
        }
        return true;
    }

    public int getSize(){
        return members.size();
    }

    public List<Character> getMembers(){
        return this.members;
    }
}
