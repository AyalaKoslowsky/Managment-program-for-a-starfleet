import java.util.List;
import java.util.Set;

public class Fighter extends myFighterAbstract {

	private int AnnualMaintenanceCost;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super (name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.AnnualMaintenanceCost = getBasicFighterCost();
	}
	public int getAnnualMaintenanceCost() {return AnnualMaintenanceCost;}
	public String toString() {return getToStringFighterMutual();}
}
