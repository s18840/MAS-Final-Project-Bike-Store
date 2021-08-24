package s18840;


import java.time.LocalDate;
import java.util.List;

public class Serwisant extends Pracownik {
    private int nadgodziny;
    private static int stawkaNadgodzina=30;
    private static int rabatPracowniczy =40;
    private int podsNadgodzin=0;

    /**
     * The constructor for class Serwisant
     * @see ObjectPlusPlus {@link #addLink(String, String, ObjectPlusPlus)}
     * @param imie
     * @param nazwisko
     * @param email
     * @param adres
     * @param pesel
     * @param stanowisko
     * @param dataZatrudnienia
     * @param wysokoscPensji
     * @param nadgodziny
     * @param stawkaNadgodzina
     * @throws Exception
     */
    public Serwisant(String imie, String nazwisko, String email, Adres adres, String pesel, String stanowisko, LocalDate dataZatrudnienia, double wysokoscPensji, int nadgodziny, int stawkaNadgodzina,Serwis serwis) throws Exception {
        super(imie, nazwisko, email, adres, pesel, stanowisko, dataZatrudnienia, wysokoscPensji);
        this.nadgodziny = nadgodziny;
        this.stawkaNadgodzina=stawkaNadgodzina;
        this.addLink("wykonuje","wykonywany",serwis);
    }

    /**
     * The constructor for class Serwisant
     * @param lastPracownik
     * @param nadgodziny
     * @param stawkaNadgodzina
     * @throws Exception --when no Extent file
     */
    public Serwisant(Pracownik lastPracownik, int nadgodziny, int stawkaNadgodzina) throws Exception {
        super(lastPracownik.getImie(),lastPracownik.getNazwisko(),lastPracownik.getEmail(),lastPracownik.getAdres(),lastPracownik.getPesel(),lastPracownik.getStanowisko(),lastPracownik.getDataZatrudnienia(),lastPracownik.getWysokoscPensji());
        this.nadgodziny = nadgodziny;
        this.stawkaNadgodzina=stawkaNadgodzina;
    }

    /**
     * This method shows Extent
     * @throws Exception --when no Extent file
     */
    public static void showExtent() throws Exception {
        ObjectPlus.showExtent(Serwisant.class);
    }

    public int getNadgodziny() {
        return nadgodziny;
    }

    public static int getRabatPracowniczy() {
        return rabatPracowniczy;
    }


    public int getStawkaNadgodzina() {
        return stawkaNadgodzina;
    }

    /**
     * This method calculates podsumujNadgodziny
     * @return
     */
    public double podsumujNadgodziny(){
        podsNadgodzin=getStawkaNadgodzina()*getNadgodziny();
        return podsNadgodzin;
    }


    /**
     * This method prints all Serwisants from Extent
     * @throws Exception --when no Extent file
     */
    public static void getAllSerwisants() throws Exception {
        Iterable<Serwisant> serwisants = ObjectPlus.getExtent(Serwisant.class);
        for(Serwisant s:serwisants){
            System.out.println(s);
            System.out.println("");
        }
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

    public String toString(){
        String info = super.toString();
        info += "Stawka nadgodzin: "+ getStawkaNadgodzina();
        info += "\nPodsumowanie nadgodzin: " + podsumujNadgodziny()+"\n";
        return info;
    }

    /**
     * this method calculates Wynagrodzenie
     * @return
     */
    @Override
    public double podliczWynagrodzenie() {
        return (getStawkaNadgodzina()*getNadgodziny())+getWysokoscPensji();
    }

    public static void setRabatPracowniczy(int rabatPracowniczy) {
        Serwisant.rabatPracowniczy = rabatPracowniczy;
    }

    public static void setStawkaNadgodzina(int stawkaNadgodzina) {
        Serwisant.stawkaNadgodzina = stawkaNadgodzina;
    }
}
