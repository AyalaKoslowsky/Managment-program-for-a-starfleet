import java.util.Set;

public interface Spaceship {
	String getName();
	int getCommissionYear();
	float getMaximalSpeed();
	int getFirePower();
	Set<? extends CrewMember> getCrewMembers();
	int getAnnualMaintenanceCost();
}
