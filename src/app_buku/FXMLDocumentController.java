/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_buku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDROIDA-PC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    private AnchorPane pane_home;
    @FXML
    private Button login;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button exit;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private void login(ActionEvent event){
       String username=txtUsername.getText();
       String password=txtPassword.getText();
       
        
        if (username.equals("admin") && password.equals("admin")) {
            try {
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();

                // Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("interface_utama.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 775, 512);

                
                Interface_homeController tampil = fxmlLoader.getController();
                tampil.setText("Selamat datang "+username);
                
                // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.getIcons().add(new Image("file:src/gambar/buku.png"));
                stage.setTitle("Halaman Administrator");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                System.out.println("Failed to create new Window." + e);
            }

        } else if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Isi Kolum Username dan Password Anda !");
        } else {
            JOptionPane.showMessageDialog(null, "Username dan Password Anda salah !");
        }
    }

    @FXML
    private void exit(ActionEvent event2) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
