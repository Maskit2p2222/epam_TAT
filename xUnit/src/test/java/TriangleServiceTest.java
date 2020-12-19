import exceptions.NotATriangleException;
import models.Triangle;
import org.junit.*;
import org.junit.rules.ExpectedException;
import services.TriangleService;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TriangleServiceTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetTrianglePerimeter() throws NotATriangleException {
        Triangle triangle = new Triangle(5,6,7);
        assertThat(TriangleService.getTrianglePerimeter(triangle), is(5 + 6 + 7));
    }

    @Test
    public void testGetNonCorrectTrianglePerimeter() throws NotATriangleException {
        thrown.expect(NotATriangleException.class);
        thrown.expectMessage("This model is not a Triangle");
        Triangle triangle = new Triangle(5,6,11);
        TriangleService.getTrianglePerimeter(triangle);
    }

    @Test
    public void testGetTriangleSquare() throws NotATriangleException {
        Triangle triangle = new Triangle(6,8,10);
        assertThat(TriangleService.getTriangleSquare(triangle), is(24.));
    }

    @Test
    public void testGetNonCorrectTriangleSquare() throws NotATriangleException {
        thrown.expect(NotATriangleException.class);
        thrown.expectMessage("This model is not a Triangle");
        Triangle triangle = new Triangle(6,8,20);
        TriangleService.getTriangleSquare(triangle);
    }

    @Test
    public void testIsTriangleEquilateral() throws NotATriangleException {
        Triangle triangle = new Triangle(6,8,10);
        assertFalse(TriangleService.isTriangleEquilateral(triangle));
        triangle = new Triangle(7 , 7 , 7);
        assertTrue(TriangleService.isTriangleEquilateral(triangle));
    }

    @Test
    public void testIsNonCorrectTriangleEquilateral() throws NotATriangleException {
        thrown.expect(NotATriangleException.class);
        thrown.expectMessage("This model is not a Triangle");
        Triangle triangle = new Triangle(6,8,20);
        TriangleService.isTriangleEquilateral(triangle);
    }

    @Test
    public void testIsTriangleRectangular() throws NotATriangleException {
        Triangle triangle = new Triangle(3,4,6);
        assertFalse(TriangleService.isTriangleRectangular(triangle));
        triangle = new Triangle(3 , 4 , 5);
        assertTrue(TriangleService.isTriangleRectangular(triangle));
    }

    @Test
    public void testIsNonCorrectTriangleRectangular() throws NotATriangleException {
        thrown.expect(NotATriangleException.class);
        thrown.expectMessage("This model is not a Triangle");
        Triangle triangle = new Triangle(6,8,20);
        TriangleService.isTriangleRectangular(triangle);
    }

    @Test
    public void testIsTriangleIsosceles() throws NotATriangleException {
        Triangle triangle = new Triangle(2,4,3);
        assertFalse(TriangleService.isTriangleIsosceles(triangle));
        triangle = new Triangle(2 , 2, 3);
        assertTrue(TriangleService.isTriangleIsosceles(triangle));
        triangle = new Triangle(2 , 3, 3);
        assertTrue(TriangleService.isTriangleIsosceles(triangle));
        triangle = new Triangle(3 , 2, 3);
        assertTrue(TriangleService.isTriangleIsosceles(triangle));
        triangle = new Triangle(3 , 3, 3);
        assertTrue(TriangleService.isTriangleIsosceles(triangle));
    }

    @Test
    public void testIsNonCorrectTriangleIsosceles() throws NotATriangleException {
        thrown.expect(NotATriangleException.class);
        thrown.expectMessage("This model is not a Triangle");
        Triangle triangle = new Triangle(6,8,20);
        TriangleService.isTriangleIsosceles(triangle);
    }

}
