package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.*;
import java.util.stream.Collectors;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<String> SortedFleet = new ArrayList<>();
		List<Spaceship> fleetList = new ArrayList<>(fleet);

		fleetList.sort(new Comparator<Spaceship>() {
			@Override
			public int compare(Spaceship o1, Spaceship o2) {
				if(o1.getFirePower()!=o2.getFirePower()){
					return -1*Integer.compare(o1.getFirePower(), o2.getFirePower());
				}
				else if (o1.getCommissionYear() != o2.getCommissionYear()){
					return -1*Integer.compare(o1.getCommissionYear(), o2.getCommissionYear());
				}
				else{
					return o1.getName().compareTo(o2.getName());
				}
			}
		});

		for (Spaceship spaceship: fleetList){
			SortedFleet.add(spaceship.toString());
		}

		return SortedFleet;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> AmountPerClass = new HashMap<>();
		for (Spaceship spaceship: fleet){
			String className = spaceship.getClass().getSimpleName();

			if (!AmountPerClass.containsKey(className)){
				AmountPerClass.put(className, 1);
			}
			else{
				AmountPerClass.put(className, AmountPerClass.get(className) +1);
			}
		}

		return AmountPerClass;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int TotalCost=0;
		for (Spaceship spaceship: fleet){
			TotalCost += spaceship.getAnnualMaintenanceCost();
		}
		return TotalCost;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> WeaponsNames = new HashSet<>();
		for (Spaceship spaceship: fleet){
			String className = spaceship.getClass().getSimpleName();
			if (className.equals("Bomber")){
				Bomber ship = ((Bomber)spaceship);
				for (Weapon weapon : ship.getWeapons())
					WeaponsNames.add(weapon.getName());
			}
			if (className.equals("Fighter")){
				Fighter ship = ((Fighter)spaceship);
				for (Weapon weapon : ship.getWeapons())
					WeaponsNames.add(weapon.getName());
			}
			if(className.equals("StealthCruiser")){
				StealthCruiser ship = ((StealthCruiser)spaceship);
				for (Weapon weapon : ship.getWeapons())
					WeaponsNames.add(weapon.getName());
			}
			if (className.equals("CylonRaider")){
				CylonRaider ship = ((CylonRaider)spaceship);
				for (Weapon weapon : ship.getWeapons())
					WeaponsNames.add(weapon.getName());
			}
			if (className.equals("ColonialViper")){
				ColonialViper ship = ((ColonialViper)spaceship);
				for (Weapon weapon : ship.getWeapons())
					WeaponsNames.add(weapon.getName());
			}
		}

		return WeaponsNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int TotalCrewMembers=0;
		for (Spaceship spaceship: fleet){
			TotalCrewMembers += spaceship.getCrewMembers().size();
		}
		return TotalCrewMembers;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float TotalAge=0;
		int AmountOfOfficers=0;
		for (Spaceship spaceship: fleet){
			for (CrewMember crewMember: spaceship.getCrewMembers()){
				if (crewMember.getClass().getSimpleName().equals("Officer")){
					TotalAge += crewMember.getAge();
					AmountOfOfficers++;
				}
			}
		}
		return TotalAge/AmountOfOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> HighestPerShip = new HashMap<>();
		List<Officer> OfficersPerShip = new ArrayList<>();
		for (Spaceship spaceship: fleet){
			OfficersPerShip.clear();
			for (CrewMember crewMember: spaceship.getCrewMembers()){
				if (crewMember.getClass().getSimpleName().equals("Officer")){
					OfficersPerShip.add((Officer)crewMember);
				}
			}
			if (OfficersPerShip.size()==0){
				continue;
			}
			OfficersPerShip.sort(new Comparator<Officer>() {
				@Override
				public int compare(Officer o1, Officer o2) {
					return (o1.getRank().compareTo(o2.getRank()));
				}
			});
			Collections.reverse(OfficersPerShip);
			HighestPerShip.put(OfficersPerShip.get(0), spaceship);
		}
		return HighestPerShip;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> AmountPerRank = new HashMap<>();
		for (Spaceship spaceship: fleet){
			for (CrewMember crewMember: spaceship.getCrewMembers()){
				if (crewMember.getClass().getSimpleName().equals("Officer")){
					Officer officer = (Officer)crewMember;
					if(AmountPerRank.containsKey(officer.getRank())){
						AmountPerRank.put(officer.getRank(), AmountPerRank.get(officer.getRank())+1);
					}
					else{
						AmountPerRank.put(officer.getRank(), 1);
					}
				}
			}
		}
		Set <Map.Entry<OfficerRank, Integer>> set = AmountPerRank.entrySet();
		List<Map.Entry<OfficerRank, Integer>> sortedByPopularity = new ArrayList<Map.Entry<OfficerRank, Integer>>(set);
		sortedByPopularity.sort(new Comparator<Map.Entry<OfficerRank, Integer>>() {
			@Override
			public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {

				if (o1.getValue()!= o2.getValue()){
					return Integer.compare(o1.getValue(), o2.getValue());
				}
				else return o1.getKey().compareTo(o2.getKey());
			}
		});

		return sortedByPopularity;
	}

}
