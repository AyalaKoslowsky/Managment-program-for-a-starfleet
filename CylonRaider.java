package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myFighterAbstract{

	private int AnnualMaintenanceCost;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);

		int TotalWeaponsCost=0;
		for (Weapon weapon: weapons){
			TotalWeaponsCost += weapon.getAnnualMaintenanceCost();
		}
		this.AnnualMaintenanceCost = 3500+(TotalWeaponsCost)+(500*crewMembers.size())+Math.round(1200*maximalSpeed);
	}

	public int getAnnualMaintenanceCost() {
		return AnnualMaintenanceCost;
	}
	public String toString() {return getToStringFighterMutual();}
}
