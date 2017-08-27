package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {

    static boolean isItRaining;
    static int breakDownTurnsLeft;

    public static void main(String[] args) {
        HashMap racers = new HashMap();
        ArrayList listOfRacers = new ArrayList();
        racers = createVehicle();
        listOfRacers = raceSimulation(racers);
        raceResults(listOfRacers);
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

    /*creating the vehicles participating in the simulation*/
    private static HashMap createVehicle(){
        ArrayList<car> carsArray = new ArrayList<car>(10);
        ArrayList<motorcycle> motorsArray = new ArrayList<motorcycle>(10);
        ArrayList<truck> trucksArray = new ArrayList<truck>(10);
        HashMap<String, List> racers = new HashMap<String, List>();

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

        return racers;
    }

    public static ArrayList raceSimulation(HashMap<String, List> racers){
        ArrayList listOfRacers = new ArrayList();
        for (int i = 0; i < 10; i++) {

            /* Returns a Set view of the mappings contained in this map.
                The set is backed by the map,
                so changes to the map are reflected in the set, and vice-versa.*/
            for (HashMap.Entry<String, List> entry : racers.entrySet()){ //
             listOfRacers.add(entry.getValue().get(i));
            }
        }

        /* simulating the race with hourLongMovement method from each class
         until it reaches 50 and setting if it is raining or not, or if any truck
          is breaking down */

        for (int i = 0; i < 50; i++) {
            boolean isItRaining = isIsItRaining();

            for (Object racer : listOfRacers){
                if (racer.toString().contains("car")){
                    car car = car.class.cast(racer);
                    car.speedLimit(70, isItRaining);
                    car.oneHour();
                } else if (racer.toString().contains("motor")){
                    motorcycle motorcycle = motorcycle.class.cast(racer);
                    motorcycle.speedLimit(isItRaining);
                    motorcycle.hourLongMovement();
                } else {
                    truck truck = truck.class.cast(racer);
                    breakDownTurnsLeft = truck.breakDownTurnsLeft();
                    truck.hourLongMovement(breakDownTurnsLeft);
                }
            }
        }

        return listOfRacers;
    }

    /*printing the results*/
    public static void raceResults(ArrayList listOfRacers) {
        for (Object racer : listOfRacers){
            if (racer.toString().contains("car")){
                car car = car.class.cast(racer);
                System.out.println("racer: " + car.getName() +", type: "+ car.getType() + ", distance travelled: "+ car.getDistanceTravelled() + "\n");
            } else if(racer.toString().contains("motorcycle")) {
                motorcycle motorcycle = motorcycle.class.cast(racer);
                System.out.println("racer: " + motorcycle.getName() +", type: "+ motorcycle.getType() + ", distance travelled: "+ motorcycle.getDistanceTravelled() + "\n");
            } else {
                truck truck = truck.class.cast(racer);
                System.out.println("racer: " + truck.getName() +", type: "+ truck.getType() + ", distance travelled: "+ truck.getDistanceTravelled());
            }
        }
    }
}
