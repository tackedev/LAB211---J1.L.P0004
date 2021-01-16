package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:30:17 AM
 */
public class LeglessAnimal extends Animal {

    public LeglessAnimal() {
        super();
        type = 1;
        numLegs = 0;
    }
    
    public LeglessAnimal(Animal animal) {
        super(animal);
        type = 1;
        numLegs = 0;
    }

    public LeglessAnimal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod) {
        super(type, id, name, numLegs, color, characteristic, movingMethod, weight, food, makingSoundMethod);
    }

    @Override
    public String display() {
        return "0-Leg: " + super.display();
    }
    
    
}
