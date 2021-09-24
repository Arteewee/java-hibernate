
package com.toko.sepeda.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Toko_Sepeda")
public class TokoSepeda implements Serializable {
    @Id
    @Column(name="kd_sepeda", length=5)
    private String kd_sepeda;
    
    @Column(name="merk", length=20)
    private String merk;
    
    @Column(name="nama", length=20)
    private String nama;

    @Column(name="jenis", length=20)
    private String jenis;

    @Column(name="harga", length=7)
    private int harga;    

    /**
     * @return the kd_sepeda
     */
    public String getKd_sepeda() {
        return kd_sepeda;
    }

    /**
     * @param kd_sepeda the kd_sepeda to set
     */
    public void setKd_sepeda(String kd_sepeda) {
        this.kd_sepeda = kd_sepeda;
    }
    
    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the nama to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
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
