package s18840;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Osoba extends ObjectPlus4 {
    private String imie;
    private String nazwisko;
    private String email;//unikalny
    private Adres adres;
    private static List<String> listaEmaili = new ArrayList<String>();
    private ArrayList<Zamowienie> zamowieniaArrayList;

    /**
     * The constructor for class Osoba.
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @param z
     * @throws Exception --when no Extent file
     */
    public Osoba(String imie, String nazwisko, String email, Adres adres,Zamowienie z) throws Exception {
        zamowieniaArrayList = new ArrayList<>();
        this.imie = imie;
        this.nazwisko = nazwisko;
        //this.email = email;
        setEmail(email);
        this.adres = adres;
        //zlozZamowienie(z);
        zamowieniaArrayList.add(z);
        this.addLink("posiada","zamieszkuje",adres);
    }

    /**
     * The constructor for class Osoba.
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @throws Exception --when no Extent file
     */
    public Osoba(String imie, String nazwisko, String email, Adres adres) throws Exception {
        this.imie = imie;
        this.nazwisko = nazwisko;
        //this.email = email;
        setEmail(email);
        this.adres = adres;
        this.addLink("posiada","zamieszkuje",adres);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public Adres getAdres() {
        return adres;
    }

    /**
     * This method sets an Email keeping it with unique constraint
     * @param email
     * @throws Exception --when no Extent file
     */
    public void setEmail(String email) throws Exception {
        for(String p:listaEmaili){
            if(p.equals(email)){
                throw new IllegalArgumentException("Podany email istnieje już w systemie");
            }
        }
        listaEmaili.add(email);
        this.email = email;
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
     * This method shows the list of all bikes from the Extent
     * @throws Exception --when no Extent file
     */
    public static void wyswietlListaWszystkichRowerow() throws Exception {
        List<Rower> extent = ObjectPlus.getAllRowerExtent();
        for(Rower r : extent){
            System.out.println(r);
        }
    }

    /**
     * This method shows Zamowienie for specific Osoba
     * @throws Exception --when no Extent file
     */
    public void pokazZamowienia() throws Exception {
        //List<Zamowienie> extentZamowienia = ObjectPlus.getZamowienieExtent();
        for(Zamowienie r : zamowieniaArrayList){
            System.out.println(r);
        }
    }

    /**
     * This method is adding Zamowienie to ArrayList
     * @param zamowienie
     */
    public void  zlozZamowienie(Zamowienie zamowienie){
        zamowieniaArrayList.add(zamowienie);
    }
    public String wybierzPlatnosc(){
        String platnosc="";
        int ilosc =6;
        switch(ilosc){
            case 1:
                platnosc="PaySafeCard";
                break;
            case 2:
                platnosc="Blik";
                break;
            case 3:
                platnosc="Paypal";
                break;
            case 4:
                platnosc="Przelewy24";
                break;
            case 5:
                platnosc="PayU";
                break;
            case 6:
                platnosc="Visa";
                break;
        }
        return platnosc;
    }


    public String toString(){
        String info = new String();
        info += "Imie: " + getImie();
        info += "\nNazwisko: "+ getNazwisko();
        info += "\nEmail: "+ getEmail() ;
        info += "\nAdres: "+ getAdres() + "\n";
        return info;
    }
}
