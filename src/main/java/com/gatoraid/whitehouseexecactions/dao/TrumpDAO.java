package com.gatoraid.whitehouseexecactions.dao;


import com.gatoraid.whitehouseexecactions.entity.Bush;
import com.gatoraid.whitehouseexecactions.entity.Trump;

import java.util.List;

public interface TrumpDAO {
    public List<Trump> GetAllItems();

    public void saveItem(Trump theTrump);

    public List<Trump> GetItem(Trump theTrump);

    public void deleteItem(int theId);
}
