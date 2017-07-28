/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_buku;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDROIDA-PC
 */
@Entity
@Table(name = "BUKU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buku.findAll", query = "SELECT b FROM Buku b")
    , @NamedQuery(name = "Buku.findByIdBuku", query = "SELECT b FROM Buku b WHERE b.idBuku = :idBuku")
    , @NamedQuery(name = "Buku.findByNama", query = "SELECT b FROM Buku b WHERE b.nama = :nama")
    , @NamedQuery(name = "Buku.findByJudul", query = "SELECT b FROM Buku b WHERE b.judul = :judul")
    , @NamedQuery(name = "Buku.findByPenerbit", query = "SELECT b FROM Buku b WHERE b.penerbit = :penerbit")
    , @NamedQuery(name = "Buku.findByHarga", query = "SELECT b FROM Buku b WHERE b.harga = :harga")
    , @NamedQuery(name = "Buku.findByTgl", query = "SELECT b FROM Buku b WHERE b.tgl = :tgl")})
public class Buku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BUKU")
    private Integer idBuku;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JUDUL")
    private String judul;
    @Column(name = "PENERBIT")
    private String penerbit;
    @Column(name = "HARGA")
    private Integer harga;
    @Column(name = "TGL")
    private String tgl;

    public Buku() {
    }

    public Buku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
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

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku)) {
            return false;
        }
        Buku other = (Buku) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app_buku.Buku[ idBuku=" + idBuku + " ]";
    }
    
}
