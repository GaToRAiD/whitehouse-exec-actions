package com.gatoraid.whitehouseexecactions.dao;

import com.gatoraid.whitehouseexecactions.entity.Biden;
import com.gatoraid.whitehouseexecactions.entity.Bush;

import java.util.List;

public interface BushDAO {
    public List<Bush> GetAllItems();

    public void saveItem(Bush theBush);

    public List<Bush> GetItem(Bush theBush);

    public void deleteItem(int theId);
}
