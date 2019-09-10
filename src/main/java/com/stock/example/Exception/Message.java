package com.stock.example.Exception;


public class Message {
    public Message(String statusMsg, String statusCode) {
        this.statusMsg = statusMsg;
        this.statusCode = statusCode;
    }

    private String statusMsg;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    private String statusCode;

}
