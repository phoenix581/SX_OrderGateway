package com.byes.paap.rest.ordergateway.dto;

public class OrderDTO
{
    private String originSystem;
    private String orderType;
    private String orderTrade;
    private String orderCreationDate;
    private String orderPriority;
    private String requesterFirstName;
    private String requesterSurname;
    private String requesterTelphoneDirect;
    private String requesterTelephoneMobile;
    private String requesterEmail;
    private String orderDescription;
    private String orderComments;
    private int orderPropertySyscode;
    private int orderRoomSyscode;
    private int orderAssetSyscode;
    private int orderTradesmanSyscode;

    public String getOriginSystem() {
        return originSystem;
    }

    public void setOriginSystem(String originSystem) {
        this.originSystem = originSystem;
    }

    public String getOrderTrade() {
        return orderTrade;
    }

    public void setOrderTrade(String orderTrade) {
        this.orderTrade = orderTrade;
    }

    public String getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(String orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public String getRequesterFirstName() {
        return requesterFirstName;
    }

    public void setRequesterFirstName(String requesterFirstName) {
        this.requesterFirstName = requesterFirstName;
    }

    public String getRequesterSurname() {
        return requesterSurname;
    }

    public void setRequesterSurname(String requesterSurname) {
        this.requesterSurname = requesterSurname;
    }

    public String getRequesterTelphoneDirect() {
        return requesterTelphoneDirect;
    }

    public void setRequesterTelphoneDirect(String requesterTelphoneDirect) {
        this.requesterTelphoneDirect = requesterTelphoneDirect;
    }

    public String getRequesterTelephoneMobile() {
        return requesterTelephoneMobile;
    }

    public void setRequesterTelephoneMobile(String requesterTelephoneMobile) {
        this.requesterTelephoneMobile = requesterTelephoneMobile;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    public int getOrderPropertySyscode() {
        return orderPropertySyscode;
    }

    public void setOrderPropertySyscode(int orderPropertySyscode) {
        this.orderPropertySyscode = orderPropertySyscode;
    }

    public int getOrderRoomSyscode() {
        return orderRoomSyscode;
    }

    public void setOrderRoomSyscode(int orderRoomSyscode) {
        this.orderRoomSyscode = orderRoomSyscode;
    }

    public int getOrderAssetSyscode() {
        return orderAssetSyscode;
    }

    public void setOrderAssetSyscode(int orderAssetSyscode) {
        this.orderAssetSyscode = orderAssetSyscode;
    }

    public int getOrderTradesmanSyscode() {
        return orderTradesmanSyscode;
    }

    public void setOrderTradesmanSyscode(int orderTradesmanSyscode) {
        this.orderTradesmanSyscode = orderTradesmanSyscode;
    }

}