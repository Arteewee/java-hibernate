
package com.toko.bunga.dao;

import com.toko.bunga.model.TokoBunga;
import java.util.List;


public interface TokoBungaDao {
   public void save(TokoBunga tokobunga);
   public void delete(TokoBunga tokobunga);
   public void update(TokoBunga tokobunga);
   public TokoBunga get(String kd_bunga);
   public List<TokoBunga> getList();
}
