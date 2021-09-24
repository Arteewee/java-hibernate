
package com.toko.bunga.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Toko_bunga")
public class TokoBunga implements Serializable {
    @Id
    @Column(name="kd_bunga", length=5)
    private String kd_bunga;
    
    @Column(name="nama", length=20)
    private String nama;

    @Column(name="jenis", length=20)
    private String jenis;

    @Column(name="harga", length=7)
    private int harga;    

    /**
     * @return the kd_bunga
     */
    public String getKd_bunga() {
        return kd_bunga;
    }

    /**
     * @param kd_bunga the kd_bunga to set
     */
    public void setKd_bunga(String kd_bunga) {
        this.kd_bunga = kd_bunga;
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
