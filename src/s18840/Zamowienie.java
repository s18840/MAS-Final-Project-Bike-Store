package s18840;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Zamowienie extends ObjectPlusPlus {
    private int numer;
    private double kwota;
    private LocalDate dataZakupu;
    private Status status;
    private static List<Integer> listaZamowien = new ArrayList<>();
    private static int nastepnyNumer=0;

    /**
     * The constructor for class Zamowienie.
     * @see ObjectPlusPlus {@link #addLink(String, String, ObjectPlusPlus)}
     * @param kwota
     * @param dataZakupu
     * @param rowerList
     */
    public Zamowienie(double kwota, LocalDate dataZakupu,List<Rower>rowerList) {
        this.numer = generateNumber();
        nastepnyNumer++;
        this.kwota = kwota;
        this.dataZakupu = dataZakupu;
        setStatus(Status.NIEOPLACONE);
        for(Rower r:rowerList) {
            this.addLink("zawiera", "należy", r);
        }
    }

    /**
     * The constructor for class Zamowienie.
     * @see ObjectPlusPlus {@link #addLink(String, String, ObjectPlusPlus)}
     * @param rowerList
     */
    public Zamowienie(List<Rower> rowerList) {
        setStatus(Status.STWORZONE);
        for(Rower r:rowerList) {
            this.addLink("zawiera", "należy", r);
        }
    }

    /**
     * This method generates the Numer
     * @return
     */
    public int generateNumber(){
        int min=1;
        int max=10000;
        int range =(max-min)+1;
        this.numer = (int) (Math.random()*range)+min;
        return this.numer;
    }

    /**
     * This method changes status for OPLACONE
     */
    public void oplac(){
        setStatus(Status.OPLACONE);
    }

    public static int getNastepnyNumer() {
        return nastepnyNumer++;
    }

    public static void setNastepnyNumer(int nastepnyNumer) {
        Zamowienie.nastepnyNumer = nastepnyNumer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getNumer() {
        return numer;
    }

    /**
     * This method sets Numer keeping it unique
     * @param numer
     */
    public void setNumer(int numer) {
        for(int i:listaZamowien){
            if(i==numer){
                throw new IllegalArgumentException("Podany numer zamówienia już istnieje");
            }
        }
        listaZamowien.add(numer);
        this.numer = numer;
    }

    public double getKwota() {

        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public LocalDate getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(LocalDate dataZakupu) {
        this.dataZakupu = dataZakupu;
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
            //ObjectPlus.deleteExtension(o);
            deleteLinks(roleName);
            ((Klient) o).deleteLinks(reverseRoleName);

        }
    }

    /**
     * This method deletes Object with Links
     * @param roleName
     * @param reverseRoleName
     * @param roleNameRole
     * @param reverseRoleNameRole
     * @throws Exception --when no Extent file
     */
    public void deleteLinksObjects(String roleName, String reverseRoleName,String roleNameRole, String reverseRoleNameRole) throws Exception {
        ObjectPlus.deleteExtension(this);
        //ObjectPlus.deleteExtension(o);
        deleteLinks(roleName);
        deleteLinks(reverseRoleName);
        deleteLinks(roleNameRole);
        deleteLinks(reverseRoleNameRole);
    }

    /**
     *This method deletes Links
     * @param roleName
     * @param reverseRoleName
     * @throws Exception --when no Extent file
     */
    public void deleteLinks(String roleName, String reverseRoleName) throws Exception {
        for (Object o : this.getLinks(roleName)) {
            deleteLinks(roleName);
            ((Klient) o).deleteLinks(reverseRoleName);

        }
    }
    public String toString(){
        String info = new String();
        info += "Zamówienie: ";
        info += "Numer: " + getNumer();
        info += "  Kwota: "+ getKwota();
        info += " Data Zakupu: "+getDataZakupu();
        info += " Status: "+getStatus()+"\n";
        return info;
    }

}
