package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class PlatnopscPrzetwarzanaController {
    @FXML
    private Button guzikOk3;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane gridPane;

    /**
     * This method add action to guzikOk and changes scene to platnosc zaksiegowana
     * @param actionEvent --event on button
     */
    public void guzikOk3OnAction(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(guzikOk3)){
            changeScene("fxml/platnosczaksiegowana.fxml",rootPane);

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
     */

    @FXML
    public void initialize() {
    }
}
