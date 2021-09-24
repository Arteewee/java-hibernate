/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.buku.controller;

import com.toko.buku.config.HibernateUtil;
import com.toko.buku.model.TokoBuku;
import com.toko.buku.model.TokoBukuTableModel;
import com.toko.buku.view.TokoBukuView;
import java.util.List;
import javax.swing.JOptionPane;
import com.toko.buku.dao.TokoBukuDao;

/**
 *
 * @author artee
 */
public class TokoBukuController {
       private TokoBukuView tokoBukuView;
       private List<TokoBuku> listTokoBuku;
       private TokoBukuTableModel tokoBukuTableModel;
       private final TokoBukuDao tokoBukuDao = HibernateUtil.getTokoBukuDao();
       
       public TokoBukuController(TokoBukuView tokoBukuView){
           this.tokoBukuView = tokoBukuView;
       }
       public void clear(){
           this.tokoBukuView.getTxtKode().setText("");
           this.tokoBukuView.getTxtNama().setText("");
           this.tokoBukuView.getTxtJenis().setText("");
           this.tokoBukuView.getTxtHarga().setText("");
           
       }
       public void saveBuku(){
        TokoBuku tokoBuku = new TokoBuku();
        tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
        tokoBuku.setNama(this.tokoBukuView.getTxtNama().getText());
        tokoBuku.setJenis(this.tokoBukuView.getTxtJenis().getText());
        tokoBuku.setHarga(Integer.parseInt(this.tokoBukuView.getTxtHarga().getText()));
        
        try{
            tokoBukuDao.save(tokoBuku);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Buku", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Menyimpan Buku", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void updateBuku(){
        TokoBuku tokoBuku = new TokoBuku();
        tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
        tokoBuku.setNama(this.tokoBukuView.getTxtNama().getText());
        tokoBuku.setJenis(this.tokoBukuView.getTxtJenis().getText());
        tokoBuku.setHarga(Integer.parseInt(this.tokoBukuView.getTxtHarga().getText()));
        
        try{
            tokoBukuDao.update(tokoBuku);
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Buku", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Mengubah Buku", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void deleteBuku(){
           if(this.tokoBukuView.getTxtKode().getText() == null){
               JOptionPane.showMessageDialog(null, "Data Belum Dipilih", "Error", JOptionPane.INFORMATION_MESSAGE);
           }else{
               TokoBuku tokoBuku = new TokoBuku();
               tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
               
               int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus buku?", "Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
               if (option == JOptionPane.YES_OPTION){
                   try{
                        tokoBukuDao.delete(tokoBuku);
                        JOptionPane.showMessageDialog(null, "Berhasil Menghapus  Buku", "Succsess", JOptionPane.INFORMATION_MESSAGE);
                        clear();
                        getAllData();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Menghapus Buku", "Error", JOptionPane.INFORMATION_MESSAGE); 
                        clear();
        }
               }
           }
       }
       
       public void getAllData(){
           listTokoBuku = tokoBukuDao.getList();
           tokoBukuTableModel = new TokoBukuTableModel(listTokoBuku);
           this.tokoBukuView.getTblBuku().setModel(tokoBukuTableModel);
           
       }
       public void getData(){
           int rowIndex = this.tokoBukuView.getTblBuku().getSelectedRow();
           this.tokoBukuView.getTxtKode().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 0)));
           this.tokoBukuView.getTxtNama().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 1)));
           this.tokoBukuView.getTxtJenis().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 2)));
           this.tokoBukuView.getTxtHarga().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 3)));
       }
}

