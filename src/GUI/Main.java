package GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import s18840.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    final static String extentFile = "C:\\Users\\Mikołaj\\Desktop\\MAS_FINAL\\Utrwalanie\\extentGUI.ser";
    private String fxmlPathToNextScene = "fxml/przegladmodeli.fxml";
    public static Zamowienie zam;
    public static Osoba os;

    public static void main(String[] args) throws Exception {
        //deserializeObjects();
        Adres adresKlient1 = new Adres("Pruszkow", "Akacjowa", "3c", "01-100");
        os = new Klient("Artur", "Jarzabek", "a.jarzab1442@gmail.com", adresKlient1);
        addPrzykladowe();

        launch(args);

        Zamowienie.showExtent(Zamowienie.class);
        Klient.showExtent(Klient.class);
        BMX.showExtent(BMX.class);
        MTB.showExtent(MTB.class);
        Szosowy.showExtent(Szosowy.class);
        System.out.println("Extent of the class: Platnosc");
        Platnosc.wyswietlListaWszystkichPlatnosci();

        serializeObjects();
    }

    /**
     * This method starts GUI and shows it
     * @param primaryStage -- sets stage,URL
     * @throws Exception --when no extent
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPathToNextScene)); // load scene from fxml
        primaryStage.setTitle("SSR - System sklepu rowerowy");
        //primaryStage.getIcons().add(new Image("file:bicycle.png"));
        Scene scene = new Scene(root);
        //primaryStage.centerOnScreen();
        primaryStage.setMinHeight(730);
        primaryStage.setMinWidth(1020);
        primaryStage.setMaxHeight(730);
        primaryStage.setMaxWidth(1020);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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

    /**
     * This method adds sample data for the first Extent
     * @throws Exception --when no extent
     */
    public static void addPrzykladowe() throws Exception {
        Rower rower1 = new BMX("bmx",1999.0,12.5,0,12,true,4);
        Rower rower2 = new BMX("bmx2",2999.0,10.5,0,12,true,3);
        Rower rower3 = new Szosowy("Szos",2000.0,10.5,3,10,3);
        Rower rower4 = new Szosowy("Szos2",900.0,10.5,9,10,1);
        Rower rower5 = new MTB("mtb",1700,15.0,21,24,true);
        Rower rower6 = new MTB("mtb2",2900,21.0,14,16,false);

        double suma =0;
        List<Rower>rowerList = new ArrayList<>();
        rowerList.add(rower1);
        rowerList.add(rower2);
        for(Rower r:rowerList){
            suma+=r.getCena();
        }
        Zamowienie zamowienie1 = new Zamowienie(suma, LocalDate.of(2021,06,13),rowerList);
        zamowienie1.setStatus(Status.OPLACONE);
        suma=0;
        List<Rower>rowerList1 = new ArrayList<>();
        rowerList1.add(rower3);
        rowerList1.add(rower4);
        for(Rower r:rowerList1){
            suma+=r.getCena();
        }
        os.zlozZamowienie(zamowienie1);
    }
}