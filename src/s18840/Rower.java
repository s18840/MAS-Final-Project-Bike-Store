package s18840;

import java.util.ArrayList;
import java.util.List;

public abstract class Rower extends ObjectPlus4 {
    private String nazwa;
    private double cena;
    private double waga;
    private int iloscPrzerzutek;
    private int gwarancjaWMiesiacach;

    /**
     * The constructor for class Rower
     * @param nazwa
     * @param cena
     * @param waga
     * @param iloscPrzerzutek
     * @param gwarancjaWMiesiacach
     */
    public Rower(String nazwa, double cena, double waga, int iloscPrzerzutek, int gwarancjaWMiesiacach) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.waga = waga;
        this.iloscPrzerzutek = iloscPrzerzutek;
        this.gwarancjaWMiesiacach = gwarancjaWMiesiacach;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public double getWaga() {
        return waga;
    }

    public int getIloscPrzerzutek() {
        return iloscPrzerzutek;
    }

    public int getGwarancjaWMiesiacach() {
        return gwarancjaWMiesiacach;
    }

    /**
     * This method shows the list of all Rowers from the Extent
     * @param theClass
     * @throws Exception --when no Extent file
     */
    public static void wyswietlListaRowerow(Class theClass) throws Exception {
        List<Rower> extent = ObjectPlus.getRowerExtent(theClass);
        for(Rower r : extent){
            if(r.getClass()==theClass){
                System.out.println(r);
            }
        }
    }

    /**
     * This method shows the list of all Rowers from the Extent
     * @throws Exception --when no Extent file
     */
    public static void wyswietlListaWszystkichRowerow() throws Exception {
        List<Rower> extent = ObjectPlus.getAllRowerExtent();
        for(Rower r : extent){
            System.out.println(r);
        }
    }

    public String toString(){
        String info = new String();
        info += "Nazwa: " + getNazwa();
        info += " Cena: "+ getCena();
        info += " Waga: "+ getWaga() ;
        info += " Gwarancja w miesiącach: "+ getGwarancjaWMiesiacach() ;
        info += " Ilosc Przerzutek: "+ getIloscPrzerzutek() + "\n";
        return info;
    }


}
