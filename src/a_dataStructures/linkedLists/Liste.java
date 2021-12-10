package a_dataStructures.linkedLists;

public class Liste {

    private Element anfang;
    private int laenge;

    public Liste() {
        anfang = null;
        laenge = 0;
    }

    public void vorneLoeschen() {
        loeschen(0);
    }

    public void hintenAnfuegen(Element neuesElement) {
        if (laenge == 0) anfang = neuesElement;
        else getLetztes().setNaechstes(neuesElement);
        laenge++;
    }

    // changed einfuegen to anfuegen cuz hintenAnfuegen also exists
    public void vorneAnfuegen(Element neuesElement) {
        neuesElement.setNaechstes(anfang);
        anfang = neuesElement;
        laenge++;
    }

    public void einfuegen(Element neuesElement, int position) {
        if (position == 0) {
            vorneAnfuegen(neuesElement);
        }
        else if (position > 0) {
            getAnPosition(position - 1).setNaechstes(neuesElement);
            neuesElement.setNaechstes(getAnPosition(position));
            laenge++;
        }
        else System.out.println("Nope, no negative indexes allowed =[");
    }

    public void loeschen(int position) {
        if (anfang == null) {
            System.out.println("List is already empty");
            return;
        }
        if (position == 0) {
            if (anfang.getNaechstes() != null) anfang = anfang.getNaechstes();
        }
        else if (position > 0) {
            if (getAnPosition(position).getNaechstes() == null) {
                getAnPosition(position - 1).setNaechstes(null);
            }
            else {
                getAnPosition(position - 1).setNaechstes(getAnPosition(position + 1));

            }
        }
        else {
            System.out.println("No negative index allowed :[");
            return;
        }
        laenge--;
    }

    // i refuse to call a get-method gib
    public Element getLetztes() {
        Element element = anfang;
        while (element.getNaechstes() != null) {
            element = element.getNaechstes();
        }
        return element;
    }

    public Element getAnPosition(int position) {
        Element element = anfang;
        while (position > 0) {
            element = element.getNaechstes();
            position--;
        }
        return element;
    }

    public void ausgeben() throws Exception {
        Element element = anfang;
        while (element != null) {
            System.out.println(element.getDaten());
            if (element.getNaechstes() == element) throw new Exception("limpLisp.Element refers to self");
            element = element.getNaechstes();
        }
    }

    public int getLaenge() {
        return laenge;
    }

    public Element getAnfang() {
        return anfang;
    }

    public boolean istLeer() {
        return anfang == null;
    }


}
