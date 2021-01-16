package repositories.impl;

import dao.imp.ImpAnimalDao;
import dao.inter.IAnimalDao;
import entities.Animal;
import java.util.ArrayList;
import repositories.inter.IAnimalRepository;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 2:46:42 PM
 */
public class ImpAnimalRepository extends ArrayList<Animal> implements IAnimalRepository {
    
    private final IAnimalDao animalDao;

    public ImpAnimalRepository() {
        animalDao = new ImpAnimalDao();
    }
    
    @Override
    public int create(Animal animal) {
        try {
            this.add(animal);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public ArrayList<Animal> read() {
        return this;
    }

    @Override
    public Animal detail(String id) {
        for (Animal animal: this) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public int update(int pos, Animal animal) {
        if (pos < this.size()) {
            Animal oldAnimal = this.get(pos);
            
            if (!animal.getName().isEmpty()) {
                oldAnimal.setName(animal.getName());
            }
            if (!animal.getColor().isEmpty()) {
                oldAnimal.setColor(animal.getColor());
            }
            if (!animal.getCharacteristic().isEmpty()) {
                oldAnimal.setCharacteristic(animal.getCharacteristic());
            }
            if (!animal.getMovingMethod().isEmpty()) {
                oldAnimal.setMovingMethod(animal.getMovingMethod());
            }
            if (animal.getWeight() != 0) {
                oldAnimal.setWeight(animal.getWeight());
            }
            if (!animal.getFood().isEmpty()) {
                oldAnimal.setFood(animal.getFood());
            }
            if (!animal.getMakingSoundMethod().isEmpty()) {
                oldAnimal.setMakingSoundMethod(animal.getMakingSoundMethod());
            }
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int delete(String id) {
        Animal deleteAnimal = new Animal(id);
        int pos = this.indexOf(deleteAnimal);
        if (pos >= 0) {
            this.remove(pos);
            return 1;
        } else {
            return 0;
        }
    }

    public int load() {
        ArrayList<Animal> data = animalDao.read();
        if (data != null) {
            this.addAll(data);
            return 1;
        } else {
            return 0;
        }
    }
    
    public int store() {
        return animalDao.write(this);
    }
}
