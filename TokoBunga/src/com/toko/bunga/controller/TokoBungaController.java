/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.bunga.controller;

import com.toko.bunga.config.HibernateUtil;
import com.toko.bunga.dao.TokoBungaDao;
import com.toko.bunga.model.TokoBunga;
import com.toko.bunga.model.TokoBungaTableModel;
import com.toko.bunga.view.TokoBungaView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author artee
 */
public class TokoBungaController {
       private TokoBungaView tokoBungaView;
       private List<TokoBunga> listTokoBunga;
       private TokoBungaTableModel tokoBungaTableModel;
       private final TokoBungaDao tokoBungaDao = HibernateUtil.getTokoBungaDao();
       
       public TokoBungaController(TokoBungaView tokoBungaView){
           this.tokoBungaView = tokoBungaView;
       }
       public void clear(){
           this.tokoBungaView.getTxtKode().setText("");
           this.tokoBungaView.getTxtNama().setText("");
           this.tokoBungaView.getTxtJenis().setText("");
           this.tokoBungaView.getTxtHarga().setText("");
           
       }
       public void saveBunga(){
        TokoBunga tokoBunga = new TokoBunga();
        tokoBunga.setKd_bunga(this.tokoBungaView.getTxtKode().getText());
        tokoBunga.setNama(this.tokoBungaView.getTxtNama().getText());
        tokoBunga.setJenis(this.tokoBungaView.getTxtJenis().getText());
        tokoBunga.setHarga(Integer.parseInt(this.tokoBungaView.getTxtHarga().getText()));
        
        try{
            tokoBungaDao.save(tokoBunga);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Bunga", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Menyimpan Bunga", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void updateBunga(){
        TokoBunga tokoBunga = new TokoBunga();
        tokoBunga.setKd_bunga(this.tokoBungaView.getTxtKode().getText());
        tokoBunga.setNama(this.tokoBungaView.getTxtNama().getText());
        tokoBunga.setJenis(this.tokoBungaView.getTxtJenis().getText());
        tokoBunga.setHarga(Integer.parseInt(this.tokoBungaView.getTxtHarga().getText()));
        
        try{
            tokoBungaDao.update(tokoBunga);
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Bunga", "Succsess", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Gagal Mengubah Bunga", "Error", JOptionPane.INFORMATION_MESSAGE); 
           clear();
        }
}   
       public void deleteBunga(){
           if(this.tokoBungaView.getTxtKode().getText() == null){
               JOptionPane.showMessageDialog(null, "Data Belum Dipilih", "Error", JOptionPane.INFORMATION_MESSAGE);
           }else{
               TokoBunga tokoBunga = new TokoBunga();
               tokoBunga.setKd_bunga(this.tokoBungaView.getTxtKode().getText());
               
               int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus bunga?", "Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
               if (option == JOptionPane.YES_OPTION){
                   try{
                        tokoBungaDao.delete(tokoBunga);
                        JOptionPane.showMessageDialog(null, "Berhasil Menghapus  Bunga", "Succsess", JOptionPane.INFORMATION_MESSAGE);
                        clear();
                        getAllData();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Menghapus Bunga", "Error", JOptionPane.INFORMATION_MESSAGE); 
                        clear();
        }
               }
           }
       }
       
       public void getAllData(){
           listTokoBunga = tokoBungaDao.getList();
           tokoBungaTableModel = new TokoBungaTableModel(listTokoBunga);
           this.tokoBungaView.getTblBunga().setModel(tokoBungaTableModel);
           
       }
       public void getData(){
           int rowIndex = this.tokoBungaView.getTblBunga().getSelectedRow();
           this.tokoBungaView.getTxtKode().setText(String.valueOf(this.tokoBungaView.getTblBunga().getValueAt(rowIndex, 0)));
           this.tokoBungaView.getTxtNama().setText(String.valueOf(this.tokoBungaView.getTblBunga().getValueAt(rowIndex, 1)));
           this.tokoBungaView.getTxtJenis().setText(String.valueOf(this.tokoBungaView.getTblBunga().getValueAt(rowIndex, 2)));
           this.tokoBungaView.getTxtHarga().setText(String.valueOf(this.tokoBungaView.getTblBunga().getValueAt(rowIndex, 3)));
       }
}

