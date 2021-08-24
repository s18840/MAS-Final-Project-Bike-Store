package s18840;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Sprzedawca extends Pracownik implements Serializable {
    private double miesiecznyDodatekOdSprzedazy=300;
    private static int rabatPracowniczy =40;


    /**
     * The constructor for class Sprzedawca
     * @see ObjectPlusPlus {@link #addLink(String, String, ObjectPlusPlus)}
     * @see ObjectPlus4 {@link #addLink_subset(String, String, String, ObjectPlusPlus)}
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @param pesel
     * @param stanowisko
     * @param dataZatrudnienia
     * @param wysokoscPensji
     * @throws Exception
     */
    public Sprzedawca(String imie, String nazwisko, String email, Adres adres, String pesel, String stanowisko, LocalDate dataZatrudnienia, double wysokoscPensji) throws Exception {
        super(imie, nazwisko, email, adres, pesel, stanowisko, dataZatrudnienia, wysokoscPensji);
        //add "subsetLink"

    }
    /**
     * This method add link to Klient
     * @throws Exception --when no Extent file
     */
    public void stworzKlienta(Klient klient){
        this.addLink("pomaga","korzysta",klient);
    }
    /**
     * This method add Link to Zamowienie
     * @throws Exception --when no Extent file
     */
    public void stworzZamowienie(Zamowienie zamowienie) throws Exception {
        this.addLink("obsluguje","obslugiwana",zamowienie);
        this.addLink_subset("dokonuje","dokonywana","obsluguje",zamowienie);
    }

    /**
     * This method shows Extent
     * @throws Exception --when no Extent file
     */
    public static void showExtent() throws Exception {
        ObjectPlus.showExtent(Sprzedawca.class);
    }
    public static int getRabatPracowniczy() {
        return rabatPracowniczy;
    }
    public static void setRabatPracowniczy(int rabatPracowniczy) {
        Sprzedawca.rabatPracowniczy = rabatPracowniczy;
    }

    /**
     * This methods calculates Wynagrodzenie
     * @return
     */
    @Override
    public double podliczWynagrodzenie() {
        return getMiesiecznyDodatekOdSprzedazy()+getWysokoscPensji();

    }

    /**
     * This method prints all Rowers from Extent
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
     * This method prints all Rowers from Extent
     * @throws Exception --when no Extent file
     */
    public static void wyswietlListaWszystkichRowerow() throws Exception {
        List<Rower> extent = ObjectPlus.getAllRowerExtent();
        for(Rower r : extent){
            System.out.println(r);
        }
    }

    public double getMiesiecznyDodatekOdSprzedazy() {
        return miesiecznyDodatekOdSprzedazy;
    }

}
