package s18840;

import java.time.LocalDate;

public class Kierownik extends Pracownik {
    /**
     * The constructor for class Kierownik.
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
    public Kierownik(String imie, String nazwisko, String email, Adres adres, String pesel, String stanowisko, LocalDate dataZatrudnienia, double wysokoscPensji) throws Exception {
        super(imie, nazwisko, email, adres, pesel, stanowisko, dataZatrudnienia, wysokoscPensji);
    }

    /**
     * The constructor for class Kierownik.
     * @param lastPracownik
     * @throws Exception --when no Extent file
     */
    public Kierownik(Pracownik lastPracownik) throws Exception {
        super(lastPracownik.getImie(),lastPracownik.getNazwisko(),lastPracownik.getEmail(),lastPracownik.getAdres(),lastPracownik.getPesel(),lastPracownik.getStanowisko(),lastPracownik.getDataZatrudnienia(),lastPracownik.getWysokoscPensji());
    }

    /**
     * This method returns wysokoscPensji
     * @return
     */
    @Override
    public double podliczWynagrodzenie() {
        return getWysokoscPensji();
    }

    /**
     * This method assigns person to his role
     */
    public void rozdzielPrace(){

    }
}
