package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:31:37 AM
 */
public class FourLegsAnimal extends Animal {

    public FourLegsAnimal() {
        super();
        type = 4;
        numLegs = 4;
    }
    
    public FourLegsAnimal(Animal animal) {
        super(animal);
        type = 4;
        numLegs = 4;
    }

    public FourLegsAnimal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod) {
        super(type, id, name, numLegs, color, characteristic, movingMethod, weight, food, makingSoundMethod);
    }

    @Override
    public String display() {
        return "4-Legs: " + super.display();
    }
    
    
}
