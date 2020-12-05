package model.planes;

import model.Plane;
import model.entities.ClassificationLevel;
import model.entities.ExperimentalPlaneTypes;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneTypes experimentalPlaneTypes;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneTypes experimentalPlaneTypes, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneTypes = experimentalPlaneTypes;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalPlaneTypes getExperimentalPlaneTypes() {
        return experimentalPlaneTypes;
    }

    public void setExperimentalPlaneTypes(ExperimentalPlaneTypes experimentalPlaneTypes) {
        this.experimentalPlaneTypes = experimentalPlaneTypes;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }



    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("ExperimentalPlane{");
        stringBuilder.append("model='").append(model).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
