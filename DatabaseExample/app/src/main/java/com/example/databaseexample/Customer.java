package com.example.databaseexample;

public class Customer {
    private String Uerid=null;
    private String Name=null;
    private String CellNo=null;

    public Customer() {

    }

    public Customer(String uerid, String name, String cellNo) {
        Uerid = uerid;
        Name = name;
        CellNo = cellNo;
    }

    public String getUerid() {
        return Uerid;
    }

    public String getName() {
        return Name;
    }

    public String getCellNo() {
        return CellNo;
    }

    public void setUerid(String uerid) {
        Uerid = uerid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCellNo(String cellNo) {
        CellNo = cellNo;
    }
}
