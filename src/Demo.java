
public class Demo {

	public static void main(String[] args) {
		
		EventKalender Test = new EventKalender();
		
		Event Feier = new Event("Party", "Graz", 0.0);
		Event Konzert = new Event("Konzert", "Graz", 20.0);
		Event Party = new Event("Partaaay", "Wien", 500.00);
		Test.add(Feier);
		Test.add(Konzert);
		
		System.out.println(Test.getByTitle("Party"));
		
		System.out.println(Test.getByOrt("Graz"));
		
		System.out.println(Test.getByEintrittspreis(0, 20));
		
		System.out.println(Test.getMostExpensiveByOrt("Graz"));

		System.out.println(Test.getAvgPreisByOrt("Graz"));
		
		System.out.println(Test.getNumberByOrt());
	}

}
