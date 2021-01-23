package com.gatoraid.whitehouseexecactions.dao;

import com.gatoraid.whitehouseexecactions.entity.Biden;

import java.util.List;

public interface BidenDAO {

    public List<Biden> GetAllItems();

    public void saveItem(Biden theBiden);

    public List<Biden> GetItem(Biden biden);

    public void deleteItem(int theId);

}
