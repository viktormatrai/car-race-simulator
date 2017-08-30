package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {

    static boolean isItRaining;
    static int breakDownTurnsLeft;

    public static void main(String[] args) {
        createVehicles();
        raceSimulation();
        raceResults();
    }

    private static boolean isIsItRaining(){
        Random rand = new Random();
        int chanceOfRain = rand.nextInt(100);
        if (chanceOfRain < 31) {
            isItRaining = true;
        } else {
            isItRaining =false;
        }
        return isItRaining;
    }

    private static HashMap<String, List> racers = new HashMap<String, List>();

    /*creating the vehicles participating in the simulation*/
    private static void createVehicles(){
        ArrayList<car> carsArray = new ArrayList<car>(10);
        ArrayList<motorcycle> motorsArray = new ArrayList<motorcycle>(10);
        ArrayList<truck> trucksArray = new ArrayList<truck>(10);

        for (int i = 0; i < 10; i++) {
            car cars = new car();
            carsArray.add(cars);

            motorcycle motorcycles = new motorcycle();
            motorsArray.add(motorcycles);

            truck trucks = new truck();
            trucksArray.add(trucks);
        }

        racers.put("cars", carsArray);
        racers.put("motorcycles", motorsArray);
        racers.put("trucks", trucksArray);
    }

    public static void raceSimulation(){
        for (Object carObj: racers.get("cars")){
            car car = (car) carObj;
            car.speedLimit(70, isItRaining);
            car.oneHour();
        }
        for (Object motorcycleObj: racers.get("motorcycles")){
            motorcycle motorcycle = (motorcycle) motorcycleObj;
            motorcycle.speedLimit(isItRaining);
            motorcycle.hourLongMovement();
        }
        for (Object truckObj: racers.get("trucks")){
            truck truck = (truck) truckObj;
            breakDownTurnsLeft = truck.breakDownTurnsLeft();
            truck.hourLongMovement(breakDownTurnsLeft);
        }
    }

    /*printing the results*/
    public static void raceResults() {
        for (List<Object> sameTypeRacers : racers.values()){
            for (Object racer : sameTypeRacers){
                System.out.println(racer);
            }
        }
    }
}
