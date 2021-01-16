package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:31:46 AM
 */
public class WingedAnimal extends Animal {
    
    protected int numWings;
    protected boolean flyable;
    
    public WingedAnimal() {
        super();
        numLegs = 2;
        numWings = 2;
    }
    
    public WingedAnimal(Animal animal) {
        super(animal);
        numLegs = 2;
        numWings = 2;
    }

    public WingedAnimal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod, int numWings, boolean flyable) {
        super(type, id, name, numLegs, color, characteristic, movingMethod, weight, food, makingSoundMethod);
        this.numWings = numWings;
        this.flyable = flyable;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    public boolean isFlyable() {
        return flyable;
    }

    public void setFlyable(boolean flyable) {
        this.flyable = flyable;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + numWings + ";" + flyable;
    }

    @Override
    public String display() {
        return super.display() + ", numWings: " + numWings + ", " + ((flyable) ? "can fly" : "cannot fly");
    }
}
