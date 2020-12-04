package model;

import java.util.Objects;

abstract public class Plane {
    protected String model;
    protected int maxSpeed;
    protected int maxFlightDistance;
    protected int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        Plane planeOfObjectToEqual = (Plane) object;
        return maxSpeed == planeOfObjectToEqual.maxSpeed &&
                maxFlightDistance == planeOfObjectToEqual.maxFlightDistance &&
                maxLoadCapacity == planeOfObjectToEqual.maxLoadCapacity &&
                Objects.equals(model, planeOfObjectToEqual.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
