package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:31:10 AM
 */
public class BipedalFlyingAnimal extends WingedAnimal {

    public BipedalFlyingAnimal() {
        super();
        type = 3;
        flyable = true;
    }
    
    public BipedalFlyingAnimal(Animal animal) {
        super(animal);
        type = 3;
        flyable = true;
    }

    public BipedalFlyingAnimal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod, int numWings, boolean flyable) {
        super(type, id, name, numLegs, color, characteristic, movingMethod, weight, food, makingSoundMethod, numWings, flyable);
    }

    @Override
    public String display() {
        return "Bipedal and flying: " + super.display();
    }
    
    
}
