package com.gatoraid.whitehouseexecactions.dao;

import com.gatoraid.whitehouseexecactions.entity.Biden;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class BidenDAOImpl implements BidenDAO {

    private EntityManager entityManager;

    @Autowired
    public BidenDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public List<Biden> GetAllItems() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Biden> whiteHouseQuery=
                currentSession.createQuery("from Biden", Biden.class);
        List<Biden> bidens = whiteHouseQuery.getResultList();
        return bidens;
    }

    @Override
    @Transactional
    public void saveItem(Biden theBiden) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save items
        currentSession.saveOrUpdate(theBiden);

    }

    @Override
    @Transactional
    public List<Biden> GetItem(Biden theBiden) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Biden> bidenQuery =
                currentSession.createQuery("from Biden s where s.text=:i").setParameter("i", theBiden.getText());
        // get the item
        List<Biden> article = bidenQuery.getResultList();
        return article;

    }

    @Override
    public void deleteItem(int theId) {

    }
}
