package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitorTallOld;
    Visitor visitorTallYoung;
    Visitor visitorShortOld;
    Visitor visitorShortYoung;
    Visitor visitorVeryTall;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitorShortOld = new Visitor(15, 130,10.00);
        visitorShortYoung = new Visitor(9, 130,10.00);
        visitorTallOld = new Visitor(15, 150,5.00);
        visitorTallYoung = new Visitor(9, 150,10.00);
        visitorVeryTall = new Visitor(15, 205,20.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorTooShortOldEnough(){
        assertEquals(false,rollerCoaster.isAllowed(visitorShortOld));
    }

    @Test
    public void visitorTallEnoughTooYoung(){
        assertEquals(false,rollerCoaster.isAllowed(visitorTallYoung));
    }
    @Test
    public void visitorTallEnoughOldEnough(){
        assertEquals(true,rollerCoaster.isAllowed(visitorTallOld));
    }
    @Test
    public void visitorTooShortTooYoung(){
        assertEquals(false,rollerCoaster.isAllowed(visitorShortYoung));
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(8.4,rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void chargedStandardPrice(){
        assertEquals(8.4, rollerCoaster.priceFor(visitorTallOld), 0.01);
    }
    @Test
    public void chargedDoublePrice(){
        assertEquals(16.8, rollerCoaster.priceFor(visitorVeryTall), 0.01);
    }
}
