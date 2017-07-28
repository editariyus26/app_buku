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

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ANDROIDA-PC
 */
public class Interface_homeController implements Initializable {

    @FXML
    private AnchorPane pane_home;
    @FXML
    private MenuItem mnBeranda;
    @FXML
    private MenuItem mnExit;
    @FXML
    private MenuItem mnTransaksi;
    @FXML
    private MenuItem mnAbout;
    @FXML
    private MenuItem mnLogout;
    @FXML
    private MenuBar menunya;
    @FXML
    private Label lblTampil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }

    public void setText(String username)
    {
    this.lblTampil.setText(username);
    }
    
    @FXML
    private void ubah_about(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("interface_about.fxml"));
            pane_home.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ubah_beranda(ActionEvent event) {
        //memanggil scene lain di stage yang sama
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("interface_beranda.fxml"));
            pane_home.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void keluar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void ubah_transaksi(ActionEvent event) {
         try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("UI_tokobuku.fxml"));
            pane_home.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)

            menunya.getScene().getWindow().hide(); //ammbil nama id Menubar
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 212);

            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/gambar/buku.png")); //menambahkan ikon di app
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }

    


}
