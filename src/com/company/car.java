package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class car {
    static int i = 9, j= 0;
    String name;
    String tryName;
    int normalSpeed;
    Random rand = new Random();
    String[] carNames = {"Blitz",
            "Eagle",
            "Bullet",
            "Mammoth",
            "Empire",
            "Barrage",
            "Parallel",
            "Tradition",
            "Oracle",
            "Sprite"};
    List<String> carNameList = new ArrayList<>(Arrays.asList(carNames));
    Main main = new Main();
    private int distanceTravelled = 0;

    public car(){
        name = carNameList.get(i) + " " + carNameList.get(j);
        i--;
        j++;
        normalSpeed = rand.nextInt(110-80+1)+80;
    }

    public String getName() {
        return name;
    }

    public int getNormalSpeed(){
        return normalSpeed;
    }

    public void oneHour(){
        distanceTravelled += normalSpeed;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getType(){
        return "car";
    }

    public void speedLimit(int limit, boolean isItRaining){
        if(isItRaining){
            normalSpeed = limit;
        } else {
            normalSpeed = rand.nextInt(110 - 80 + 1) + 80;
        }
    }
}
