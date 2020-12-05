package model.planes;

import model.Plane;
import model.entities.ClassificationLevel;
import model.entities.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneType experimentalPlaneType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneType experimentalPlaneType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalPlaneType getType() {
        return experimentalPlaneType;
    }

    public void setExperimentalPlaneType(ExperimentalPlaneType experimentalPlaneType) {
        this.experimentalPlaneType = experimentalPlaneType;
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
