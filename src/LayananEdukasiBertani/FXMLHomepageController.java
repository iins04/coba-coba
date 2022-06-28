
package LayananEdukasiBertani;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLHomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    void menuMulai(ActionEvent event) throws IOException {
        Parent Homepage = FXMLLoader.load(getClass().getResource("FXMLMenuAwal.fxml"));
        Scene sceneStart = new Scene (Homepage);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sceneStart);
        stage.setResizable(false);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
