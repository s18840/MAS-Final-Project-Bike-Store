package s18840;

import java.time.LocalDate;

public class Serwis extends ObjectPlus4 {
    private LocalDate dataPrzyjęcia;
    private String opisNaprawy;
    private double kwota;

    /**
     * The constructor for class Serwis
     * @param dataPrzyjęcia
     * @param opisNaprawy
     * @param kwota
     * @throws Exception --when no Extent file
     */
    public Serwis(LocalDate dataPrzyjęcia, String opisNaprawy, double kwota) throws Exception {
        //this.dataPrzyjęcia = dataPrzyjęcia;
        setDataPrzyjęcia(dataPrzyjęcia);
        this.opisNaprawy = opisNaprawy;
        this.kwota = kwota;
    }

    /**
     * This method allows to dodajNarzedzia into Serwis
     * @param nazwa
     * @param ilosc
     * @return
     */
    public Narzedzia dodajNarzedzia(String nazwa,int ilosc){
        return new Narzedzia(nazwa,ilosc);
    }

    public LocalDate getDataPrzyjęcia() {
        return dataPrzyjęcia;
    }

    /**
     * This method sets DataPrzyjecia and not allows dates from the past
     * @param dataPrzyjęcia
     * @throws Exception --when no Extent file
     */
    public void setDataPrzyjęcia(LocalDate dataPrzyjęcia) throws Exception {
        if(dataPrzyjęcia.isAfter(LocalDate.now())){
            throw new Exception("Data przyjęcia nie może być datą z przyszłości");
        }
        this.dataPrzyjęcia = dataPrzyjęcia;
    }
    public String getOpisNaprawy() {
        return opisNaprawy;
    }
    public void setOpisNaprawy(String opisNaprawy) {
        this.opisNaprawy = opisNaprawy;
    }
    public double getKwota() {
        return kwota;
    }
    public void setKwota(double kwota) {
        this.kwota = kwota;
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
            ((Narzedzia) o).deleteLinks(reverseRoleName);

        }
    }
    @Override
    public String toString() {
        return "Serwis{" +
                "Data Przyjęcia=" + dataPrzyjęcia +
                ", Opis Naprawy='" + opisNaprawy + '\'' +
                ", kwota=" + kwota +
                '}';
    }

    /**
     * Inner class
     */
    public class Narzedzia extends ObjectPlusPlus{
        private String nazwa;
        private int ilosc;

        /**
         * The constructor for inner class Narzedzia
         * @param nazwa
         * @param ilosc
         */
        private Narzedzia(String nazwa, int ilosc) {
            this.nazwa = nazwa;
            this.ilosc = ilosc;
        }
        public String getNazwa() {
            return nazwa;
        }
        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }
        public int getIlosc() {
            return ilosc;
        }
        public void setIlosc(int ilosc) {
            this.ilosc = ilosc;
        }

        @Override
        public String toString() {
            return "Narzedzia{" +
                    "nazwa='" + nazwa + '\'' +
                    ", ilosc=" + ilosc +
                    '}';
        }
    }
}

