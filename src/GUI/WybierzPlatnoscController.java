package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import s18840.*;

import java.io.IOException;


public class WybierzPlatnoscController {

    @FXML
    private ImageView metodaPlat5;
    @FXML
    private ImageView metodaPlat2;
    @FXML
    private ImageView metodaPlat1;
    @FXML
    private ImageView metodaPlat3;
    @FXML
    private ImageView metodaPlat4;
    @FXML
    private ImageView metodaPlat6;
    @FXML
    private Button guzikPaysafe;
    @FXML
    private Button guzikBlik;
    @FXML
    private Button guzikVisa;
    @FXML
    private Button guzikPrzelewy;
    @FXML
    private Button guzikPayu;
    @FXML
    private Button guzikPaypal;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane gridPane;

    /**
     * This method handles action for Wybierz buttons and changes scene to pomyslnie wybrana platnosc
     * @param actionEvent --event on button
     * @Exception -when no extent
     */
    public void handleWybierz(ActionEvent actionEvent) throws Exception {
        if(actionEvent.getSource().equals(guzikPaysafe)){
            Platnosc p=Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.PAYSAFECARD);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }else if(actionEvent.getSource().equals(guzikBlik)){
            Platnosc p;
            p= Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.VISA);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }else if(actionEvent.getSource().equals(guzikVisa)){
            Platnosc p=Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.VISA);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }else if(actionEvent.getSource().equals(guzikPrzelewy)){
            Platnosc p=Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.PRZELEWY24);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }else if(actionEvent.getSource().equals(guzikPayu)){
            Platnosc p=Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.PAYU);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }else if(actionEvent.getSource().equals(guzikPaypal)){
            Platnosc p=Platnosc.realizujPlatnosc(Main.zam.getKwota(),Main.os,Main.zam);
            p.setSposPlatnosci(SposobyPlatnosci.PAYPAL);
            p.showLinks("platnoscZamowienie",System.out);
            p.showLinks("platnoscOsoba",System.out);
        }
        Main.zam.setStatus(Status.NIEOPLACONE);
        changeScene("fxml/pomyslniewybranaplatnosc.fxml", rootPane);

    }

    /**
     * This method allows us to change sceens
     * @param nextSceneFXML -- next scene,URL
     * @param rootPane -- main anchorPane for scene
     */
    public void changeScene(String nextSceneFXML, AnchorPane rootPane) {
        try
        {
            Parent nextView = FXMLLoader.load(getClass().getResource(nextSceneFXML));
            Scene nextScene = new Scene(nextView);
            Stage currentStage = (Stage) rootPane.getScene().getWindow();
            currentStage.setScene(nextScene);
            nextScene.getWindow().centerOnScreen();

            System.out.println("loaded fxml: " + nextSceneFXML);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    /**
     * This method allows initialization for this scene
     */

    @FXML
    public void initialize() {
    }
}
