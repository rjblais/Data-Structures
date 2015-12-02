package lab0;

public class Student implements Comparable {

	String name;
	double gpa;
	String major;

	@Override
	public int compareTo (Object a) {
		if (gpa > (Student)a).getGpa){
			 return 1;
		}
		else if (gpa < ((Student) a)) {
			return 0;
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	
	
	
	
}
