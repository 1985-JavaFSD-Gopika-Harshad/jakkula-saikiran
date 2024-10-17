//Implement a generic class
//Pair<T, U>
//that can hold two objects of types T and U. Provide methods to get and set the values of the pair.


package dailyprograms;

public class Pair<T,U> {
	private T male;
	private U female;
	
	Pair(T male,U female){
		this.male=male;
		this.female=female;
	}
	public T getMale() {
		return male;
	}
	public U getFemale() {
		return female;
	}
	public void setMale(T male) {
		this.male=male;
	}
	public void setFemale(U female) {
		this.female=female;
	}
	public String toString() {
		return "Pair{"+"Male ="+male+",  female :"+female+"}";
	}
	public static void main(String[] args) {
		Pair<String,String> names=new Pair<>("Saikiran","rashmika");
		System.out.println("Male :"+names.getMale());
		System.out.println("Female :"+names.getFemale());
		
		names.setMale("prasad");
		names.setFemale("samantha");
		System.out.println("all grades are :"+names);
	}

}
