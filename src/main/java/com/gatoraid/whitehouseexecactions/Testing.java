package com.gatoraid.whitehouseexecactions;

import com.gatoraid.whitehouseexecactions.dao.WhiteHouseDAO;
import com.gatoraid.whitehouseexecactions.entity.WhiteHouse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Testing {

    private WhiteHouseDAO whiteHouseDAO;

    @Autowired
    public Testing(WhiteHouseDAO theWhiteHouseDAO){
        whiteHouseDAO = theWhiteHouseDAO;
    }

    public Testing() {

    }

    public List<WhiteHouse> findAll(){
        return whiteHouseDAO.GetAllItems();
    }
}
