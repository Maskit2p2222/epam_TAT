package model;

import model.entities.ClassificationLevel;
import model.entities.ExperimentalPlaneType;
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

    public List<MilitaryPlane> getMilitaryPlanesOfType(MilitaryPlaneType militaryPlaneType){
        return this.getMilitaryPlanes()
                .stream()
                .filter(militaryPlane -> militaryPlane
                        .getType()
                        .equals(militaryPlaneType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planes
                .stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanesOfType(ExperimentalPlaneType experimentalPlaneType){
        return this.getExperimentalPlanes()
                .stream()
                .filter(experimentalPlane -> experimentalPlane
                            .getType()
                            .equals(experimentalPlaneType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ExperimentalPlane> getExperimentalPlanesOfSecretion(ClassificationLevel classificationLevel){
        return this.getExperimentalPlanes()
                .stream()
                .filter(experimentalPlane -> experimentalPlane
                        .getClassificationLevel()
                        .equals(classificationLevel))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortByMaxFlightDistance() {
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
