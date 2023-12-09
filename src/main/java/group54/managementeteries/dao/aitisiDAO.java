package group54.managementeteries.dao;
import group54.managementeteries.Entity.Antiprosopos;
import group54.managementeteries.Entity.aitisi;
import java.util.List;

public interface aitisiDAO {
    public aitisi getaitisi(Integer id);
    public List<aitisi> getAitiseis();

    public void saveAitisi(aitisi Aitisi);

    public void deleteAitisi(Integer aitisi_id);




}
