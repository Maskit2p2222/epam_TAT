import model.Airport;
import model.planes.ExperimentalPlane;
import model.entities.ClassificationLevel;
import model.entities.ExperimentalPlaneType;
import model.entities.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.Test;
import model.planes.MilitaryPlane;
import model.planes.PassengerPlane;
import model.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> passengerPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
    );

    private static List<Plane> militaryPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );

    private static List<Plane> experimentalPlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> militaryBomberPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER)
    );

    private static List<Plane> militaryFighterPlanes = Arrays.asList(
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER)
    );

    private static List<Plane> militaryTransportPlanes = Arrays.asList(
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );

    private static List<Plane> experimentalHighAltitudePlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET)
    );

    private static List<Plane> experimentalVTOLPlanes = Arrays.asList(
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<Plane> experimentalSecretPlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET)
    );

    private static List<Plane> experimentalTopSecretPlanes = Arrays.asList(
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane(
            "Boeing-747", 980, 16100, 70500, 242
    );

    @Test
    public void testGetExperimentalPlanes(){
        List<ExperimentalPlane> militaryPlanes = new Airport(planes).getExperimentalPlanes();
        Assert.assertTrue(militaryPlanes.size() == AirportTest.experimentalPlanes.size()
                && militaryPlanes.containsAll(AirportTest.experimentalPlanes)
                && AirportTest.experimentalPlanes.containsAll(militaryPlanes));

    }

    @Test
    public void testGetPassengerPlanes(){
        List<PassengerPlane> militaryPlanes = new Airport(planes).getPassengerPlanes();
        Assert.assertTrue(militaryPlanes.size() == AirportTest.passengerPlanes.size()
                && militaryPlanes.containsAll(AirportTest.passengerPlanes)
                && AirportTest.passengerPlanes.containsAll(militaryPlanes));
    }

    @Test
    public void testGetMilitaryPlanes(){
        List<MilitaryPlane> militaryPlanes = new Airport(planes).getMilitaryPlanes();
        Assert.assertTrue(militaryPlanes.size() == AirportTest.militaryPlanes.size()
                && militaryPlanes.containsAll(AirportTest.militaryPlanes)
                && AirportTest.militaryPlanes.containsAll(militaryPlanes));
    }


    @Test
    public void testGetMilitaryBomberPlanes(){
        List<MilitaryPlane> militaryBomberPlanes = new Airport(planes)
                .getMilitaryPlanesOfType(MilitaryPlaneType.BOMBER);
        Assert.assertTrue(militaryBomberPlanes.size() == AirportTest.militaryBomberPlanes.size()
                && militaryBomberPlanes.containsAll(AirportTest.militaryBomberPlanes)
                && AirportTest.militaryBomberPlanes.containsAll(militaryBomberPlanes));
    }

    @Test
    public void testGetMilitaryTransportPlanes(){
        List<MilitaryPlane> militaryTransportPlanes = new Airport(planes)
                .getMilitaryPlanesOfType(MilitaryPlaneType.TRANSPORT);
        Assert.assertTrue(militaryTransportPlanes.size() == AirportTest.militaryTransportPlanes.size()
                && militaryTransportPlanes.containsAll(AirportTest.militaryTransportPlanes)
                && AirportTest.militaryTransportPlanes.containsAll(militaryTransportPlanes));
    }

    @Test
    public void testGetMilitaryFighterPlanes(){
        List<MilitaryPlane> militaryFighterPlanes = new Airport(planes)
                .getMilitaryPlanesOfType(MilitaryPlaneType.FIGHTER);
        Assert.assertTrue(militaryFighterPlanes.size() == AirportTest.militaryFighterPlanes.size()
                && militaryFighterPlanes.containsAll(AirportTest.militaryFighterPlanes)
                && AirportTest.militaryFighterPlanes.containsAll(militaryFighterPlanes));
    }

    @Test
    public void testGetExperimentalHighAltitudePlanes(){
        List<ExperimentalPlane> experimentalHighAltitudePlanes = new Airport(planes)
                .getExperimentalPlanesOfType(ExperimentalPlaneType.HIGH_ALTITUDE);
        Assert.assertTrue(experimentalHighAltitudePlanes.size() == AirportTest.experimentalHighAltitudePlanes.size()
                && experimentalHighAltitudePlanes.containsAll(AirportTest.experimentalHighAltitudePlanes)
                && AirportTest.experimentalHighAltitudePlanes.containsAll(experimentalHighAltitudePlanes));

    }

    @Test
    public void testGetExperimentalVTOLPlanes(){
        List<ExperimentalPlane> experimentalVTOLPlanes = new Airport(planes)
                .getExperimentalPlanesOfType(ExperimentalPlaneType.VTOL);
        Assert.assertTrue(experimentalVTOLPlanes.size() == AirportTest.experimentalVTOLPlanes.size()
                && experimentalVTOLPlanes.containsAll(AirportTest.experimentalVTOLPlanes)
                && AirportTest.experimentalVTOLPlanes.containsAll(experimentalVTOLPlanes));
    }

    @Test
    public void testGetExperimentalSecretPlanes(){
        List<ExperimentalPlane> experimentalSecretPlanes = new Airport(planes)
                .getExperimentalPlanesOfSecretion(ClassificationLevel.SECRET);
        Assert.assertTrue(experimentalSecretPlanes.size() == AirportTest.experimentalSecretPlanes.size()
                && experimentalSecretPlanes.containsAll(AirportTest.experimentalSecretPlanes)
                && AirportTest.experimentalSecretPlanes.containsAll(experimentalSecretPlanes));
    }

    @Test
    public void testGetExperimentalTopSecretPlanes(){
        List<ExperimentalPlane> experimentalTopSecretPlanes = new Airport(planes)
                .getExperimentalPlanesOfSecretion(ClassificationLevel.TOP_SECRET);
        Assert.assertTrue(experimentalTopSecretPlanes.size() == AirportTest.experimentalTopSecretPlanes.size()
                && experimentalTopSecretPlanes.containsAll(AirportTest.experimentalTopSecretPlanes)
                && AirportTest.experimentalTopSecretPlanes.containsAll(experimentalTopSecretPlanes));
    }

    @Test
    public void testSortByMaxFlightDistance(){
        Airport airport = new Airport(planes);
        airport.sortByMaxFlightDistance();
        AirportTest.planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        Assert.assertEquals(AirportTest.planes, airport.getPlanes());
    }

    @Test
    public void testSortByMaxSpeed(){
        Airport airport = new Airport(planes);
        airport.sortByMaxSpeed();
        AirportTest.planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        Assert.assertEquals(AirportTest.planes, airport.getPlanes());
    }

    @Test
    public void testSortByMaxLoadCapacity(){
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        AirportTest.planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        Assert.assertEquals(AirportTest.planes, airport.getPlanes());
    }


}
