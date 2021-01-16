package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:30:57 AM
 */
public class BipedalFlightlessAnimal extends WingedAnimal {

    public BipedalFlightlessAnimal() {
        super();
        type = 2;
        flyable = false;
    }
    
    public BipedalFlightlessAnimal(Animal animal) {
        super(animal);
        type = 2;
        flyable = false;
    }

    public BipedalFlightlessAnimal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod, int numWings, boolean flyable) {
        super(type, id, name, numLegs, color, characteristic, movingMethod, weight, food, makingSoundMethod, numWings, flyable);
    }

    @Override
    public String display() {
        return "Bipedal and flightless: " + super.display();
    }
    
    
}
