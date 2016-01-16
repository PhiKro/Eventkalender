import java.util.ArrayList;
import java.util.HashMap;

public class EventKalender {
	//Anlegen einer ArrayList die mit dem Typ Event befüllt wird. (Objekt aus der Event Klasse)
	private ArrayList<Event> EL = new ArrayList<>();
	
	// Methode zum Hinzufügen eines Events zur oben angelegten ArrayList.
	public void add(Event e)
	{
		EL.add(e);
	}
	
	//Methode zum ausgeben des ersten Events das den gesuchten Titel trägt. Alle weiteren Events werden nach dem ersten 
	//fund nicht mehr geprüft. 
	public Event getByTitle(String title){
		Event found; //Erstellt eine Variable für die Ausgabe (in diesem Beispiel nicht notwendig aber übersichtlicher für mich) 
		for (Event event : EL) // Foreach Schleife (Alle Objekte vom Typ Event in der Eventliste werden abgearbeitet)
		{
			if (event.getTitle().equals(title) ) //ruft mit event.getTitle() den Titel der Veranstaltung ab und vergleicht ihn mit .equals() mit dem Suchstring 
			{ 
				found= event; // Wenn ein Objekt gefunden wird --> Variable found befüllen;
				return found; // Event zurückgeben.
			}
			
		}
		return null; //Wenn kein Event mit passendem Titel gefunden wird, liefere null zurück, notwendig da wir eine Rückgabe brauchen. 
	}
	
	// Methode zum anzeigen aller(!!) Events die an einem Ort stattfinden 
	public ArrayList<Event> getByOrt(String ort)
	{
		ArrayList<Event> ByOrt = new ArrayList<>(); //Erstellen einer Arraylist, die mit den Gefundenen Events befüllt wird. 
		//Notwendig um mehr als ein Event zurückgeben zu können. 
		
		for (Event event : EL) // Foreach Schleife wie bereits in der Titel Methode
		{
			if (event.getOrt().equals(ort)) // Vergleich der Veranstaltungsorte mit dem gesuchten Ort. 
				ByOrt.add(event); // gefundene Veranstaltungen werden der oben erstellten Arraylist hinzugefügt.
		}
		
		return ByOrt; //zurückgeben der Arraylist mit allen gefundenen Veranstaltungen. 
		//Hier ist kein return null notwendig da wir im schlimmsten fall die leere ArrayList zurückgeben. 
	}
	
	// Methode zum zurückgeben aller Veranstaltungen in einem deffinierten Preisrahmen. 
	public ArrayList<Event> getByEintrittspreis(double min, double max)
	{
		ArrayList<Event> ByPreis = new ArrayList<>(); //Erstellen einer Arraylist, die mit den Gefundenen Events befüllt wird. 
		for (Event event : EL) // Foreach Schleife wie bereits in der Titel Methode
		{
			if (event.getEintrittsPreis() >= min && event.getEintrittsPreis()<= max) // Findet alle Veranstaltungen deren Preis zumindest das Minimum aber gleichzeitig höchstens den Maximalpreis hat. 
			{
				ByPreis.add(event);// gefundene Veranstaltungen werden der oben erstellten Arraylist hinzugefügt.
			}
		}
		return ByPreis; //zurückgeben der Arraylist mit allen gefundenen Veranstaltungen. 
		//Hier ist kein return null notwendig da wir im schlimmsten fall die leere ArrayList zurückgeben. 
	}
	
	public ArrayList<Event> getMostExpensiveByOrt(String ort)
	{
		double max =0; //setzt dem maximalen Preis am Beginn auf 0. 
		ArrayList<Event> ByOrt = new ArrayList<>(); // ArrayList für das finale Ergebniss
		ArrayList<Event> Expense =new ArrayList<>(); // Hilfs ArrayList, wird mit allen im ersten Suchdurchlauf gefundenen Events befüllt. 
		for (Event event : EL) 
		{
			if (event.getEintrittsPreis()>=max && event.getOrt().equals(ort)) // Prüft auf 2 Bedingungen: Ist das event teurer als der aktuelle höchste Preis & ist das Event am gesuchten Ort. 
			{
				max = event.getEintrittsPreis(); //setzt den aktuellen Preis als neuen höchsten Preis. 
				ByOrt.add(event); // fügt das gefundenen Event der ArrayList ByOrt hinzu
			}
		}
		for (Event event : ByOrt) {
			if (event.getEintrittsPreis() == max) // Prüft alle Events im Hilfsarray darauf ob sie den höchsten gefundenen Preis haben. 
			{
				Expense.add(event); // fügt die gefundenen Evens der auszugebenden ArrayList hinzu 
			}
		}

		return Expense;
	}
	
	public double getAvgPreisByOrt(String ort) //Berechnen des durchschnittlichen eventpreises am gegebenen Ort
	{
		double kosten =0; 
		int counter = 0;
		for (Event event : EL) {
			if (event.getOrt().equals(ort)) // Prüft ob der Ort des Events mit dem gesuchten Ort übereinstimmt.
			{
				kosten += event.getEintrittsPreis(); // Addiert die Kosten des Events hinzu
				counter++; 
			}
		}
		if (counter ==0 ) // Abfangen des "Div by zero" Fehlers, falls es keine Events gibt. 
		{
			System.out.println("Keine Events gefunden");
			return -1;
		}
		else
		{
		return kosten/counter; // Durchschnitspreis
		}
	}
	
	public HashMap<String, Integer> getNumberByOrt() // Gibt die Events Pro Ort zurück.
	{
		int zahl1 =0;
		
		HashMap<String, Integer> EventList =new HashMap<>(); // Erstellt eine neue HashMap. Aufbau <Key, Value> In unserem fall <Ort, Anzahl der Events>
		for (Event event : EL) 		
		{
		if (EventList.containsKey(event.getOrt())) // Wenn es den Ort in der HasMap bereits gibt, erhöhe den Value des Keys um eins
		{
			zahl1 = EventList.get(event.getOrt());
			EventList.put(event.getOrt(),zahl1+1);
		}
		else  // Wenn es den Ort in der Map noch nicht gibt, lege einen Eintrag für den Key an und setze den Value auf 1. 
		{
			EventList.put(event.getOrt(), 1);
		}
		
		}
	return EventList; 
	}
}
