package entities;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:29:52 AM
 */
public class Animal {
    
    protected int type;
    protected String id;
    protected String name;
    protected int numLegs;
    protected String color;
    protected String characteristic;
    protected String movingMethod;
    protected double weight;
    protected String food;
    protected String makingSoundMethod;

    public Animal() {
    }

    public Animal(String id) {
        this.id = id;
    }
    
    public Animal(Animal animal) {
        type = animal.getType();
        id = animal.getId();
        name = animal.getName();
        numLegs = animal.getNumLegs();
        color = animal.getColor();
        characteristic = animal.getCharacteristic();
        movingMethod = animal.getMovingMethod();
        weight = animal.getWeight();
        food = animal.getFood();
        makingSoundMethod = animal.getMakingSoundMethod();
    }

    public Animal(int type, String id, String name, int numLegs, String color, String characteristic, String movingMethod, double weight, String food, String makingSoundMethod) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.numLegs = numLegs;
        this.color = color;
        this.characteristic = characteristic;
        this.movingMethod = movingMethod;
        this.weight = weight;
        this.food = food;
        this.makingSoundMethod = makingSoundMethod;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getMovingMethod() {
        return movingMethod;
    }

    public void setMovingMethod(String movingMethod) {
        this.movingMethod = movingMethod;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMakingSoundMethod() {
        return makingSoundMethod;
    }

    public void setMakingSoundMethod(String makingSoundMethod) {
        this.makingSoundMethod = makingSoundMethod;
    }

    @Override
    public String toString() {
        return type + ";" + id + ";" + name + ";" + numLegs + ";" + color + ";" + characteristic + ";" + movingMethod + ";" + weight + ";" + food + ";" + makingSoundMethod;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Animal) {
            if (this.id.equals(((Animal) obj).getId())) {
                result = true;
            }
        }
        return result;
    }
    
    public String display() {
        return "ID: " + id + ", name: " + name + ", numlegs: " + numLegs + ", color: " + color + ", characteristic: " + characteristic + ", movingMethod: " + movingMethod + ", weight: " + weight + ", food: " + food + ", makingSoundMethod: " + makingSoundMethod;
    }
}
