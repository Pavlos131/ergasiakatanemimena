package group54.managementeteries.dao;


import group54.managementeteries.Entity.aitisi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class aitisiDAOimpl implements aitisiDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public aitisi getaitisi(Integer id) {
              return entityManager.find(aitisi.class, id);
    }

    @Override
    @Transactional
    public List<aitisi> getAitiseis() {
        TypedQuery<aitisi> query = entityManager.createQuery("from aitisi", aitisi.class);
        return query.getResultList();
    }




    @Override
    @Transactional
    public void saveAitisi(aitisi Aitisi) {
        System.out.println("aitisi "+ Aitisi.getId());
        if (Aitisi.getId() == null) {
            entityManager.persist(Aitisi);
        } else {
            entityManager.merge(Aitisi);
        }

    }

    @Override
    @Transactional
    public void deleteAitisi(Integer aitisi_id) {
        System.out.println("Deleting aitisi with id: " + aitisi_id);
        entityManager.remove(entityManager.find(aitisi.class, aitisi_id));
    }

    public List<aitisi> getAitiseisid(Integer id) {
        TypedQuery<aitisi> query = entityManager.createQuery(
                "SELECT e FROM aitisi e WHERE e.antiprosopos_id = :id", aitisi.class);
        query.setParameter("antiprosopos_id", id);
        return query.getResultList();
    }
}