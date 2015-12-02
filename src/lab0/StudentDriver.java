package lab0;

public class StudentDriver {
	public static void main(String[] args) {

		Student s1 = new Student("Tom", 3.5, "CSBS");
		Student s2 = new Student("Bob", 3.6, "CSE");
		ArrayList<Student> s1 = new ArrayList<>();

		
		
		s1.add(s1);
		if (s1.compareTo(s2) > 0) {
			System.out.println(s1.name + " is greater than " + s2.name);
		} else if (s1.compareTo(s2) < 0) {
			System.out.println(s2.name + " is greater than " + s1.name);
		} else {
			System.out.println("The students are equal");
		}
	}
}
