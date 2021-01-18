package com.gatoraid.whitehouseexecactions.dao;

import com.gatoraid.whitehouseexecactions.entity.WhiteHouse;

import java.util.List;

public interface WhiteHouseDAO{

    public List<WhiteHouse> GetAllItems();

    public void saveItem(WhiteHouse theWhiteHouse);

    public List<WhiteHouse> GetItem(WhiteHouse whiteHouse);

    public void deleteItem(int theId);

}
