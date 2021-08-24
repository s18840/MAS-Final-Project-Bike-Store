package GUI;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import s18840.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrzegladModeliController {

    @FXML
    private ListView<Rower> listViewRowery= new ListView<Rower>();
    private ObservableList<Rower> rowerObservableList = FXCollections.observableArrayList(); //lista nasluchujaca na zdarzenia

    @FXML
    private Button guzikZamowienie;
    @FXML
    private Button guzikDodaj;
    @FXML
    private AnchorPane rootPane;

    public static List<Rower> listaDodanychRowerow = new ArrayList<>();

    /**
     * This method shows all bikes from Extension file and adds it to a list
     * @throws Exception --when no extent
     */
    public void pokazRowery() throws Exception {
        List<Rower> listaRowerowEkstensja= ObjectPlus.getAllRowerExtent();
        rowerObservableList.addAll(listaRowerowEkstensja);
        listViewRowery.setItems(rowerObservableList);
    }

    /**
     * This method adds action to a button guzikZamowienie and changes screen to pokaz zamowienie
     * @param actionEvent --event on button
     */
    public void guzikZamowienieOnAction(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(guzikZamowienie)){
            int suma =0;
            for(Rower rower:listaDodanychRowerow){
                suma+=rower.getCena();
                if(PokazZamowienieController.zamowienie==null) {
                    Main.zam = new Zamowienie(listaDodanychRowerow);
                    Main.zam.setKwota(suma);
                    Main.zam.setNumer(Main.zam.generateNumber());
                    Main.zam.setDataZakupu(LocalDate.now());
                }else{
                    for(Rower r: listaDodanychRowerow) {
                        PokazZamowienieController.zamowienie.addLink("posiada", "należy", r);
                    }
                    PokazZamowienieController.zamowienie.setKwota(suma);
                    PokazZamowienieController.zamowienie.setDataZakupu(LocalDate.now());
                }
            }
            changeScene("fxml/pokazzamowienie.fxml",rootPane);
        }
    }

    /**
     * This method adds action to button guzikDodaj and changes scene to info o dodaniu roweru
     * @param actionEvent --event on button
     */

    public void guzikDodajOnAction(ActionEvent actionEvent){
        Rower selectedItem = listViewRowery.getSelectionModel().getSelectedItem();
        if(actionEvent.getSource().equals(guzikDodaj)){
            listaDodanychRowerow.add(selectedItem);
                //System.out.println(listaDodanychRowerow);
            changeScene("fxml/infoododaniuroweru.fxml",rootPane);
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
     * @throws Exception -when no extent
     */

    @FXML
    public void initialize() throws Exception {
        pokazRowery();
    }



}
