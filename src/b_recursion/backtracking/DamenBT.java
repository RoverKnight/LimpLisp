public class DamenBT{
    
    static int n = 4; // Hier den Testfall festlegen

    public static void main(String[] args){
	  boolean[][] start = new boolean[n][n];	
      backtracking(start); 
      System.out.println("Es geht nicht!");
    }
    
    public static void backtracking(boolean[][] zwe){ // Erläutern
      int pos = 0;
      while(pos<n){
		boolean[][] aktuell = teilloesungErgaenzen(zwe, pos);	
		if(loesungGefunden(aktuell)){
		  loesungAusgeben(aktuell);
		  System.exit(0);
		}
		if(loesungNochMoeglich(aktuell)){                   
		  backtracking(aktuell); 
		}
		pos++;
      }
    }
    
    public static void loesungAusgeben(boolean[][] ergebnis){ 
	  // Soll das Brett auf der Konsole ausgeben.
	  // o für Dame, - für keine Dame
	}
        
    public static boolean loesungNochMoeglich(boolean[][] zwe){
	  // soll wahr liefern, falls im Zwischenergebnis zwe kein gegenseitiges Schlagen möglich ist
	  // Ansonsten false
	  return true;
    }
    
    public static boolean loesungGefunden(boolean[][] zwe){ // Erläutern
	  int anzahlDamen = 0;
	  for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
		  if(zwe[i][j]){
			  anzahlDamen++;
		  }
		}
	  }
	  return loesungNochMoeglich(zwe) && anzahlDamen == n;	
    }
    
    public static boolean[][] teilloesungErgaenzen(boolean[][] zwe, int pos){ // Erläutern
	  boolean[][] hilfe = new boolean[n][n];
	  for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
		  hilfe[i][j] = zwe[i][j];
		}
	  }	
	  for(int i=0;i<n;i++){
		boolean dameDa = false;
		for(int j=0;j<n;j++){
		  if(hilfe[i][j]){
			dameDa = true;
		  }	
		}
		if(!dameDa){
		  hilfe[i][pos] = true;
		  return hilfe;	
		}
	  }	
      return zwe; // Kann nicht passieren!
    }
    
}



