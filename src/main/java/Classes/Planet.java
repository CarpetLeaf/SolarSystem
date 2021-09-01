package Classes;

import java.util.ArrayList;

public class Planet {
    public String name;
    public double radius;
    public double distance;
    public double period;
    public ArrayList<Satellite> satellites;

    public Planet(){
        this.name = "";
        this.radius = 0;
        this.distance = 0;
        this.period = 0;
        this.satellites = new ArrayList<>();
    }

    public Planet(String name, double radius, double distance, double period){
        this.name = name;
        this.radius = radius;
        this.distance = distance;
        this.period = period;
        this.satellites = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public void setSatellites(ArrayList<Satellite> satellites) {
        this.satellites.addAll(satellites);
    }

    public double getRadius() {
        return radius;
    }

    public double  getDistance() {
        return distance;
    }

    public double getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

}
