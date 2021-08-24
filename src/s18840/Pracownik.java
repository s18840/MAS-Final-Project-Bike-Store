package s18840;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik extends Osoba implements Serializable {
    private String pesel;//unikalny
    private String stanowisko;
    private LocalDate dataZatrudnienia;
    private double wysokoscPensji;
    private static int rabatPracowniczy =40;
    private static List<String> listaPeseli = new ArrayList<String>();

    /**
     * The constructor for class Pracownik.
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @param pesel
     * @param stanowisko
     * @param dataZatrudnienia
     * @param wysokoscPensji
     * @param z
     * @throws Exception --when no Extent file
     */
    public Pracownik(String imie, String nazwisko, String email, Adres adres,String pesel,String stanowisko,LocalDate dataZatrudnienia, double wysokoscPensji,Zamowienie z) throws Exception {
        super(imie, nazwisko, email, adres,z);
        setPesel(pesel);
        this.stanowisko=stanowisko;
        this.dataZatrudnienia=dataZatrudnienia;
        this.wysokoscPensji=wysokoscPensji;

    }

    /**
     * The constructor for class Pracownik
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @param pesel
     * @param stanowisko
     * @param dataZatrudnienia
     * @param wysokoscPensji
     * @throws Exception --when no Extent file
     */
    public Pracownik(String imie, String nazwisko, String email, Adres adres,String pesel,String stanowisko,LocalDate dataZatrudnienia, double wysokoscPensji) throws Exception {
        super(imie, nazwisko, email, adres);
        setPesel(pesel);
        this.stanowisko=stanowisko;
        this.dataZatrudnienia=dataZatrudnienia;
        this.wysokoscPensji=wysokoscPensji;

    }

    public String getPesel() {
        return pesel;
    }

    /**
     * This method sets Pesel and keeps it unique
     * @param pesel
     * @throws Exception --when no Extent file
     */
    public void setPesel(String pesel) throws Exception {
        for(String p:listaPeseli){
                if(p.equals(pesel)){
                    throw new IllegalArgumentException("Podany pesel istnieje już w systemie");
            }
        }
        listaPeseli.add(pesel);
        this.pesel = pesel;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public void setWysokoscPensji(double wysokoscPensji) {
        this.wysokoscPensji = wysokoscPensji;
    }

    public static int getRabatPracowniczy() {
        return rabatPracowniczy;
    }

    /**
     * This method deletes Object with Links
     * @param roleName
     * @param reverseRoleName
     * @throws Exception --when no Extent file
     */
    public void deleteLinksObjects(String roleName, String reverseRoleName) throws Exception {
        for(Object o :this.getLinks(roleName)){
            ObjectPlus.deleteExtension(this);
            ObjectPlus.deleteExtension(o);
            deleteLinks(roleName);
            ((Klient) o).deleteLinks(reverseRoleName);

        }
    }

    /**
     * This method is overridden from Osoba and it shows the list of all Rowers from the Extent
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
     * This method is overridden from Osoba and it shows the list of all Rowers from the Extent
     * @throws Exception --when no Extent file
     */
    public static void wyswietlListaWszystkichRowerow() throws Exception {
        List<Rower> extent = ObjectPlus.getAllRowerExtent();
        for(Rower r : extent){
            System.out.println(r);
        }
    }

    public String toString(){
        String info = super.toString();
        info += "Pesel: " + getPesel();
        info += "\nStanowisko: "+ getStanowisko();
        info += "\nData zatrudnienia: "+ getDataZatrudnienia();
        info += "\nWysokosc wynagrodzenia: "+ podliczWynagrodzenie();
        info += "\nRabat pracowniczy: " + getRabatPracowniczy() +"%\n";
        return info;
    }

    public double getWysokoscPensji() {
        return wysokoscPensji;
    }

    /**
     * This method is abstract method for podliczWynagrodzenie
     * @return
     */
    public abstract double podliczWynagrodzenie();

}

