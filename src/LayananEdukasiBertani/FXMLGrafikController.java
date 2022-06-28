
package LayananEdukasiBertani;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLGrafikController implements Initializable {
    
    @FXML 
    private BarChart bcInformasi;
    @FXML
    private Button buttonKembali;
    
    XYChart.Series<String, Integer> barChart = new XYChart.Series();
 
   public void getData(ObservableList<Data> data){
    int informasiPengelolaHasil = 0;
    int informasiMerusakTanaman = 0;
    int informasiPencegahanPerusakanTanaman = 0;
    int informasiPupukTutorial = 0;
    int informasiAlatTatacara = 0;
    
    for(int i = 0; i < data.size(); i++){
        Data data1 = data.get(i);
        if(data1.getPilihanInformasi().equals("Informasi yang mengelola hasil")){
            informasiPengelolaHasil +=1;
        }else if(data1.getPilihanInformasi().equals("Informasi yang merusak tanaman")){
            informasiMerusakTanaman +=1 ;
        }else if(data1.getPilihanInformasi().equals("Informasi upaya pencegahan kerusakan tanaman")){
            informasiPencegahanPerusakanTanaman +=1;
        }else if(data1.getPilihanInformasi().equals("Informasi mengenai pupuk dan tutorial")){
            informasiPupukTutorial +=1;
        }else{
            informasiAlatTatacara +=1;
        }
    }
    barChart.getData().add(new XYChart.Data("Informasi Yang Mengelola Hasil", informasiPengelolaHasil));
    barChart.getData().add(new XYChart.Data("Informasi Yang Merusak Tanaman", informasiMerusakTanaman));
    barChart.getData().add(new XYChart.Data("Informasi Upaya Pencegahan Kerusakan Tanaman", informasiPencegahanPerusakanTanaman));
    barChart.getData().add(new XYChart.Data("Informasi Mengenai Pupuk dan Tutorial", informasiPupukTutorial));
    barChart.getData().add(new XYChart.Data("Informasi Alat dan Tatacara Bertani", informasiAlatTatacara));
   }
   
    @FXML
    private void ButtonKembali(ActionEvent event) throws IOException{
        Parent Homepage = FXMLLoader.load(getClass().getResource("FXMLMenuAwal.fxml"));
        Scene sceneStart = new Scene (Homepage);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sceneStart);
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bcInformasi.getData().add(barChart);
    }    
    
  
}