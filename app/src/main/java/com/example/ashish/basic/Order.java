package com.example.ashish.basic;

public class Order {
    String date, orderid, service, status, address, cgst, rate, sgst, discount, paymentStatus
            , total, servicePlace, servicefor,jobAssigned,url,totalTime;

    public Order() {
    }

    public Order(String date, String orderid, String service, String status, String address, String cgst, String rate, String sgst, String discount, String paymentStatus
            , String total, String servicePlace, String servicefor,String jobAssigned,String url,String totalTime) {
        this.date = date;
        this.orderid = orderid;
        this.service = service;
        this.status = status;
        this.address = address;
        this.cgst = cgst;
        this.rate = rate;
        this.sgst = sgst;
        this.discount = discount;
        this.paymentStatus = paymentStatus;
        this.total = total;
        this.servicePlace = servicePlace;
        this.servicefor = servicefor;
        this.jobAssigned = jobAssigned;
        this.url = url;
        this.totalTime = totalTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getUrl() {
        return url;
    }

    public String getJobAssigned() {
        return jobAssigned;
    }

    public String getDate() {
        return date;
    }

    public String getOrderid() {
        return orderid;
    }

    public String getService() {
        return service;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getCgst() {
        return cgst;
    }

    public String getRate() {
        return rate;
    }

    public String getSgst() {
        return sgst;
    }

    public String getDiscount() {
        return discount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getTotal() {
        return total;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public String getServicefor() {
        return servicefor;
    }
}