package de.markusveril;

public class Program {

	
	public static void main(String[] args) 
	{
		
		// Neues Objekt von der Klasse Wortfilter anlegen
		Wortfilter filter = new Wortfilter();
		// Neue Wörter in die Blacklist Hinzufügen.
		filter.AddWordToBlackList("doof");
		filter.AddWordToBlackList("Idiot");
		filter.AddWordToBlackList("Arsch");
		
		// Texteingabe + Eingabe in Array Splitten
		filter.textSplitt(filter.textEingabe());
		
		try 
		{
		  //Eingabe Array nach Wörtern auf der Blacklist durchsuchen
		  filter.checkList();
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
	
	}

}
