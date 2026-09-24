package com.example.start;

public enum BookStatus {
    Borrowed("Занята"),
    Available("Свободна"),
    Lost("Утеряна");

    private String stringStatus;

    BookStatus(String status){
        stringStatus = status;
    }

    public String GetStatusString(){
        return stringStatus;
    }

}
