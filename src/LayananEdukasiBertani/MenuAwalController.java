    
package LayananEdukasiBertani;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class MenuAwalController implements Initializable {
    Data y = new Data();
    
    XStream xstream = new XStream(new StaxDriver());
    
    ObservableList input = observableArrayList();
    
    @FXML
    private Button buttonTambah;
    @FXML
    private Button buttonHapus;
    @FXML
    private Button buttonUpdateData;
    @FXML
    private Button buttonGrafik;
    @FXML
    private Button buttonHomepage;
    @FXML
    private Label Tanggal;
    @FXML
    private Label Nomor;
    @FXML
    private Label PilihanInformasi;
    @FXML
    private TextField TfNomor;
    @FXML
    private ChoiceBox cbPilihanInformasi;
    private String[] pilihan = {"Informasi yang mengelola hasil", "Informasi yang merusak tanaman","Informasi upaya pencegahan kerusakan tanaman",
"Informasi mengenai pupuk dan tutorial", "Informasi mengenai alat dan tatacara bertani"};
    @FXML
    private CheckBox cbVideo;
    @FXML
    private CheckBox cbMateri;
    @FXML
    private DatePicker dpTanggal;
    @FXML
    private TableView <Data> InformasiUpdate;
    @FXML
    private TableColumn <Data, String> TcTanggal;
    @FXML
    private TableColumn <Data, String> TcNomor; 
    @FXML
    private TableColumn <Data, String> TcPilihanInformasi;
    @FXML
    private TableColumn  <Data, String> TcMateri_video;
    
    @FXML
    private void handleButtonTambah(ActionEvent event) {
        MenuAwal a = new MenuAwal();
        XStream xstream = new XStream(new StaxDriver());
        LocalDate A;
        
        String temp1 = TfNomor.getText();   
        
        String temp2 = dpTanggal.getValue().toString();
        A = dpTanggal.getValue().plusDays(1);
        System.out.println(dpTanggal.toString());
        String B = A.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
       
        
        String temp3 = cbPilihanInformasi.getValue().toString();
        System.out.println(cbPilihanInformasi.toString());
        
        String temp4 = "";
                
        if(cbMateri.isSelected()){
            temp4 = "Materi";
        }else{
            temp4 = "Video";
        }
        input.add(new Data(temp1,temp2,temp3,temp4));
        
        TfNomor.setText("");
        Tanggal.setText(temp2);
        cbMateri.setText("Materi");
        cbVideo.setText("Video");
        InformasiUpdate.setItems(input);
    }

    
    @FXML 
    private void handleButtonHapusData(ActionEvent event){
        int selectedID = InformasiUpdate.getSelectionModel().getSelectedIndex();
        InformasiUpdate.getItems().remove(selectedID);
    }
    
    @FXML
    private void handleMateri(){
        if(cbMateri.isSelected()){
            cbVideo.setSelected(false);
        }
        cbMateri.toString();
    }
    @FXML
    private void handleVideo(){
         if(cbVideo.isSelected()){
            cbMateri.setSelected(false);
        }
    }
    
    @FXML 
    private void handleButtonUpdateData(ActionEvent event){
        InformasiUpdate.getSelectionModel().getSelectedItem();
        InformasiUpdate.setEditable(true);
        
        TcNomor.setCellFactory(TextFieldTableCell.forTableColumn());
        TcNomor.setOnEditCommit(e->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNomor(e.getNewValue());
        });
        
        TcTanggal.setCellFactory(TextFieldTableCell.forTableColumn());
        TcTanggal.setOnEditCommit(e->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setTanggal(e.getNewValue());
        });
        
        TcPilihanInformasi.setCellFactory(TextFieldTableCell.forTableColumn());
        TcPilihanInformasi.setOnEditCommit(e->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setPilihanInformasi(e.getNewValue());
        });
        
        TcMateri_video.setCellFactory(TextFieldTableCell.forTableColumn());
        TcMateri_video.setOnEditCommit(e->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setJenis(e.getNewValue());
        });     
        
        @SuppressWarnings("unchecked")
        ObservableList<Data> clickedData = InformasiUpdate.getSelectionModel().getSelectedItems();
        Data clicked = clickedData.get(0);
        
        for (Iterator it = input.iterator(); it.hasNext();) {
            Data n = (Data) it.next();
            if (n.getNomor().equals(clicked.getNomor())) {
                
                n.setNomor(TfNomor.getText());
                n.setTanggal(dpTanggal.getValue().toString());
                n.setPilihanInformasi(cbPilihanInformasi.getValue().toString());
                
                //n.setMateri(cbMateri.isSelected());
                //n.setVideo(cbVideo.isSelected());
   
                InformasiUpdate.refresh();
                break;
            }
        }
        TfNomor.setText("");
        dpTanggal.setValue(null);
        cbPilihanInformasi.setValue(null);
        cbMateri.setSelected(true);
        cbVideo.setSelected(true);
    }
    
    @FXML
    private void buttonGrafik (ActionEvent event) throws IOException{
        Parent homepage = FXMLLoader.load(getClass().getResource("FXMLGrafik.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGrafik.fxml"));
        Parent root = loader.load();
        
        FXMLGrafikController scene2Controller = loader.getController();
        scene2Controller.getData(input);
        
        Scene sceneStart = new Scene (root);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sceneStart);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void buttonHomepage (ActionEvent event) throws IOException{
        Parent Homepage = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
        Scene sceneStart = new Scene (Homepage);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sceneStart);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    private void handleButtonSimpan(ActionEvent event) {
         
        String xml = xstream.toXML(y);
        FileOutputStream uji = null;

        try {
        // membuat nama file & folder tempat menyimpan jika perlu

        uji = new FileOutputStream("uji.xml");
        // mengubah karakter penyusun string xml sebagai
        // bytes (berbentuk nomor2 kode ASCII
        byte[] bytes = xml.getBytes("UTF-8");

        // menyimpan file dari bytes
        uji.write(bytes);
        }

        catch (Exception e) {
        System.err.println("Perhatian: " + e.getMessage());
        }

        finally {
        if (uji != null) {
        try {
        uji.close();
        System.out.println("Data berhasil disimpan");
        
        } catch (IOException e) {
        e.printStackTrace();

        }
        }
        }
            }

        void bukaXML(){
        FileInputStream ujiBuka = null;

        try {
        ujiBuka = new FileInputStream("uji.xml");
        
        int isi;
        char charnya;
        
        String stringnya;
        stringnya ="";

        while ((isi = ujiBuka.read()) != -1) {
        charnya= (char) isi;
        stringnya = stringnya + charnya;
        }
        y = (Data) xstream.fromXML(stringnya);
        }

        catch (Exception e){
        System.err.println("test: "+e.getMessage());
        }
        
        finally{
        if(ujiBuka != null){
        try{
        ujiBuka.close();
        }

        catch (IOException e) {
        e.printStackTrace();
        }
        }
        }
            }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TcNomor.setCellValueFactory(new PropertyValueFactory<Data, String>("Nomor"));
        TcTanggal.setCellValueFactory(new PropertyValueFactory<Data, String>("Tanggal"));
        TcPilihanInformasi.setCellValueFactory(new PropertyValueFactory<Data, String>("PilihanInformasi"));
        cbVideo.isSelected();
        TcMateri_video.setCellValueFactory(new PropertyValueFactory<Data, String>("Jenis"));        
        cbPilihanInformasi.getItems().addAll(pilihan);
        cbPilihanInformasi.getSelectionModel().selectFirst();
        cbPilihanInformasi.setValue(String.valueOf(cbPilihanInformasi.getItems()));
        InformasiUpdate.setItems(input);
        bukaXML();

        y.element = new Double[25];
    }
}
