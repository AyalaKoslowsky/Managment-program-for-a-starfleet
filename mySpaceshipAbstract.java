package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class mySpaceshipAbstract implements Spaceship{
    private String name;
    private int CommissionYear;
    private float MaximalSpeed;
    private int FirePower;
    private Set<? extends CrewMember> CrewMembers;
    private String toStringMutual;

    public mySpaceshipAbstract(String name, int CommissionYear, float MaximalSpeed, Set<? extends CrewMember> CrewMembers){
        this.name = name;
        this.CommissionYear = CommissionYear;
        this.MaximalSpeed = MaximalSpeed;
        this.FirePower = 10;
        this.CrewMembers = CrewMembers;
        this.toStringMutual = this.getClass().getSimpleName();
    }

    public String getName() {return name;}
    public int getCommissionYear() {return this.CommissionYear;}
    public float getMaximalSpeed() {return MaximalSpeed;}
    public int getFirePower(){return FirePower;}
    public Set<? extends CrewMember> getCrewMembers(){return CrewMembers;}
    public int getAnnualMaintenanceCost;
    public String tab = "   ";
    public String getToStringMutual() {return toStringMutual+ System.lineSeparator() +tab+ "Name=" + this.getName() + System.lineSeparator() + tab+"CommissionYear=" + this.getCommissionYear()
            + System.lineSeparator()+tab+"MaximalSpeed=" + this.getMaximalSpeed() + System.lineSeparator()+tab+"FirePower=" + this.getFirePower()
            + System.lineSeparator() + tab+"CrewMembers=" + this.getCrewMembers().size() + System.lineSeparator() +tab+"AnnualMaintenanceCost="+ this.getAnnualMaintenanceCost();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mySpaceshipAbstract that = (mySpaceshipAbstract) o;
        return CommissionYear == that.CommissionYear && Float.compare(that.MaximalSpeed, MaximalSpeed) == 0 && FirePower == that.FirePower && getAnnualMaintenanceCost == that.getAnnualMaintenanceCost && name.equals(that.name) && Objects.equals(CrewMembers, that.CrewMembers) && Objects.equals(toStringMutual, that.toStringMutual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CommissionYear, MaximalSpeed, FirePower, CrewMembers, getAnnualMaintenanceCost, toStringMutual);
    }
}
