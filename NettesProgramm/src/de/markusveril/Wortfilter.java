package de.markusveril;
import java.util.*;
import java.util.ArrayList;



public class Wortfilter 
{
	//String, den der User eingibt.
	String eingabe;
	
	//String "eingabe", in einen Array Splitten.
	String[] eingabeArray;
	
	// Positionen der Wörter festlegen
	ArrayList<Integer> checkListPos = new ArrayList<Integer>();
	
	//Liste aller verbotenen Worte
	ArrayList <String> blackList = new ArrayList<String>();
	



	// Worte zur Blacklist hinzufügen
	public void AddWordToBlackList(String wort)
	{
		blackList.add(wort);
	}
	
	// Text über die Konsle eingeben und dem String "eingabe" zuweisen
	public String textEingabe()
	{ 
		System.out.println("Text Eingeben");
		Scanner scanner = new Scanner(System.in);
		eingabe = scanner.nextLine();
		scanner.close();
		return eingabe;
	}
	// eingabe in Array "eingabeArray" splitten
	public void textSplitt(String string)
	{
		eingabeArray = string.split(" ");
		
		// Positionsliste aller geschriebenen Wörter
		for (int i = 0;i<eingabeArray.length;i++)
		{
			checkListPos.add(i+1);
		}

	}
	// Array "eingabeArray" wird auf Wörter in der Blacklist geprüft
	public void checkList() throws Exception
	{
		// Zähler für gefundene negativen Wörter von der Blacklist
		int wortZaehler = 0;
		
		// String der bei der Fehlermeldung ausgegeben wird.
		String worte = "";
		
		
			for (int i = 0;i <eingabeArray.length;i++)
			{
				for (int j = 0;j < blackList.size();j++)
				{
					if (eingabeArray[i].equals(blackList.get(j)))
					{
						wortZaehler++;
						worte += "\n'"+eingabeArray[i]+ "'" + " an Position " + checkListPos.get(i);
					}
				}
			}
			
			
			
			if (wortZaehler==0)
			{
				System.out.println("Suche beendet. Keine bösen Wörter Gefunden");
			}
			
			else
			{
					throw new Nettiception(
							"\n\n"
							+ "Geschriebener Satz: " + eingabe
							+ "\nFolgende Wörter auf der Blacklist gefunden:" + worte);
			}
		
	}
	
	// Neue Exception Klasse erstellen
	public class Nettiception extends RuntimeException
	{
		public Nettiception (String fehler)
		{
			super (fehler);
		}
	}
}
