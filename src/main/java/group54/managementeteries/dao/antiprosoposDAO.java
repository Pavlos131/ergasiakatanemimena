package group54.managementeteries.dao;
import  group54.managementeteries.Entity.Antiprosopos;
import group54.managementeteries.Entity.aitisi;

import java.util.List;

public interface antiprosoposDAO {

    public List<Antiprosopos> getAntiprosopous();
    public Antiprosopos getAntiprospos(Integer antiprosopos_id);


    public void saveAntiprosopos(Antiprosopos antiprosopos);
    public void deleteAntiprosopos(Integer antiprosopos_id);

    public List<aitisi> getAitiseiss(Integer antiprosopos_id);

}