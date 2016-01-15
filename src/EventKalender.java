import java.util.ArrayList;
import java.util.HashMap;

public class EventKalender {
	//Anlegen einer ArrayList die mit dem Typ Event bef�llt wird. (Objekt aus der Event Klasse)
	private ArrayList<Event> EL = new ArrayList<>();
	
	// Methode zum Hinzuf�gen eines Events zur oben angelegten ArrayList.
	public void add(Event e)
	{
		EL.add(e);
	}
	
	//Methode zum ausgeben des ersten Events das den gesuchten Titel tr�gt. Alle weiteren Events werden nach dem ersten 
	//fund nicht mehr gepr�ft. 
	public Event getByTitle(String title){
		Event found; //Erstellt eine Variable f�r die Ausgabe (in diesem Beispiel nicht notwendig aber �bersichtlicher f�r mich) 
		for (Event event : EL) // Foreach Schleife (Alle Objekte vom Typ Event in der Eventliste werden abgearbeitet)
		{
			if (event.getTitle().equals(title) ) //ruft mit event.getTitle() den Titel der Veranstaltung ab und vergleicht ihn mit .equals() mit dem Suchstring 
			{ 
				found= event; // Wenn ein Objekt gefunden wird --> Variable found bef�llen;
				return found; // Event zur�ckgeben.
			}
			
		}
		return null; //Wenn kein Event mit passendem Titel gefunden wird, liefere null zur�ck, notwendig da wir eine R�ckgabe brauchen. 
	}
	
	// Methode zum anzeigen aller(!!) Events die an einem Ort stattfinden 
	public ArrayList<Event> getByOrt(String ort)
	{
		ArrayList<Event> ByOrt = new ArrayList<>(); //Erstellen einer Arraylist, die mit den Gefundenen Events bef�llt wird. 
		//Notwendig um mehr als ein Event zur�ckgeben zu k�nnen. 
		
		for (Event event : EL) // Foreach Schleife wie bereits in der Titel Methode
		{
			if (event.getOrt().equals(ort)) // Vergleich der Veranstaltungsorte mit dem gesuchten Ort. 
				ByOrt.add(event); // gefundene Veranstaltungen werden der oben erstellten Arraylist hinzugef�gt.
		}
		
		return ByOrt; //zur�ckgeben der Arraylist mit allen gefundenen Veranstaltungen. 
		//Hier ist kein return null notwendig da wir im schlimmsten fall die leere ArrayList zur�ckgeben. 
	}
	
	// Methode zum zur�ckgeben aller Veranstaltungen in einem deffinierten Preisrahmen. 
	public ArrayList<Event> getByEintrittspreis(double min, double max)
	{
		ArrayList<Event> ByPreis = new ArrayList<>(); //Erstellen einer Arraylist, die mit den Gefundenen Events bef�llt wird. 
		for (Event event : EL) // Foreach Schleife wie bereits in der Titel Methode
		{
			if (event.getEintrittsPreis() >= min && event.getEintrittsPreis()<= max) // Findet alle Veranstaltungen deren Preis zumindest das Minimum aber gleichzeitig h�chstens den Maximalpreis hat. 
			{
				ByPreis.add(event);
			}
		}
		return ByPreis;
	}
	
	public ArrayList<Event> getMostExpensiveByOrt(String ort)
	{
		double max =0;
		ArrayList<Event> ByOrt = new ArrayList<>();
		ArrayList<Event> Expense =new ArrayList<>();
		for (Event event : EL) 
		{
			if (event.getEintrittsPreis()>=max && event.getOrt().equals(ort))
			{
				max = event.getEintrittsPreis();
				ByOrt.add(event);
			}
		}
		for (Event event : ByOrt) {
			if (event.getEintrittsPreis() == max)
			{
				Expense.add(event);
			}
		}

		return Expense;
	}
	
	public double getAvgPreisByOrt(String ort)
	{
		double kosten =0;
		int counter = 0;
		for (Event event : EL) {
			if (event.getOrt().equals(ort))
			{
				kosten += event.getEintrittsPreis();
				counter++;
			}
		}
		if (counter ==0 )
		{
			System.out.println("Keine Events gefunden");
			return -1;
		}
		else
		{
		return kosten/counter;
		}
	}
	
	public HashMap<String, Integer> getNumberByOrt()
	{
		int zahl1 =0;
		
		HashMap<String, Integer> EventList =new HashMap<>();
		for (Event event : EL) 
		{
		if (EventList.containsKey(event.getOrt()))
		{
			zahl1 = EventList.get(event.getOrt());
			EventList.put(event.getOrt(),zahl1+1);
		}
		else 
		{
			EventList.put(event.getOrt(), 1);
		}
		
		}
	return EventList;
	}
}
