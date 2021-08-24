package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import s18840.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PokazZamowienieController {

    @FXML
    private Button guzikZaplac;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button guzikPowrot;

    @FXML
    private ListView<Zamowienie> listViewZamowienia = new ListView<Zamowienie>();
    private ObservableList<Zamowienie> zamowienieObservableList = FXCollections.observableArrayList();

    @FXML
    private Label kwota;

    public static Zamowienie zamowienie;

    /**
     * This method shows all Zamowienies from Extension file and adds it to a list
     * @throws Exception --when no extent
     */
    public void pokazZamowienie() throws Exception {
        Iterable<Zamowienie> listaZamowienEkstensja= ObjectPlus.getExtent(Zamowienie.class);
        List<Zamowienie> listaZamowien =new ArrayList<Zamowienie>();
        for(Zamowienie z: listaZamowienEkstensja){
            listaZamowien.add(z);
        }
        zamowienieObservableList.addAll(listaZamowien);

        listViewZamowienia.setItems(zamowienieObservableList);
    }

    /**
     * This method adds action to button guzikZaplac and changes scene to wybierz model platnosci
     * @param actionEvent --event on button
     */
    public void guzikZaplacOnAction(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(guzikZaplac)){

            changeScene("fxml/wybierzmetodeplatnosci.fxml",rootPane);
        }
    }

    /**
     * This method allows us return to the choosing Rower for selected Zamowienie
     * @param actionEvent --event on button
     */
    public void guzikPowrotOnAction(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(guzikPowrot)){
            zamowienie=listViewZamowienia.getSelectionModel().getSelectedItem();
            changeScene("fxml/przegladmodeli.fxml",rootPane);
        }
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
     * @throws Exception --when no extent
     */
    @FXML
    public void initialize() throws Exception {
        pokazZamowienie();
    }


}
