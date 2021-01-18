package com.gatoraid.whitehouseexecactions.dao;

import com.gatoraid.whitehouseexecactions.entity.WhiteHouse;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class WhiteHouseDAOImpl implements WhiteHouseDAO{

    private EntityManager entityManager;

    @Autowired
    public WhiteHouseDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public List<WhiteHouse> GetAllItems() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WhiteHouse> whiteHouseQuery=
                currentSession.createQuery("from WhiteHouse", WhiteHouse.class);
        List<WhiteHouse> whiteHouses = whiteHouseQuery.getResultList();
        return whiteHouses;
    }

    @Override
    @Transactional
    public void saveItem(WhiteHouse theWhiteHouse) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save items
        currentSession.saveOrUpdate(theWhiteHouse);

    }

    @Override
    @Transactional
    public List<WhiteHouse> GetItem(WhiteHouse theWhiteHouse) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WhiteHouse> whiteHouseQuery =
                currentSession.createQuery("from WhiteHouse s where s.text=:i").setParameter("i", theWhiteHouse.getText());
        // get the item
        List<WhiteHouse> article = whiteHouseQuery.getResultList();
        return article;

    }

    @Override
    public void deleteItem(int theId) {

    }
}
