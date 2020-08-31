package de.markusveril;
import java.util.*;
import java.util.ArrayList;



public class Wortfilter 
{
	//String, den der User eingibt.
	String eingabe;
	
	//String "eingabe", in einen Array Splitten.
	String[] eingabeArray;
	
	// Positionen der W�rter festlegen
	ArrayList<Integer> checkListPos = new ArrayList<Integer>();
	
	//Liste aller verbotenen Worte
	ArrayList <String> blackList = new ArrayList<String>();
	



	// Worte zur Blacklist hinzuf�gen
	public void AddWordToBlackList(String wort)
	{
		blackList.add(wort);
	}
	
	// Text �ber die Konsle eingeben und dem String "eingabe" zuweisen
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
		
		// Positionsliste aller geschriebenen W�rter
		for (int i = 0;i<eingabeArray.length;i++)
		{
			checkListPos.add(i+1);
		}

	}
	// Array "eingabeArray" wird auf W�rter in der Blacklist gepr�ft
	public void checkList() throws Exception
	{
		// Z�hler f�r gefundene negativen W�rter von der Blacklist
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
				System.out.println("Suche beendet. Keine b�sen W�rter Gefunden");
			}
			
			else
			{
					throw new Nettiception(
							"\n\n"
							+ "Geschriebener Satz: " + eingabe
							+ "\nFolgende W�rter auf der Blacklist gefunden:" + worte);
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
