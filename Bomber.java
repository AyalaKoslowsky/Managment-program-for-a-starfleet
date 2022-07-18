import java.util.List;
import java.util.Set;

public class Bomber extends mySpaceshipAbstract{


	private List<Weapon> Weapons;
	private int FirePower;
	private int NumberOfTechnicians;
	private int AnnualMaintenanceCost;


	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.Weapons=weapons;
		this.NumberOfTechnicians=numberOfTechnicians;

		int TotalWeaponsFirePower=0;
		int TotalWeaponsCost=0;
		for (Weapon weapon: Weapons){
			TotalWeaponsFirePower += weapon.getFirePower();
			TotalWeaponsCost += weapon.getAnnualMaintenanceCost();
		}

		this.FirePower=10+TotalWeaponsFirePower;
		this.AnnualMaintenanceCost = 5000 + (TotalWeaponsCost-(int)(TotalWeaponsCost*(NumberOfTechnicians/10.0)));
	}

	public List<Weapon> getWeapons(){return Weapons;}
	public int getFirePower(){return FirePower;}
	public int getNumberOfTechnicians(){return NumberOfTechnicians;}
	public int getAnnualMaintenanceCost(){return AnnualMaintenanceCost;}
	public String toString(){return getToStringMutual() + System.lineSeparator() +tab+"WeaponsArray=" + this.getWeapons().toString()+
			System.lineSeparator()+tab+"NumberOfTechnicians="+ this.getNumberOfTechnicians();}
}
