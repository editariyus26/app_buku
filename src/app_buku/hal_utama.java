/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_buku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ANDROIDA-PC
 */
public class hal_utama extends Application {

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("interface_utama.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
        
        Scene scene = new Scene(root);  
        stage.getIcons().add(new Image("file:src/gambar/buku.png")); //menambahkan ikon di app
        stage.setScene(scene);
        stage.setTitle("Halaman Login");
        stage.show();
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
