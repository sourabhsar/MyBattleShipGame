package com.sapient.game.model;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class Ship {

    private int[][] shipLocation;

    public Ship(int[][] shipLocation) {
        this.shipLocation = shipLocation;
    }

    public int[][] getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(int[][] shipLocation) {
        this.shipLocation = shipLocation;
    }
}
