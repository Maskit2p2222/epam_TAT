package models;

import java.util.Objects;

public class Triangle {

    private int firstTriangleSide;
    private int secondTriangleSide;
    private int thirdTriangleSide;

    public Triangle(int firstTriangleSide, int secondTriangleSide, int thirdTriangleSide) {
        this.firstTriangleSide = firstTriangleSide;
        this.secondTriangleSide = secondTriangleSide;
        this.thirdTriangleSide = thirdTriangleSide;
    }

    public int getFirstTriangleSide() {
        return firstTriangleSide;
    }

    public void setFirstTriangleSide(int firstTriangleSide) {
        this.firstTriangleSide = firstTriangleSide;
    }

    public int getSecondTriangleSide() {
        return secondTriangleSide;
    }

    public void setSecondTriangleSide(int secondTriangleSide) {
        this.secondTriangleSide = secondTriangleSide;
    }

    public int getThirdTriangleSide() {
        return thirdTriangleSide;
    }

    public void setThirdTriangleSide(int thirdTriangleSide) {
        this.thirdTriangleSide = thirdTriangleSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return firstTriangleSide == triangle.firstTriangleSide &&
                secondTriangleSide == triangle.secondTriangleSide &&
                thirdTriangleSide == triangle.thirdTriangleSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstTriangleSide, secondTriangleSide, thirdTriangleSide);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("firstTriangleSide=").append(firstTriangleSide);
        sb.append(", secondTriangleSide=").append(secondTriangleSide);
        sb.append(", thirdTriangleSide=").append(thirdTriangleSide);
        sb.append('}');
        return sb.toString();
    }

}
