package il.ac.tau.cs.sw1.ex9.starfleet;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Set;

public class TransportShip extends mySpaceshipAbstract{

	private int CargoCapacity;
	private int PassengerCapacity;
	private int AnnualMaintenanceCost;


	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super (name, commissionYear, maximalSpeed, crewMembers);
		this.CargoCapacity = cargoCapacity;
		this.PassengerCapacity = passengerCapacity;
		this.AnnualMaintenanceCost = 3000+(5*CargoCapacity)+(3*passengerCapacity);
	}

	public int getCargoCapacity() {return CargoCapacity;}
	public int getPassengerCapacity() {return PassengerCapacity;}
	@Override
	public int getAnnualMaintenanceCost() {
		return AnnualMaintenanceCost;
	}

	public String toString() {
		return getToStringMutual() +System.lineSeparator()+ tab+"CargoCapacity=" + this.getCargoCapacity() +
				System.lineSeparator()+tab+"PassengerCapacity=" + this.getPassengerCapacity();
	}
}
