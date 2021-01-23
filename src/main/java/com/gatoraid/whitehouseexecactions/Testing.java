package com.gatoraid.whitehouseexecactions;

import com.gatoraid.whitehouseexecactions.dao.BidenDAO;
import com.gatoraid.whitehouseexecactions.entity.Biden;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Testing {

    private BidenDAO bidenDAO;

    @Autowired
    public Testing(BidenDAO theBidenDAO){
        bidenDAO = theBidenDAO;
    }

    public Testing() {

    }

    public List<Biden> findAll(){
        return bidenDAO.GetAllItems();
    }
}
