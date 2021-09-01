package Classes;

public class Satellite {
    public String name;
    public double radius;
    public double distance;
    public double period;

    public Satellite(){
        name = "";
        radius = 0;
        distance = 0;
        period = 0;
    }

    public Satellite(String name, double radius, double distance, double period){
        this.name = name;
        this.period = period;
        this.distance = distance;
        this.radius = radius;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPeriod() {
        return period;
    }

    public double getRadius() {
        return radius;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
