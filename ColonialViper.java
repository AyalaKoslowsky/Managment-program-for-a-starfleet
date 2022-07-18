package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myFighterAbstract{

	private int AnnualMaintenanceCost;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);

		int TotalWeaponsCost=0;
		for (Weapon weapon: weapons){
			TotalWeaponsCost += weapon.getAnnualMaintenanceCost();
		}
		this.AnnualMaintenanceCost = 4000+Math.round(500*maximalSpeed)+(500*crewMembers.size())+TotalWeaponsCost;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return AnnualMaintenanceCost;
	}
	public String toString(){return getToStringFighterMutual();}

}
