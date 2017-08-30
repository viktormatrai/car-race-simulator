package com.company;

import java.util.Random;

public class truck {
    Random rand = new Random();
    int name, normalSpeed, distanceTravelled,
            chanceForBreakDown, breakDownTurnsLeft;
    boolean broken;

    public truck(){

        name = rand.nextInt(1000);
        normalSpeed = 100;
        distanceTravelled = 0;
        breakDownTurnsLeft = 0;
    }

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getName() {
        return name;
    }

    public String getType() {
        return "truck";
    }

    public int breakDownTurnsLeft() {
        chanceForBreakDown = rand.nextInt(20);
        if (chanceForBreakDown == 1 && breakDownTurnsLeft == 0){
            breakDownTurnsLeft = 2;
        } else if (breakDownTurnsLeft > 0){
            breakDownTurnsLeft--;
        }
        return breakDownTurnsLeft;
    }

    public void hourLongMovement(int breakDownTurnsLeft) {
        if (breakDownTurnsLeft > 0){
            breakDownTurnsLeft--;
        } else {
            distanceTravelled += normalSpeed;
        }
    }

    @Override // from Object
    public String toString(){
        return "Name: " + name + " Type: " + getType() + " Distance traveled: " + distanceTravelled;
    }
}
