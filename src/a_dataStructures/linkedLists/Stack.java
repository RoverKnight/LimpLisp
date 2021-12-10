package a_dataStructures.linkedLists;

/**
 * Beschreiben Sie hier die Klasse limpLisp.Stack.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stack{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Element start;
    
    public Stack(){
        start = null;
    }
    
    public void push(Element e){
        e.setNaechstes(start);
        start = e;
    }
    
    public Element pop(){
        Element e = start;
        start = start.getNaechstes();
        return e;
    }
    
    public Element top(){
        return start;
    }
    
    public boolean empty(){
        if(start == null)return true;
        return false;
    }
}
