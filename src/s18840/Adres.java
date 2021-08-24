package s18840;

import java.io.Serializable;

public class Adres extends ObjectPlus4 implements Serializable {
    String miasto;
    String ulica;
    String numer;
    String kodPocztowy;

    /**
     * The constructor for class Address.
     * @param miasto
     * @param ulica
     * @param numer
     * @param kodPocztowy
     */
    public Adres(String miasto, String ulica, String numer, String kodPocztowy) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNumer() {
        return numer;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    @Override
    public String toString() {
        String info = new String();
        info += "\nmiasto: " + getMiasto();
        info += "\nulica: "+ getUlica() +" "+getNumer();
        info += "\nkod pocztowy: "+ getKodPocztowy();
        return info;
    }
}
