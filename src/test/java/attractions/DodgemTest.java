package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitorYoung;
    Visitor visitorStandard;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        visitorYoung = new Visitor(10,120,5.00);
        visitorStandard= new Visitor(13, 140, 10.00);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(4.5, dodgems.defaultPrice(),0.01);
    }

    @Test
    public void hasDiscountPriceForUnder12(){
        assertEquals(2.25,dodgems.priceFor(visitorYoung), 0.01);
    }

    @Test
    public void noDiscountPriceFor12OrOver(){
        assertEquals(4.5,dodgems.priceFor(visitorStandard), 0.01);
    }
}
