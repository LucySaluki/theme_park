import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {
    private String name;
    private ArrayList<IReviewed> entertainments;

    public ThemePark(String name){
        this.name=name;
        this.entertainments = new ArrayList<IReviewed>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return this.entertainments;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.getVisitedAttractions().add(attraction);
        int visitCount = attraction.getVisitCount() + 1;
        attraction.setVisitCount(visitCount);
    }

    public void addEntertainment(IReviewed entertainment){
        this.entertainments.add(entertainment);
    }

    public int getEntertainmentCount(){
       return this.entertainments.size();
    }

    public int getTotalReviews(){
        int ratingTotal=0;
        for(IReviewed entertainment: this.entertainments){
            ratingTotal += entertainment.getRating();
        }
        return ratingTotal;
    }
}
