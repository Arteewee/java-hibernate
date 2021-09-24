/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.sepeda.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author artee
 */
public class TokoSepedaTableModel extends AbstractTableModel {
    private List<TokoSepeda> listTokoSepeda = new ArrayList();
    private final String HEADER[] = {"Kode Sepeda","Merk Sepeda", "Nama Sepeda", "Jenis Sepeda", "Harga Sepeda"};
    
    public TokoSepedaTableModel(List<TokoSepeda> listTokoSepeda){
        this.listTokoSepeda = listTokoSepeda;
    }
    @Override
    public int getRowCount() {
        return listTokoSepeda.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       TokoSepeda tokoSepeda = listTokoSepeda.get(rowIndex);
       
       switch(columnIndex){
           case 0:
               return tokoSepeda.getKd_sepeda();
           case 1:
               return tokoSepeda.getMerk();
           case 2:
               return tokoSepeda.getNama();
           case 3:
               return tokoSepeda.getJenis();
           case 4:
               return tokoSepeda
                       
                       .getHarga();
           default:
               return null;
       }
    }
    @Override
    public String getColumnName(int index) {
        return HEADER[index];
    }
    
}
