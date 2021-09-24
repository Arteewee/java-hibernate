
package com.toko.buku.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Toko_buku")
public class TokoBuku implements Serializable {
    @Id
    @Column(name="kd_buku", length=5)
    private String kd_buku;
    
    @Column(name="nama", length=20)
    private String nama;

    @Column(name="jenis", length=20)
    private String jenis;

    @Column(name="harga", length=7)
    private int harga;    

    /**
     * @return the kd_buku
     */
    public String getKd_buku() {
        return kd_buku;
    }

    /**
     * @param kd_buku the kd_buku to set
     */
    public void setKd_buku(String kd_buku) {
        this.kd_buku = kd_buku;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
