package services;

import exceptions.NotATriangleException;
import models.Triangle;

public class TriangleService {

    public static int getTrianglePerimeter(Triangle triangle) throws NotATriangleException {
        if(checkOnCorrectness(triangle)){
            return triangle.getFirstTriangleSide() +
                    triangle.getSecondTriangleSide() +
                    triangle.getThirdTriangleSide();
        }else {
            throw new NotATriangleException("This model is not a Triangle");
        }
    }

    public static double getTriangleSquare(Triangle triangle) throws NotATriangleException {
        if(checkOnCorrectness(triangle)) {
            int p = getTrianglePerimeter(triangle) / 2;
            return Math.sqrt(p * (p-triangle.getFirstTriangleSide()) *
                    (p-triangle.getSecondTriangleSide()) *
                    (p-triangle.getThirdTriangleSide()));
        }else {
            throw new NotATriangleException("This model is not a Triangle");
        }
    }

    public static boolean isTriangleEquilateral(Triangle triangle) throws NotATriangleException {
        if(checkOnCorrectness(triangle)) {
            return triangle.getFirstTriangleSide() == triangle.getSecondTriangleSide() &&
                    triangle.getSecondTriangleSide() == triangle.getThirdTriangleSide();
        }else {
            throw new NotATriangleException("This model is not a Triangle");
        }
    }

    public static boolean isTriangleRectangular(Triangle triangle) throws NotATriangleException {
        if(checkOnCorrectness(triangle)) {
            return checkOnOneVariantRectangle(
                            triangle.getFirstTriangleSide(),
                            triangle.getThirdTriangleSide(),
                            triangle.getSecondTriangleSide())
                    ||
                    checkOnOneVariantRectangle(
                            triangle.getFirstTriangleSide(),
                            triangle.getSecondTriangleSide(),
                            triangle.getThirdTriangleSide())
                    ||
                    checkOnOneVariantRectangle(
                            triangle.getThirdTriangleSide(),
                            triangle.getSecondTriangleSide(),
                            triangle.getFirstTriangleSide());
        }else {
            throw new NotATriangleException("This model is not a Triangle");
        }
    }

    public static boolean isTriangleIsosceles(Triangle triangle) throws NotATriangleException {
        if(checkOnCorrectness(triangle)) {
            return triangle.getFirstTriangleSide() == triangle.getSecondTriangleSide() ||
                    triangle.getSecondTriangleSide() == triangle.getThirdTriangleSide() ||
                    triangle.getThirdTriangleSide() == triangle.getFirstTriangleSide();
        }else {
            throw new NotATriangleException("This model is not a Triangle");
        }
    }

    public static boolean checkOnCorrectness(Triangle triangle){
        return triangle.getFirstTriangleSide() + triangle.getSecondTriangleSide() > triangle.getThirdTriangleSide()
                && triangle.getSecondTriangleSide() + triangle.getThirdTriangleSide() > triangle.getFirstTriangleSide()
                && triangle.getThirdTriangleSide() + triangle.getFirstTriangleSide() > triangle.getSecondTriangleSide();
    }

    private static boolean checkOnOneVariantRectangle(int firstTriangleSide,
                                                      int secondTriangleSide,
                                                      int thirdTriangleSide){
        return firstTriangleSide * firstTriangleSide +
                secondTriangleSide * secondTriangleSide ==
                thirdTriangleSide * thirdTriangleSide;
    }

}
