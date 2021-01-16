package dao.inter;

import entities.Animal;
import java.util.ArrayList;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:46:38 AM
 */
public interface IAnimalDao {
    
    public ArrayList<Animal> read();
    
    public int write(ArrayList<Animal> list);
}
