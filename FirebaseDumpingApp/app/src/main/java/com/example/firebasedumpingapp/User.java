package com.example.firebasedumpingapp;

public class User {
    private String UserId =null;
    private String UserEmail = null;
    private String UserName = null;
    private String CellNo =null;
    private String ImagePath =null;

    public User() {
    }

    public User(String userId, String userEmail, String userName, String cellNo, String imagePath) {
        UserId = userId;
        UserEmail = userEmail;
        UserName = userName;
        CellNo = cellNo;
        ImagePath = imagePath;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCellNo() {
        return CellNo;
    }

    public void setCellNo(String cellNo) {
        CellNo = cellNo;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
