package s18840;


public class MTB extends Rower {
    boolean amortyzatory;

    /**
     * The constructor for class MTB.
     * @param nazwa
     * @param cena
     * @param waga
     * @param iloscPrzerzutek
     * @param gwarancjaWMiesiacach
     * @param amortyzatory
     */
    public MTB(String nazwa, double cena, double waga, int iloscPrzerzutek, int gwarancjaWMiesiacach, boolean amortyzatory) {
        super(nazwa, cena, waga, iloscPrzerzutek, gwarancjaWMiesiacach);
        this.amortyzatory = amortyzatory;
    }

    public String toString(){
        String info = new String();
        info += "Typ: MTB";
        info += " Nazwa: " + getNazwa();
        info += " Cena: "+ getCena();
        info += " Waga: "+ getWaga() ;
        info += " Gwarancja w miesiącach: "+ getGwarancjaWMiesiacach() ;
        info += " Ilosc Przerzutek: "+ getIloscPrzerzutek();
        info += " Czy ma amortyzatory: "+ isAmortyzatory() + "\n";
        return info;
    }

    public boolean isAmortyzatory() {
        return amortyzatory;
    }

    public void setAmortyzatory(boolean amortyzatory) {
        this.amortyzatory = amortyzatory;
    }
}
