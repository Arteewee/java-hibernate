
package com.toko.sepeda.dao;

import com.toko.sepeda.model.TokoSepeda;
import java.util.List;


public interface TokoSepedaDao {
   public void save(TokoSepeda tokosepeda);
   public void delete(TokoSepeda tokosepeda);
   public void update(TokoSepeda tokosepeda);
   public TokoSepeda get(String kd_sepeda);
   public List<TokoSepeda> getList();
}
