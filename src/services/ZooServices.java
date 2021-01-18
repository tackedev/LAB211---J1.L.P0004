package services;

import entities.Animal;
import entities.BipedalFlightlessAnimal;
import entities.BipedalFlyingAnimal;
import entities.FourLegsAnimal;
import entities.LeglessAnimal;
import java.util.ArrayList;
import repositories.impl.ImpAnimalRepository;
import utils.KeyboardIO;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 9:32:39 PM
 */
public class ZooServices {
    
    private final ImpAnimalRepository animalRepository;

    public ZooServices() {
        animalRepository = new ImpAnimalRepository();
        if (animalRepository.load() == 1) {
            System.out.println("Load data successfully!");
        } else {
            System.out.println("Load data fail!");
        }
    }
    
    private void inputAnimal(Animal animal) {
//        String name = "";
//        do {
//            name = KeyboardIO.getString("Enter name: ");
//        } while (name.length() < 5);
//        animal.setName(name);
        
        animal.setName(KeyboardIO.getString("Enter name: "));
        animal.setColor(KeyboardIO.getString("Enter color: "));
        animal.setCharacteristic(KeyboardIO.getString("Enter characteristic: "));
        animal.setMovingMethod(KeyboardIO.getString("Enter moving method: "));
        animal.setWeight(KeyboardIO.getDouble("Enter weight: ", "Input must be a number!"));
        animal.setFood(KeyboardIO.getString("Enter food: "));
        animal.setMakingSoundMethod(KeyboardIO.getString("Enter making sound method: "));
    }
    
    public int load() {
        return animalRepository.load();
    }
    
    public int create(int animalType) {
        // input ID
        String id = KeyboardIO.getNoneEmptyString("Enter ID: ", "The ID cannpt be empty!");
        Animal newAnimal = new Animal(id);
        
        //Check ID and put animal into repository
        if (!animalRepository.contains(newAnimal)) {
            // Input other properties
            inputAnimal(newAnimal);
            
            int success = 0;
            switch (animalType) {
                case 1:
                    success = animalRepository.create(new LeglessAnimal(newAnimal));
                    break;
                case 2:
                    success = animalRepository.create(new BipedalFlightlessAnimal(newAnimal));
                    break;
                case 3:
                    success = animalRepository.create(new BipedalFlyingAnimal(newAnimal));
                    break;
                case 4:
                    success = animalRepository.create(new FourLegsAnimal(newAnimal));
                    break;
            }
            return success;
        } else {
            return -1;
        }
    }
    
    public Animal update() {
        // input ID
        String id = KeyboardIO.getNoneEmptyString("Enter ID: ", "The ID cannpt be empty!");
        Animal updatedAnimal = new Animal(id);
        
        // find pos (check ID)
        int pos = animalRepository.indexOf(updatedAnimal);
        
        // update the pos in repository
        if (pos >= 0) {
            inputAnimal(updatedAnimal);
            animalRepository.update(pos, updatedAnimal);
            return animalRepository.get(pos);
        } else {
            return null;
        }
    }
    
    public int delete() {
        String id = KeyboardIO.getNoneEmptyString("Enter ID: ", "The ID cannpt be empty!");
        
        if (KeyboardIO.confirm("Are you sure to delete this animal?", "Try again!")) {
            return animalRepository.delete(id);
        } else {
            return -1;
        }
    }
    
    public ArrayList<Animal> searchByName() {
        String name = KeyboardIO.getNoneEmptyString("Enter name: ", "The name cannot be empty!");
        
        ArrayList<Animal> result = new ArrayList<>();
        for (Animal animal: animalRepository) {
            if (animal.getName().contains(name)) {
                result.add(animal);
            }
        }
        return result;
    }
    
    public ArrayList<Animal> searchByWeight() {
        double lowerBound, upperBound;
        do {
            lowerBound = KeyboardIO.getDouble("Enter lower bound of weight: ", "Weight must be a number!");
            upperBound = KeyboardIO.getDouble("Enter lower bound of weight: ", "Weight must be a number!");
            if (lowerBound > upperBound) {
                System.out.println("Lower bound must be smaller than upper bound!");
            }
        } while (lowerBound > upperBound);
        
        ArrayList<Animal> result = new ArrayList<>();
        for (Animal animal: animalRepository) {
            double weight = animal.getWeight();
            if (lowerBound <= weight && weight <= upperBound) {
                result.add(animal);
            }
        }
        return result;
    }
    
    public ArrayList<Animal> showByType(int animalType) {
        ArrayList<Animal> result = new ArrayList<>();
        for (Animal animal: animalRepository) {
            if (animal.getType() == animalType) {
                result.add(animal);
            }
        }
        return result;
    }
    
    public ArrayList<Animal> showAll() {
        return animalRepository.read();
    }
    
    public int store() {
        return animalRepository.store();
    }
}
