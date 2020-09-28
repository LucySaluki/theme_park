package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowed(Visitor visitor) {
        if(visitor.getHeight()>=145 && visitor.getAge()>=12){
            return true;
        }
        return false;
    }

    @Override
    public double defaultPrice() {
        return 8.4;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getHeight()>200){
            return this.defaultPrice() * 2;
        }
        return this.defaultPrice();
    }
}
