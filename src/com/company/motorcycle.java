package com.company;

import java.util.Random;

public class motorcycle {

    static int nameNumber = 1;
    String name;
    int normalSpeed, distanceTravelled;
    Random rand = new Random();

    public motorcycle(){
        name = "motorcycle" + nameNumber;
        nameNumber++;
        normalSpeed = 100;
        distanceTravelled = 0;
    }

    public void speedLimit(boolean isItRaining) {
        if (isItRaining) {
            normalSpeed = rand.nextInt(50 - 5) + 5;
        } else {
            normalSpeed = 100;
        }
    }
    public String getName(){
            return name;
    }

    public int getNormalSpeed(){
        return normalSpeed;
    }

    public void hourLongMovement(){
        distanceTravelled += normalSpeed;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getType(){
        return "motorcycle";
    }

    @Override // from Object
    public String toString(){
        return "Name: " + name + " Type: " + getType() + " Distance traveled: " + distanceTravelled;
    }
}
