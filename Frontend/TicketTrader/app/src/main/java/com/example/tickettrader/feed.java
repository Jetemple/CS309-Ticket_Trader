package com.example.tickettrader;

public class feed {

    public String name;
    public String gameLocation;
    public int ticketID;
    public String gameDate;
    public String sport;
    public int sellerID;
    public String gameTime;
    public int price;

    public void setTicketiD(int tickID) {
        this.ticketID = tickID;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public void setGame_Date(String date) {
        this.gameDate = date;
    }

    public void setGame_Time(String time) {
        this.gameTime = time;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }




}
