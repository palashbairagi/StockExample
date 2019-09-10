package com.stock.example.dao;

import com.stock.example.Exception.DAOException;
import com.stock.example.Util.HibernateUtility;
import com.stock.example.entity.Order;
import com.stock.example.entity.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DAOImpl implements DAO {

    @Override
    public void addStock(Stock stock) throws DAOException {

    }

    @Override
    public List<Stock> getStocks() throws DAOException {
        try {
            Session session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Session ");
            Transaction transaction = session.beginTransaction();
            System.out.println("Transaction ");
            Query query = session.createQuery("from Stock");
            System.out.println("List "+query.list());
            List<Stock> stocks = query.list();
            transaction.commit();
            session.close();
            return stocks;
        }catch (Exception e) {
            System.out.println("Exception in DAOImpl [getStocks()] "+e);
            throw new DAOException("Unable to get stocks", "1002");
        }
    }

    @Override
    public void addOrder(Order order) throws DAOException {

    }

    @Override
    public List<Order> getOrders() throws DAOException {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
}
