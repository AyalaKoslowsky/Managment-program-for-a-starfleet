package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myCrewMembersAbstract implements CrewMember{

    private String name;
    private int age;
    private int yearsInService;

    public myCrewMembersAbstract(int age, int yearsInService, String name){
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    public String getName(){ return name;}
    public int getAge(){
        return age;
    }
    public int getYearsInService(){
        return yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myCrewMembersAbstract that = (myCrewMembersAbstract) o;
        return age == that.age && yearsInService == that.yearsInService && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, yearsInService);
    }
}
