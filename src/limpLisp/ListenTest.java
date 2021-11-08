package limpLisp;

/**
 * Beschreiben Sie hier die Klasse limpLisp.ListenTest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ListenTest{
    
    public static void main(String[] args) throws Exception {
    
    // Ein paar Elemente und Listen erzeugen    
    FlatElement e1 = new FlatElement("eins");
    FlatElement e2 = new FlatElement("zwei");
    FlatElement e3 = new FlatElement("drei");
    FlatElement e4 = new FlatElement("vier");
    FlatElement e5 = new FlatElement("fünf");
    FlatElement e6 = new FlatElement("sechs");
    FlatElement e7 = new FlatElement("sieben");
    FlatElement e0 = new FlatElement("null");
    FlatElement e00 = new FlatElement("000");
    Liste l1 = new Liste();
    Liste l2 = new Liste();
    
    // Testen der Methoden
    System.out.println("Rush A");
    l1.ausgeben();
    l1.vorneAnfuegen(e00);
    l1.hintenAnfuegen(e2);
    l1.hintenAnfuegen(e3);
    l1.einfuegen(e1,1);
    System.out.println("Rush B");
    l1.ausgeben(); // Lsg: "000", "eins", "zwei", "drei"
    System.out.println("Rush C");
    System.out.println("Letztes limpLisp.FlatElement: "+ l1.getLetztes().getDaten());
    l1.vorneLoeschen();
    l1.vorneAnfuegen(e0);
    l1.ausgeben(); // Lsg: "null", "eins", "zwei", "drei"
    System.out.println("limpLisp.FlatElement an Position 2: " + l1.getAnPosition(2).getDaten());
    
    l2.vorneAnfuegen(e6);
    l2.einfuegen(e5,1);
    l2.vorneAnfuegen(e7);
    l2.hintenAnfuegen(e4);
    l2.ausgeben(); // Lsg: "sieben", "sechs", "fünf", "vier"
    l2.loeschen(0);
    l2.loeschen(2);
    l2.ausgeben(); // Lsg: "sechs", "fünf"
    

    
    
    
    
    
    
    
    }
}
