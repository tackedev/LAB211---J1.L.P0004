package repositories.inter;

import entities.Animal;
import java.util.ArrayList;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 2:43:19 PM
 */
public interface IAnimalRepository {
    
    /* CRUD */
    public int create(Animal animal);

    public ArrayList<Animal> read();

    public Animal detail(String id);

    public int update(int pos, Animal animal);

    public int delete(String id);
}
