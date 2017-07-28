/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDROIDA-PC
 */
public class koneksi {

    private static Connection koneksi;

    public static Connection ambilKoneksi() {
        try {
         
                //registrasi Driver
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                koneksi = DriverManager.getConnection("jdbc:derby://localhost:1527/edi", "root", "root");
                System.out.println("Koneksi Berhasil");
            
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }
}
