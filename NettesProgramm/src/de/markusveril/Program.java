package de.markusveril;

public class Program {

	
	public static void main(String[] args) 
	{
		
		// Neues Objekt von der Klasse Wortfilter anlegen
		Wortfilter filter = new Wortfilter();
		// Neue W�rter in die Blacklist Hinzuf�gen.
		filter.AddWordToBlackList("doof");
		filter.AddWordToBlackList("Idiot");
		filter.AddWordToBlackList("Arsch");
		
		// Texteingabe + Eingabe in Array Splitten
		filter.textSplitt(filter.textEingabe());
		
		try 
		{
		  //Eingabe Array nach W�rtern auf der Blacklist durchsuchen
		  filter.checkList();
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
	
	}

}
