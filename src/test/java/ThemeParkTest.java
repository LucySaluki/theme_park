import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private ThemePark themePark;
    private Visitor visitorStandard;
    private Visitor visitorYoung;
    private Attraction rollerCoaster;
    private Attraction dodgems;
    private Attraction playground;
    private Attraction park;
    private Stall candyFloss;
    private Stall tobacco;
    private Stall iceCream;

    @Before
    public void before(){
        themePark = new ThemePark("Alton Towers");
        visitorYoung= new Visitor(12,130,50.00);
        visitorStandard=new Visitor(21,205, 10.00);
        rollerCoaster = new RollerCoaster("The Void",20);
        dodgems = new Dodgems("Bumper Car",5);
        park = new Park("Lakeside Park",50);
        playground = new Playground("Kiddies Playground", 20);
        candyFloss= new CandyflossStall("Candy King", "John King", ParkingSpot.A2);
        tobacco = new TobaccoStall("Death Sticks", "E.Vil", ParkingSpot.B4);
        iceCream = new IceCreamStall("Gelato Italiano", "Paulo Nutini", ParkingSpot.B1);
    }
    @Test
    public void hasName(){
        assertEquals("Alton Towers", themePark.getName());
    }

    @Test
    public void canAddEntertainment(){
        themePark.addEntertainment(rollerCoaster);
        themePark.addEntertainment(candyFloss);
        assertEquals(2,themePark.getEntertainmentCount());
    }

    @Test
    public void canGetAllReviews(){
        themePark.addEntertainment(rollerCoaster);
        themePark.addEntertainment(dodgems);
        themePark.addEntertainment(park);
        themePark.addEntertainment(playground);
        themePark.addEntertainment(candyFloss);
        themePark.addEntertainment(tobacco);
        themePark.addEntertainment(iceCream);
        assertEquals(95,themePark.getTotalReviews());
    }

    @Test
    public void canGetAllReviewedAttractions(){
        themePark.addEntertainment(rollerCoaster);
        themePark.addEntertainment(dodgems);
        themePark.addEntertainment(park);
        themePark.addEntertainment(playground);
        assertEquals(4, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddAttractionVisited(){
        themePark.visit(visitorStandard,rollerCoaster);
        assertEquals(1,visitorStandard.getVisitedAttractions().size());
        assertEquals(1,rollerCoaster.getVisitCount());
    }
}
