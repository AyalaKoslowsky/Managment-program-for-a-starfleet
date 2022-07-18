public class Cylon extends myCrewMembersAbstract{

	int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}

	public int getModelNumber(){
		return modelNumber;
	}
}
