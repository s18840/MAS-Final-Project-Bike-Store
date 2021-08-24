package s18840;

public class Szosowy extends Rower {
    int uchwytNaBidon;

    /**
     * The constructor for class Szosowy
     * @param nazwa
     * @param cena
     * @param waga
     * @param iloscPrzerzutek
     * @param gwarancjaWMiesiacach
     * @param uchwytNaBidon
     */
    public Szosowy(String nazwa, double cena, double waga, int iloscPrzerzutek, int gwarancjaWMiesiacach, int uchwytNaBidon) {
        super(nazwa, cena, waga, iloscPrzerzutek, gwarancjaWMiesiacach);
        this.uchwytNaBidon = uchwytNaBidon;
    }

    public String toString(){
        String info = new String();
        info += "Typ: SZOS";
        info += " Nazwa: " + getNazwa();
        info += " Cena: "+ getCena();
        info += " Waga: "+ getWaga() ;
        info += " Gwarancja w miesiącach: "+ getGwarancjaWMiesiacach() ;
        info += " Ilosc Przerzutek: "+ getIloscPrzerzutek();
        info += " Ilosc uchwytów na bidony: "+ getUchwytNaBidon() + "\n";
        return info;
    }

    public int getUchwytNaBidon() {
        return uchwytNaBidon;
    }

    public void setUchwytNaBidon(int uchwytNaBidon) {
        this.uchwytNaBidon = uchwytNaBidon;
    }
}
