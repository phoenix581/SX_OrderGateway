package com.byes.paap.rest.ordergateway.dto;

public class ResponseDTO
{
    private int status;
    private String statusDescription;
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getStatusDescription() {
        return statusDescription;
    }
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}