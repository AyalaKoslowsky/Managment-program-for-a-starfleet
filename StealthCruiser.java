package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends myFighterAbstract{

	private int AnnualMaintenanceCost;
	private static int AmountOfStealthCruiser;
	private int FirePower;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		AmountOfStealthCruiser++;
		this.AnnualMaintenanceCost = getBasicFighterCost();
		int WeaponsTotalFirePower=0;
		for (Weapon weapon: Weapons){
			WeaponsTotalFirePower += weapon.getFirePower();
		}
		this.FirePower = 10 + WeaponsTotalFirePower;
	}

	private Weapon weapon = new Weapon("Laser Cannons", 10, 100);

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name, commissionYear, maximalSpeed, crewMembers, new ArrayList<Weapon>(){
		});
		AmountOfStealthCruiser++;
		this.Weapons.add(weapon);
		this.AnnualMaintenanceCost = getBasicFighterCost() + 100;
		this.FirePower=20;
	}

	@Override
	public List<Weapon> getWeapons() {return Weapons;}
	public int getAnnualMaintenanceCost() {
		return AnnualMaintenanceCost + (AmountOfStealthCruiser * 50);
	}
	public String toString(){return getToStringFighterMutual();}
	public int getFirePower() {return FirePower;}
}
