package s18840;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String extentFile = "C:\\Users\\Mikołaj\\Desktop\\MAS_FINAL\\Utrwalanie\\extent.ser";

    public static void main(String[] args) throws Exception {

        deserializeObjects();

        //addPrzykladowe();
        //addKlient();
        //addSerwisant();
        //addSprzedawca();
        //testAssociation();
        //testComposition();
        //testAbstractInheritance();
        //testAttributeConstraint();
        //testSubsetConstraint();
        //testUniqueConstraint();

        pokazEkstensje();
        serializeObjects();

    }

    /**
     * This method shows all given Extentes
     * @throws Exception -- when no Extent file
     */
    private static void pokazEkstensje() throws Exception {
        System.out.println("---------EKSTENSJE----------");
        Klient.showExtent(Klient.class);
        Sprzedawca.showExtent(Sprzedawca.class);
        Serwisant.showExtent(Serwisant.class);
        Zamowienie.showExtent(Zamowienie.class);
        System.out.println("Extent of the class: Rower");
        Rower.wyswietlListaWszystkichRowerow();
        Rower.wyswietlListaRowerow(BMX.class);
    }

    //klasy i atrybuty

    /**
     * This method adds sample data for the first Extent
     * @throws Exception -- when no Extent file
     */
    private static void addPrzykladowe() throws Exception {
        Adres a3 = new Adres("Krakow", "Zimna", "14a", "01-200");
        Klient k3 = new Klient("Adam", "Adamski", "a.jarzab@gmail.com",a3 );

        Rower rower1 = new BMX("bmx",1999.0,12.5,0,12,true,4);
        Rower rower2 = new BMX("bmx2",2999.0,10.5,0,12,true,3);

        double suma =0;
        List<Rower> rowerList = new ArrayList<>();
        rowerList.add(rower1);
        rowerList.add(rower2);
        for(Rower r:rowerList){
            suma+=r.getCena();
        }

        Zamowienie zamowienie1 = new Zamowienie(suma, LocalDate.of(2021,06,13),rowerList);
        Adres a1 = new Adres("Krakow", "Zimna", "14a", "01-200");
        LocalDate d1 = LocalDate.of(2019, 11, 14);
        Serwis serwis = new Serwis(LocalDate.now(),"Naprawa roweru",199.0);
        Serwisant s1 = new Serwisant("Janek", "Wałek", "j.walek@gmail.com", a1, "1512356652", "Serwisant", d1, 1700, 12,30,serwis);
        Adres adresSprzedawca1 = new Adres("Gdansk", "Ciemna", "14a", "11-200");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Sprzedawca sprzedawca1 = new Sprzedawca("Adam", "Nawałek", "a.nawi41k@gmail.com", adresSprzedawca1, "129177444", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);
        sprzedawca1.stworzKlienta(k3);
        sprzedawca1.stworzZamowienie(zamowienie1);

        Klient.showExtent(Klient.class);
        Zamowienie.showExtent(Zamowienie.class);

        System.out.println("LINKI");
        zamowienie1.showLinks("zawiera",System.out);
        sprzedawca1.showLinks("pomaga",System.out);
        sprzedawca1.showLinks("obsluguje",System.out);
        sprzedawca1.showLinks("dokonuje",System.out);

    }

    /**
     * This method adds Serwisants showing use of:
     * atrybut: zlozony
     * atrybut: pochodny/wyliczalny
     * atrybut: klasowy
     * @throws Exception --when no Extent file
     */
    private static void addSerwisant() throws Exception {
        //ATRYBUT ZŁOŻONY
        Adres adresSerwisant1 = new Adres("Krakow", "Zimna", "14a", "01-200");
        LocalDate dataZatrudnieniaSerwisant1 = LocalDate.of(2019, 11, 14);
        //ArrayList<String> test = new ArrayList<>();
        //test.add("ASD");
        Serwis serwis = new Serwis(LocalDate.now(),"Naprawa roweru",199.0);
        Serwisant serwisant1 = new Serwisant("Janek", "Wałek", "j.walekkkkk@gmail.com", adresSerwisant1, "1512388652", "Serwisant", dataZatrudnieniaSerwisant1, 1700, 12,30,serwis);
        serwisant1.podliczWynagrodzenie();
        Serwisant serwisant2 = new Serwisant("a", "a", "j.walek13@gmail.com", adresSerwisant1, "1512359652", "Serwisant", dataZatrudnieniaSerwisant1, 1700, 12,30,serwis);
        serwisant2.podliczWynagrodzenie();
        //ATRYBUT POCHODNY/WYLICZALNY
        serwisant2.podsumujNadgodziny();
        //ATRYBUT KLASOWY RABAT PRACOWNICZY W KLIENCIE
        serwisant2.getRabatPracowniczy();
    }

    /**
     * This method adds Sprzedawca showing use of:
     * overriding
     * @throws Exception --when no Extent file
     */
    private static void addSprzedawca() throws Exception {
        Adres adresSprzedawca1 = new Adres("Gdansk", "Ciemna", "14a", "11-200");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Pracownik Sprzedawca1 = new Sprzedawca("Adam", "Nawałek", "a.nawik@gmail.com", adresSprzedawca1, "129145444", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);
        //PRZESŁONIĘCIE - sprzedawca otrzymuje miesięczny dodatek od sprzedaży 300 zl
        Sprzedawca1.podliczWynagrodzenie();

    }

    /**
     * This method adds Klients showing use of:
     * atrybut: powtarzalny
     * atrybut: opcjonalny
     * overloading
     * @throws Exception --when no Extent file
     */
    private static void addKlient() throws Exception {
        Adres adresKlient1 = new Adres("Pruszkow", "Akacjowa", "3c", "01-100");
        //ATRYBUT POWTARZALNY LICZBA ZAMOWIEN DLA KLIENTA
        Klient klient1 = new Klient("Artur", "Jarzabek", "a.jarzabkowek@gmail.com", adresKlient1);
        LocalDate dataUrodzenia = LocalDate.of(1999, 4, 12);
        klient1.setDataUrodzenia(dataUrodzenia);
        //ATRYBUT OPCJONALNY DLA KLIENTA 2 DATA URODZENIA
        Klient klient2 = new Klient("bbb", "bbb", "bb@gmail.com", adresKlient1);
        //PRZECIĄŻENIE
        klient1.show(5);
        klient1.show(dataUrodzenia);

    }

    //asocjacje

    /**
     * This method shows use of association between Klient - Sprzedawca
     * @throws Exception --when no Extent file
     */
    private static void testAssociation() throws Exception {
        Adres adresKlient1 = new Adres("Pruszkow", "Akacjowa", "3c", "01-100");
        Klient klient1 = new Klient("Artur", "Jarzabek", "a.jarzab44@gmail.com", adresKlient1);
        LocalDate dataUrodzenia = LocalDate.of(1999, 4, 12);
        klient1.setDataUrodzenia(dataUrodzenia);

        Adres adresSprzedawca1 = new Adres("Gdansk", "Ciemna", "14a", "11-200");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Pracownik sprzedawca1 = new Sprzedawca("Adam", "Nawałek", "a.naw2re@gmail.com", adresSprzedawca1, "999145124", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);

        sprzedawca1.addLink("sprzedaje","słucha",klient1);
        sprzedawca1.showLinks("sprzedaje",System.out);


        System.out.println("---Ekstensje---");
        sprzedawca1.showExtent(Sprzedawca.class);
        Klient.showExtent(Klient.class);

        System.out.println("\n---Links---");
        sprzedawca1.showLinks("sprzedaje",System.out);

        System.out.println("\n---Usuwanie---");
        Klient.showExtent(Klient.class);
        sprzedawca1.showExtent(Sprzedawca.class);
        sprzedawca1.deleteLinksObjects("sprzedaje","słucha");

        System.out.println("\n---Ekstensje po usunięciu---");
        Klient.showExtent(Klient.class);
        sprzedawca1.showExtent(Sprzedawca.class);


    }

    /**
     * This method shows use of composition between Serwis - Narzedzia
     * @throws Exception --when no Extent file
     */
    private static void testComposition() throws Exception {
        LocalDate dataPrzyjeciaSerwis1 = LocalDate.of(2021, 4, 12);
        Serwis serwis1 = new Serwis(dataPrzyjeciaSerwis1,"Zepsute koło",30.0);

        Serwis.Narzedzia narzędzia1 = serwis1.dodajNarzedzia("klucz",4);
        Serwis.Narzedzia narzędzia2 = serwis1.dodajNarzedzia("ampul",1);
        serwis1.addLink("zawiera","znajduje się w",narzędzia1);
        serwis1.addLink("zawiera","znajduje się w",narzędzia2);

        System.out.println("---Ekstensje---");
        Serwis.showExtent(Serwis.class);
        System.out.println();
        Serwis.Narzedzia.showExtent(Serwis.Narzedzia.class);

        System.out.println("\n---Links---");
        serwis1.showLinks("zawiera",System.out);
        narzędzia1.showLinks("znajduje się w",System.out);

        System.out.println("\n---Usuwanie---");
        Serwis.showExtent(Serwis.class);
        Serwis.Narzedzia.showExtent(Serwis.Narzedzia.class);
        serwis1.deleteLinksObjects("zawiera","znajduje się w");

        System.out.println("\n---Ekstensje po usunięciu---");
        Serwis.Narzedzia.showExtent(Serwis.Narzedzia.class);
        System.out.println();
        Serwis.showExtent(Serwis.class);
        //Serwis.Narzedzia.showExtent(Serwis.Narzedzia.class);
        //serwis1.showLinks("zawiera",System.out);


    }

    //dziedziczenia

    /**
     * This method shows use of abstract inheritance on Pracownik
     * @throws Exception --when no Extent file
     */
    private static void testAbstractInheritance() throws Exception {
        System.out.println("Sprzedawca");
        Adres adresSprzedawca1 = new Adres("Pruszkow", "Akacjowa", "3c", "01-100");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Pracownik sprzedawca1 = new Sprzedawca("Jan","Kowalski","kowal@gmail.com",adresSprzedawca1,"99023331223","sprzedawca",dataZatrudnieniaSprzedawca1,4500.0);
        System.out.println(sprzedawca1);
        System.out.println(sprzedawca1.podliczWynagrodzenie());

        System.out.println("Kierownik");
        Adres adresKierownik1 = new Adres("Warsazwa", "Ara", "13c", "01-100");
        LocalDate dataZatrudnieniaKierownik1 = LocalDate.of(2020, 01, 04);
        Pracownik kierownik1 = new Kierownik("Adam","Nawalka","an@gmail.com",adresKierownik1,"121424124","kierownik",dataZatrudnieniaKierownik1,9000.0);
        System.out.println(kierownik1);
        System.out.println(kierownik1.podliczWynagrodzenie());

        System.out.println("Serwisant");
        Adres adresSerwisant1 = new Adres("Krakow", "Zimna", "14a", "01-200");
        LocalDate dataZatrudnieniaSerwisant1 = LocalDate.of(2019, 11, 14);
        Serwis serwis = new Serwis(LocalDate.now(),"Naprawa roweru",199.0);
        Pracownik serwisant1 = new Serwisant("Janek", "Wałek", "j.walek898@gmail.com", adresSerwisant1, "1518856652", "Serwisant", dataZatrudnieniaSerwisant1, 1700, 12,30,serwis);
        System.out.println(serwisant1);
        System.out.println(serwisant1.podliczWynagrodzenie());
        System.out.println();
    }

    //ograniczenia

    /**
     * This method shows use of constraint for an attribute in Serwis
     * @throws Exception --when no Extent file
     */
    private static void testAttributeConstraint() throws Exception {
        LocalDate dataPrzyjeciaSerwis1 = LocalDate.of(2021, 4, 12);
        Serwis serwis1 = new Serwis(dataPrzyjeciaSerwis1,"Zepsute koło",30.0);
        try{
            //data z przyszłości
            LocalDate dataPrzyjeciaSerwisError = LocalDate.of(2029, 4, 12);
            Serwis serwis2 = new Serwis(dataPrzyjeciaSerwisError,"Zepsute koło",30.0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method shows use of subset constraint for Sprzedawca - Zamowienie
     * @throws Exception --when no Extent file
     */
    private static void testSubsetConstraint() throws Exception {
        Adres adresSprzedawca1 = new Adres("Gdansk", "Ciemna", "14a", "11-200");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Pracownik sprzedawca1 = new Sprzedawca("Adam", "Nawałek", "a.naw@gmail.com", adresSprzedawca1, "123145124", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);

        LocalDate dataSprzedazy = LocalDate.of(2021, 4, 12);
        Rower rower1 = new BMX("bmx",1999.0,12.5,0,12,true,4);
        Rower rower2 = new BMX("bmx2",2999.0,10.5,0,12,true,3);

        double suma =0;
        List<Rower> rowerList = new ArrayList<>();
        rowerList.add(rower1);
        rowerList.add(rower2);
        for(Rower r:rowerList){
            suma+=r.getCena();
        }

        Zamowienie zamowienie1 = new Zamowienie(suma, LocalDate.of(2021,06,13),rowerList);

        try{
            //add "normal" link
            sprzedawca1.addLink("obsluguje","obslugiwana",zamowienie1);
            //add "subsetLink"
            sprzedawca1.addLink_subset("dokonuje","dokonywana","obsluguje",zamowienie1);
            sprzedawca1.showLinks("obsluguje",System.out);
            sprzedawca1.showLinks("dokonuje",System.out);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method shows use of unique constraint for mail in Pracownik
     * @throws Exception --when no Extent file
     */
    private static void testUniqueConstraint() throws Exception {
        Adres adresSprzedawca1 = new Adres("Gdansk", "Ciemna", "14a", "11-200");
        LocalDate dataZatrudnieniaSprzedawca1 = LocalDate.of(2020, 01, 04);
        Pracownik sprzedawca1 = new Sprzedawca("Adam", "Nawałek", "a.naw34@gmail.com", adresSprzedawca1, "999945124", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);
        Pracownik sprzedawca2 = new Sprzedawca("Adam", "Nawałek", "a.naiw@gmail.com", adresSprzedawca1, "1231459124", "Sprzedawca", dataZatrudnieniaSprzedawca1, 2400);
        Sprzedawca.showExtent(Sprzedawca.class);

    };

    //ekstensja do pliku

    /**
     * This method saves the Extent into the file
     */
    private static void serializeObjects() {
        try {
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            ObjectPlus.writeExtents(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads the Extent from the file
     */
    private static void deserializeObjects() {
        try {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            ObjectPlus.readExtents(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
