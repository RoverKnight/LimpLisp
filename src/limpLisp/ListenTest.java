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
    Element e1 = new Element("eins");
    Element e2 = new Element("zwei");
    Element e3 = new Element("drei");
    Element e4 = new Element("vier");
    Element e5 = new Element("fünf");
    Element e6 = new Element("sechs");
    Element e7 = new Element("sieben");
    Element e0 = new Element("null");
    Element e00 = new Element("000");
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
    System.out.println("Letztes limpLisp.Element: "+ l1.getLetztes().getDaten());
    l1.vorneLoeschen();
    l1.vorneAnfuegen(e0);
    l1.ausgeben(); // Lsg: "null", "eins", "zwei", "drei"
    System.out.println("limpLisp.Element an Position 2: " + l1.getAnPosition(2).getDaten());
    
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
