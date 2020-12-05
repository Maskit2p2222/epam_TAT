package model;

import model.planes.ExperimentalPlane;
import model.entities.MilitaryPlaneType;
import model.planes.MilitaryPlane;
import model.planes.PassengerPlane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;


    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return this.planes
                .stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return this.planes
                .stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return this.getPassengerPlanes()
                .stream()
                .max(Comparator.comparing(PassengerPlane::getPassengersCapacity))
                .get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return this.getMilitaryPlanes()
                .stream()
                .filter(militaryPlane -> militaryPlane
                        .getType()
                        .equals(MilitaryPlaneType.TRANSPORT))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes()
                .stream()
                .filter(militaryPlane -> militaryPlane
                        .getType()
                        .equals(MilitaryPlaneType.BOMBER))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planes
                .stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Airport{");
        stringBuilder.append("planes=").append(planes);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
