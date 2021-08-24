package s18840;

import java.util.List;

public class Platnosc extends ObjectPlus4{
    private double kwota;
    private SposobyPlatnosci sposPlatnosci;

    /**
     * The constructor for class Platnosc
     * @see ObjectPlusPlus {@link #addLink(String, String, ObjectPlusPlus)}
     * @param kwota
     * @param osoba
     * @param zamowienie
     */
    private Platnosc(double kwota,Osoba osoba,Zamowienie zamowienie) {
        this.kwota = kwota;
        zamowienie.setStatus(Status.NIEOPLACONE);
        this.addLink("platnoscZamowienie","zamowieniePlatnosc",zamowienie);
        this.addLink("platnoscOsoba","osobaPlatnosc",osoba);

    }


    /**
     * This method allows us to wybierzSposobPlatnosci
     */
    public static Platnosc realizujPlatnosc(double kwota,Osoba osoba,Zamowienie zamowienie){
        Platnosc p= new Platnosc( kwota,osoba,zamowienie);
        return p;
    }

    public SposobyPlatnosci getSposPlatnosci() {
        return sposPlatnosci;
    }

    public void setSposPlatnosci(SposobyPlatnosci sposPlatnosci) {
        this.sposPlatnosci = sposPlatnosci;
    }

    public static void wyswietlListaWszystkichPlatnosci() throws Exception {
        List<Platnosc> extent = ObjectPlus.getPlatnoscExtent();
        for(Platnosc r : extent){
            System.out.println(r);
        }
    }

    @Override
    public String toString() {
        return "Platnosc{" +
                "kwota=" + kwota +
                ", sposPlatnosci=" + sposPlatnosci +
                '}';
    }
}
