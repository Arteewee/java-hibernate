/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.sepeda.controller;

import com.toko.sepeda.config.HibernateUtil;
import com.toko.sepeda.model.TokoSepeda;
import com.toko.sepeda.model.TokoSepedaTableModel;
import com.toko.sepeda.view.TokoSepedaView;
import java.util.List;
import javax.swing.JOptionPane;
import com.toko.sepeda.dao.TokoSepedaDao;

/**
 *
 * @author artee
 */
public class TokoSepedaController {
       private TokoSepedaView tokoSepedaView;
       private List<TokoSepeda> listTokoSepeda;
       private TokoSepedaTableModel tokoSepedaTableModel;
       private final TokoSepedaDao tokoSepedaDao = HibernateUtil.getTokoSepedaDao();
       
       public TokoSepedaController(TokoSepedaView tokoSepedaView){
           this.tokoSepedaView = tokoSepedaView;
       }
       public void clear(){
           this.tokoSepedaView.getTxtKode().setText("");
           this.tokoSepedaView.getTxtNama().setText("");
           this.tokoSepedaView.getTxtJenis().setText("");
           this.tokoSepedaView.getTxtHarga().setText("");
           this.tokoSepedaView.getTxtMerk().setText("");
           
       }
       public void saveSepeda(){
        TokoSepeda tokoSepeda = new TokoSepeda();
        tokoSepeda.setKd_sepeda(this.tokoSepedaView.getTxtKode().getText());
        tokoSepeda.setNama(this.tokoSepedaView.getTxtNama().getText());
        tokoSepeda.setJenis(this.tokoSepedaView.getTxtJenis().getText());
        tokoSepeda.setMerk(this.tokoSepedaView.getTxtMerk().getText());
        tokoSepeda.setHarga(Integer.parseInt(this.tokoSepedaView.getTxtHarga().getText()));
        
        try{
            tokoSepedaDao.save(tokoSepeda);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Sepeda", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Menyimpan Sepeda", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void updateSepeda(){
        TokoSepeda tokoSepeda = new TokoSepeda();
        tokoSepeda.setKd_sepeda(this.tokoSepedaView.getTxtKode().getText());
        tokoSepeda.setNama(this.tokoSepedaView.getTxtNama().getText());
        tokoSepeda.setJenis(this.tokoSepedaView.getTxtJenis().getText());
        tokoSepeda.setMerk(this.tokoSepedaView.getTxtMerk().getText());
        tokoSepeda.setHarga(Integer.parseInt(this.tokoSepedaView.getTxtHarga().getText()));
        
        try{
            tokoSepedaDao.update(tokoSepeda);
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Sepeda", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Mengubah Sepeda", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void deleteSepeda(){
           if(this.tokoSepedaView.getTxtKode().getText() == null){
               JOptionPane.showMessageDialog(null, "Data Belum Dipilih", "Error", JOptionPane.INFORMATION_MESSAGE);
           }else{
               TokoSepeda tokoSepeda = new TokoSepeda();
               tokoSepeda.setKd_sepeda(this.tokoSepedaView.getTxtKode().getText());
               
               int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus Sepeda?", "Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
               if (option == JOptionPane.YES_OPTION){
                   try{
                        tokoSepedaDao.delete(tokoSepeda);
                        JOptionPane.showMessageDialog(null, "Berhasil Menghapus  Sepeda", "Succsess", JOptionPane.INFORMATION_MESSAGE);
                        clear();
                        getAllData();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Menghapus Sepeda", "Error", JOptionPane.INFORMATION_MESSAGE); 
                        clear();
        }
               }
           }
       }
       
       public void getAllData(){
           listTokoSepeda = tokoSepedaDao.getList();
           tokoSepedaTableModel = new TokoSepedaTableModel(listTokoSepeda);
           this.tokoSepedaView.getTblSepeda().setModel(tokoSepedaTableModel);
           
       }
       public void getData(){
           int rowIndex = this.tokoSepedaView.getTblSepeda().getSelectedRow();
           this.tokoSepedaView.getTxtKode().setText(String.valueOf(this.tokoSepedaView.getTblSepeda().getValueAt(rowIndex, 0)));
           this.tokoSepedaView.getTxtMerk().setText(String.valueOf(this.tokoSepedaView.getTblSepeda().getValueAt(rowIndex, 1)));
           this.tokoSepedaView.getTxtNama().setText(String.valueOf(this.tokoSepedaView.getTblSepeda().getValueAt(rowIndex, 2)));
           this.tokoSepedaView.getTxtJenis().setText(String.valueOf(this.tokoSepedaView.getTblSepeda().getValueAt(rowIndex, 3)));
           this.tokoSepedaView.getTxtHarga().setText(String.valueOf(this.tokoSepedaView.getTblSepeda().getValueAt(rowIndex, 4)));
       }
}

