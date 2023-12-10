package group54.managementeteries.dao;

import group54.managementeteries.Entity.Antiprosopos;
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
public class AntiprosoposIMPL implements antiprosoposDAO{


    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Antiprosopos> getAntiprosopous() {
        TypedQuery<Antiprosopos> query = entityManager.createQuery("from Antiprosopos ", Antiprosopos.class);
        return query.getResultList();
    }

    @Override
    public Antiprosopos getAntiprospos(Integer antiprosopos_id) {
        return entityManager.find(Antiprosopos.class, antiprosopos_id);
    }



    @Override
    @Transactional
    public void saveAntiprosopos(Antiprosopos antiprosopos) {
        System.out.println("antiprosopos "+ antiprosopos.getId());
        if (antiprosopos.getId() == null) {
            entityManager.persist(antiprosopos);
        } else {
            entityManager.merge(antiprosopos);
        }
    }

    @Override
    public void deleteAntiprosopos(Integer antiprosopos_id) {
        System.out.println("Deleting antiprosopos with id: " + antiprosopos_id);
        entityManager.remove(entityManager.find(Antiprosopos.class, antiprosopos_id));
    }

    @Override
    @Transactional
    public List<aitisi> getAitiseiss(Integer antiprosopos_id) {
        Antiprosopos antiprosopos = entityManager.find(Antiprosopos.class, antiprosopos_id);
        return antiprosopos.getAitiseis();
    }


}
