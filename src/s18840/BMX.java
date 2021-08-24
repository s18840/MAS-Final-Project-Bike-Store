package s18840;

public class BMX extends Rower {
    boolean czyMaPegi;
    int ilsocPegow;

    /**
     * The constructor for class BMX.
     * @param nazwa
     * @param cena
     * @param waga
     * @param iloscPrzerzutek
     * @param gwarancjaWMiesiacach
     * @param czyMaPegi
     * @param ilsocPegow
     */
    public BMX(String nazwa, double cena, double waga, int iloscPrzerzutek, int gwarancjaWMiesiacach,boolean czyMaPegi,int ilsocPegow) {
        super(nazwa, cena, waga, iloscPrzerzutek, gwarancjaWMiesiacach);
        this.czyMaPegi = czyMaPegi;
        this.ilsocPegow = ilsocPegow;
    }

    public String toString(){
        String info = new String();
        info += "Typ: BMX";
        info += " Nazwa: " + getNazwa();
        info += " Cena: "+ getCena();
        info += " Waga: "+ getWaga() ;
        info += " Gwarancja w miesiącach: "+ getGwarancjaWMiesiacach() ;
        info += " Ilosc Przerzutek: "+ getIloscPrzerzutek();
        info += " Czy ma pegi: "+ isCzyMaPegi() ;
        info += " Ilosc pegów: "+ getIlsocPegow() + "\n";
        return info;
    }

    public boolean isCzyMaPegi() {
        return czyMaPegi;
    }

    public void setCzyMaPegi(boolean czyMaPegi) {
        this.czyMaPegi = czyMaPegi;
    }

    public int getIlsocPegow() {
        return ilsocPegow;
    }

    public void setIlsocPegow(int ilsocPegow) {
        this.ilsocPegow = ilsocPegow;
    }
}
