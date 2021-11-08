package limpLisp;

public class Liste {

    private FlatElement anfang;
    private int laenge;

    public Liste() {
        anfang = null;
        laenge = 0;
    }

    public void vorneLoeschen() {
        loeschen(0);
    }

    public void hintenAnfuegen(FlatElement neuesElement) {
        if (laenge == 0) anfang = neuesElement;
        else getLetztes().setNaechstes(neuesElement);
        laenge++;
    }

    // changed einfuegen to anfuegen cuz hintenAnfuegen also exists
    public void vorneAnfuegen(FlatElement neuesElement) {
        neuesElement.setNaechstes(anfang);
        anfang = neuesElement;
        laenge++;
    }

    public void einfuegen(FlatElement neuesElement, int position) {
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
    public FlatElement getLetztes() {
        FlatElement element = anfang;
        while (element.getNaechstes() != null) {
            element = element.getNaechstes();
        }
        return element;
    }

    public FlatElement getAnPosition(int position) {
        FlatElement element = anfang;
        while (position > 0) {
            element = element.getNaechstes();
            position--;
        }
        return element;
    }

    public void ausgeben() throws Exception {
        FlatElement element = anfang;
        while (element != null) {
            System.out.println(element.getDaten());
            if (element.getNaechstes() == element) throw new Exception("limpLisp.FlatElement refers to self");
            element = element.getNaechstes();
        }
    }

    public int getLaenge() {
        return laenge;
    }

    public FlatElement getAnfang() {
        return anfang;
    }

    public boolean istLeer() {
        return anfang == null;
    }


}
