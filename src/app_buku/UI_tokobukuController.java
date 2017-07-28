/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_buku;

import groovy.util.ObservableList;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import konfigurasi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author ANDROIDA-PC
 */
public class UI_tokobukuController implements Initializable {

    //komponen untuk tab1
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtJudul;
    @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox<String> cbPenerbit;
    @FXML
    private DatePicker dpTgl;
    @FXML
    private Button btnSimpan;
    @FXML
    private TextField txtId;
    @FXML
    private TableColumn<BukuBean, Integer> colId;
    @FXML
    private TableColumn<BukuBean, String> colNama;
    @FXML
    private TableColumn<BukuBean, String> colJudul;
    @FXML
    private TableColumn<BukuBean, String> colPenerbit;
    @FXML
    private TableColumn<BukuBean, Integer> colHarga;
    @FXML
    private TableColumn<BukuBean, String> colTanggal;

    @FXML
    private TableView<BukuBean> tabel_buku;

    EntityManagerFactory emf;
    BukuJpaController jpa;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private TextField txtCari;
    @FXML
    private Button btnCetak;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tab1Buku();
        tab2Laporan();

        emf = Persistence.createEntityManagerFactory("app_bukuPU");
        jpa = new BukuJpaController(emf);

        tampilTabel();

        cbPenerbit.getItems().addAll(
                "Erlangga", "Balai Pustaka", "Tiga Serangkai");
    }

    void tab1Buku() {

    }

    void tab2Laporan() {

    }

    @FXML
    private void simpanData(ActionEvent event) {
        Alert peringatan = new Alert(Alert.AlertType.WARNING,
                "Perhatian Data Yang Anda Masukkan Belum Lengkap..",
                ButtonType.OK);
        if (txtId.getText().isEmpty() || txtNama.getText().isEmpty() || txtJudul.getText().isEmpty() || cbPenerbit.getEditor().getText().isEmpty()
                || txtHarga.getText().isEmpty() || dpTgl.getEditor().getText().isEmpty()) {
            peringatan.showAndWait();
            txtId.requestFocus();
        } else {
            Buku a = new Buku();
            a.setIdBuku(Integer.parseInt(txtId.getText()));
            a.setNama(txtNama.getText());
            a.setJudul(txtJudul.getText());
            a.setPenerbit(cbPenerbit.getEditor().getText());
            a.setHarga(Integer.parseInt(txtHarga.getText()));
            a.setTgl(dpTgl.getEditor().getText());

            try {
                jpa.create(a);

                Alert peringatan2 = new Alert(Alert.AlertType.INFORMATION,
                        "Data Berhasil Disimpan..",
                        ButtonType.OK);

                peringatan2.showAndWait();
                txtId.requestFocus();
                tabel_buku.getItems().clear();
                tampilTabel();

                //cetak struk
                String file_laporan = "src/laporan/struk_beli.jasper";

                HashMap parameter = new HashMap();

                parameter.put("id_beli", txtId.getText());

                JasperPrint cetak_laporan = JasperFillManager.fillReport(file_laporan, parameter, koneksi.ambilKoneksi());
                JasperViewer tampil_laporan = new JasperViewer(cetak_laporan, false);
                tampil_laporan.setVisible(true);
                kosong();

            } catch (Exception ex) {
                System.out.println("ex = " + ex);
            }
        }
    }

    private void kosong() {
        txtId.clear();
        txtNama.clear();
        txtJudul.clear();
        cbPenerbit.getEditor().clear();
        txtHarga.clear();
        dpTgl.getEditor().clear();
    }

    private void tampilTabel() {
        EntityManager em;
        em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Buku> list = em.createNamedQuery("Buku.findAll", Buku.class).getResultList();
        for (Buku sis : list) {
            tabel_buku.getItems().add(new BukuBean(sis.getIdBuku(), sis.getNama(), sis.getJudul(), sis.getPenerbit(), sis.getHarga(), sis.getTgl()));

            colId.setCellValueFactory(new PropertyValueFactory<>("idBuku"));
            colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
            colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
            colPenerbit.setCellValueFactory(new PropertyValueFactory<>("penerbit"));
            colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
            colTanggal.setCellValueFactory(new PropertyValueFactory<>("tgl"));
        }
    }

    @FXML
    private void ubahData(ActionEvent event) {
        Buku a = new Buku();
        a.setIdBuku(Integer.parseInt(txtId.getText()));
        a.setNama(txtNama.getText());
        a.setJudul(txtJudul.getText());
        a.setPenerbit(cbPenerbit.getEditor().getText());
        a.setHarga(Integer.parseInt(txtHarga.getText()));
        a.setTgl(dpTgl.getEditor().getText());

        try {
            jpa.edit(a);

            Alert peringatan3 = new Alert(Alert.AlertType.INFORMATION,
                    "Data Berhasil Diubah..",
                    ButtonType.OK);

            peringatan3.showAndWait();
            kosong();
            txtId.requestFocus();
            tabel_buku.getItems().clear();
            tampilTabel();

        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }
    }

    @FXML
    private void hapusData(ActionEvent event) {
        int a = Integer.parseInt(txtId.getText());

        try {
            jpa.destroy(a);

            Alert peringatan4 = new Alert(Alert.AlertType.INFORMATION,
                    "Data Berhasil Dihapus..",
                    ButtonType.OK);

            peringatan4.showAndWait();
            kosong();
            txtId.requestFocus();
            tabel_buku.getItems().clear();

            tampilTabel();
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }
    }

    @FXML
    private void cariData(KeyEvent event) {

        String cari = txtCari.getText();
        if (cari.equals("")) {
            tabel_buku.getItems().clear();
            tampilTabel();
        } else {
            EntityManager em;
            em = emf.createEntityManager();
            em.getTransaction().begin();

            tabel_buku.getItems().clear();
            List<Buku> list = em.createNamedQuery("Buku.findByJudul", Buku.class).setParameter("judul", cari).getResultList();
            for (Buku sis : list) {
                tabel_buku.getItems().add(new BukuBean(sis.getIdBuku(), sis.getNama(), sis.getJudul(), sis.getPenerbit(), sis.getHarga(), sis.getTgl()));

                colId.setCellValueFactory(new PropertyValueFactory<>("idBuku"));
                colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
                colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
                colPenerbit.setCellValueFactory(new PropertyValueFactory<>("penerbit"));
                colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
                colTanggal.setCellValueFactory(new PropertyValueFactory<>("tgl"));
            }
        }
    }

    @FXML
    private void cetakData(ActionEvent event) {
        try {
            String file_laporan = "src/laporan/laporan_buku.jasper";
            JasperPrint cetak_laporan = JasperFillManager.fillReport(file_laporan, null, koneksi.ambilKoneksi());
            JasperViewer tampil_laporan = new JasperViewer(cetak_laporan, false);
            tampil_laporan.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Gagal Menampilkan Laporan ", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void cekAngka(KeyEvent event) {
        String karakter = event.getCharacter();
        if (!(karakter.matches("([0-9]+(\\.[0-9]+)?)+"))) {
            Alert peringatan5 = new Alert(Alert.AlertType.WARNING,
                    "Pastikan Input Hanya Angka Saja..",
                    ButtonType.OK);
            peringatan5.showAndWait();
            //  txtId.setText("");  //aktifkan ini, jika ingin mengisi ulang kembali textfield yang ditunjuk
        }

    }

    @FXML
    private void cekAngka2(KeyEvent event) {
        String karakter2 = event.getCharacter();
        if (!(karakter2.matches("([0-9]+(\\.[0-9]+)?)+"))) {

            Alert peringatan6 = new Alert(Alert.AlertType.WARNING,
                    "Pastikan Input Hanya Angka Saja..",
                    ButtonType.OK);
            peringatan6.showAndWait();

        }
    }

    @FXML
    private void pilihData(MouseEvent event) {
        BukuBean seleksi = (BukuBean) tabel_buku.getSelectionModel().getSelectedItem();

        txtId.setText(String.valueOf(seleksi.getIdBuku()));
        txtNama.setText(String.valueOf(seleksi.getNama()));
        txtJudul.setText(String.valueOf(seleksi.getJudul()));
        cbPenerbit.getEditor().setText(seleksi.getPenerbit());
        txtHarga.setText(String.valueOf(seleksi.getHarga()));
        dpTgl.getEditor().setText(seleksi.getTgl());
    }

}
