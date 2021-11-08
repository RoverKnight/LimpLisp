package limpLisp;

/**
 * Beschreiben Sie hier die Klasse limpLisp.Stack.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stack{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private FlatElement start;
    
    public Stack(){
        start = null;
    }
    
    public void push(FlatElement e){
        e.setNaechstes(start);
        start = e;
    }
    
    public FlatElement pop(){
        FlatElement e = start;
        start = start.getNaechstes();
        return e;
    }
    
    public FlatElement top(){
        return start;
    }
    
    public boolean empty(){
        if(start == null)return true;
        return false;
    }
}
