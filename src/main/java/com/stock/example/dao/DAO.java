package com.stock.example.dao;

import com.stock.example.Exception.DAOException;
import com.stock.example.entity.Order;
import com.stock.example.entity.Stock;

import java.util.List;

public interface DAO {
    public void addStock(Stock stock) throws DAOException;
    public List<Stock> getStocks() throws DAOException;
    public void addOrder(Order order) throws DAOException;
    public List<Order> getOrders() throws DAOException;
}
