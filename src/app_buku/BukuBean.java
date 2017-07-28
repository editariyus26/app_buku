/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_buku;

/**
 *
 * @author ANDROIDA-PC
 */
public class BukuBean {
    int idBuku,harga;
    String nama,judul,penerbit,tgl;

    public BukuBean(int idBuku, String nama,String judul,String penerbit,int harga,String tgl) {
        this.idBuku = idBuku;
        this.nama = nama;
        this.judul = judul;
        this.penerbit = penerbit;
        this.harga = harga;
        this.tgl = tgl;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    
    

    
}
