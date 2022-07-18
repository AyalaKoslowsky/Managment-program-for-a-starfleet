package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myFighterAbstract extends mySpaceshipAbstract{

    protected List<Weapon> Weapons;
    private int FirePower;
    private String toStringFighterMutual;
    private int basicFighterCost;

    public myFighterAbstract(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super (name, commissionYear, maximalSpeed, crewMembers);

        this.Weapons=weapons;

        int WeaponsTotalCost=0;
        for (Weapon weapon: Weapons){
            WeaponsTotalCost += weapon.getAnnualMaintenanceCost();
        }
        this.basicFighterCost=2500+(Math.round(1000*maximalSpeed))+(WeaponsTotalCost);

        int WeaponsTotalFirePower=0;
        for (Weapon weapon: Weapons){
            WeaponsTotalFirePower += weapon.getFirePower();
        }
        this.FirePower = 10 + WeaponsTotalFirePower;
        this.toStringFighterMutual = System.lineSeparator()+tab+"WeaponsArray=" + this.getWeapons().toString();
    }

    public int getAnnualMaintenanceCost;
    public List<Weapon> getWeapons() {return Weapons;}
    public int getFirePower() {return FirePower;}
    public int getBasicFighterCost() {return basicFighterCost;}
    public String getToStringFighterMutual() {return getToStringMutual() + toStringFighterMutual;}
}
