package s18840;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Klient extends Osoba implements Serializable {
    private boolean czyRabat;
    private int rabat;
    private int liczbaZamowien;
    private LocalDate dataUrodzenia;
    private  ArrayList<Zamowienie> zamowieniaArrayList= new ArrayList<>();

    /**
     * The constructor for class Klient.
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @throws Exception --when no Extent file
     */
    public Klient(String imie, String nazwisko, String email, Adres adres) throws Exception {
        super(imie, nazwisko, email, adres);
        this.liczbaZamowien = getLiczbaZamowien();
        if(liczbaZamowien>=5 && liczbaZamowien<10){
            czyRabat=true;
            setRabat(5);
        }else if(liczbaZamowien>=10){
            czyRabat=true;
            setRabat(10);
        }
    }

    /**
     * This method is overloading show() and printing rabat
     * @param rabat
     */

    public void show(int rabat){
        System.out.println("przesloniecie Rabat:" + getRabat());
    }

    /**
     *This method is overloading show() and printing dataUrodzenia
     * @param dataUrodzenia
     */
    public void show(LocalDate dataUrodzenia){
        System.out.println("przesloniecie data urodzenia:" +getDataUrodzenia());
    }
/*
    public ArrayList<Zamowienia> getZamowieniaArrayList() {
        return zamowieniaArrayList;
    }
*/

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public boolean isCzyRabat() {
        return czyRabat;
    }

    public void setCzyRabat(boolean czyRabat) {
        this.czyRabat = czyRabat;
    }

    public int getLiczbaZamowien() {
        return liczbaZamowien;
    }

    public void setLiczbaZamowien(int liczbaZamowien) {
        this.liczbaZamowien = liczbaZamowien;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
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

    /**
     * TThis method is overridden from Osoba and it shows Zamowienie
     * @throws Exception --when no Extent file
     */
    public void pokazZamowienia() throws Exception {
        //List<Zamowienie> extentZamowienia = ObjectPlus.getZamowienieExtent();
        for(Zamowienie r : zamowieniaArrayList){
            System.out.println(r);
        }
    }

    /**
     * This method is overridden from Osoba and its adding Zamowienie to ArrayList
     * @param zamowienie
     */
    public  void  zlozZamowienie(Zamowienie zamowienie){
        zamowieniaArrayList.add(zamowienie);
        setLiczbaZamowien(liczbaZamowien+1);
        if(liczbaZamowien>=5 && liczbaZamowien<10){
            czyRabat=true;
            setRabat(5);
        }else if(liczbaZamowien>=10){
            czyRabat=true;
            setRabat(10);
        }
    }

    public String toString(){
        String info = super.toString();
        if(dataUrodzenia!=null)
            info += "Data urodzenia: "+ getDataUrodzenia();
        else
            info += "Data urodzenia: Nie podano";
        info += "\nRabat: "+ getRabat() + "%\n";

        return info;
    }
}
