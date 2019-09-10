package com.stock.example.controller;

import com.stock.example.Exception.DAOException;
import com.stock.example.Exception.Message;
import com.stock.example.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StockController {

    @Autowired
    private DAO dao;

    @RequestMapping("/stocks")
    public ResponseEntity<String> getStocks() {
        try {
            return new ResponseEntity(dao.getStocks(), HttpStatus.OK);
        } catch (DAOException daoException) {
            return new ResponseEntity(new Message(daoException.getMessage(), daoException.getCode()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            return new ResponseEntity(new Message(exception.getMessage(), "1000"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/orders")
    public ResponseEntity<String> order() {
        return new ResponseEntity<>("Add Stocks", HttpStatus.OK);
    }
}
