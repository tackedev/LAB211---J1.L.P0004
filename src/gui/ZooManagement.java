package gui;

import entities.Animal;
import java.util.ArrayList;
import services.ZooServices;
import utils.KeyboardIO;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 9:52:56 PM
 */
public class ZooManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final Menu mainMenu = new Menu("Zoo Management", true);
        mainMenu.addOption("1. Add new animal");
        mainMenu.addOption("2. Update animal");
        mainMenu.addOption("3. Delete animal");
        mainMenu.addOption("4. Search animal");
        mainMenu.addOption("5. Show animal list");
        mainMenu.addOption("6. Store data to file");
        mainMenu.addOption("Others- Quit");
        
        final Menu animalTypeMenu = new Menu("Choose type of animal", false);
        animalTypeMenu.addOption("1. 0-legged animals");
        animalTypeMenu.addOption("2. Bipedal and flightless animal");
        animalTypeMenu.addOption("3. Bipedal and flying animal");
        animalTypeMenu.addOption("4. 4-legged animal");
        
        final Menu searchingMenu = new Menu("Choose field to search by", false);
        searchingMenu.addOption("1. Search by name");
        searchingMenu.addOption("2. Search by weight");
        
        final Menu showingMenu = new Menu("Choose what to show", false);
        showingMenu.addOption("1. Show by type");
        showingMenu.addOption("2. Show all");
        
        final ZooServices zooServices = new ZooServices();
        
        boolean isContinue = true;
        do {            
            mainMenu.print();
            int choice = mainMenu.getChoice();
            switch (choice) {
                case 1: {
                    do {
                        animalTypeMenu.print();
                        int animalType = animalTypeMenu.getChoice();
                        int createStatus = zooServices.create(animalType);
                        switch (createStatus) {
                            case 1:
                                System.out.println("Add new animal successfully!");
                                break;
                            case 0:
                                System.out.println("Add new animal fail!");
                                break;
                            case -1:
                                System.out.println("The Id is existed!");
                                break;
                        }
                    } while (KeyboardIO.confirm("Do you want to continue add new animal?", "Try again!"));
                    break;
                }
                case 2: {
                    Animal updatedAnimal = zooServices.update();
                    if (updatedAnimal != null) {
                        System.out.println("Animal information after updated:");
                        System.out.println(updatedAnimal.display());
                    } else {
                        System.out.println("Animals does not exist!");
                    }
                    break;
                }
                case 3: {
                    int deleteStatus = zooServices.delete();
                    switch (deleteStatus) {
                        case 1:
                            System.out.println("Delete animal successfully!");
                            break;
                        case 0:
                            System.out.println("Delete animal fail!");
                            break;
                        case -1:
                            System.out.println("Delete animal stop!");
                            break;
                    }
                    break;
                }
                case 4: {
                    searchingMenu.print();
                    int subChoice = searchingMenu.getChoice();
                    ArrayList<Animal> result = null;
                    
                    switch (subChoice) {
                        case 1: 
                            result = zooServices.searchByName();
                            break;
                        case 2: 
                            result = zooServices.searchByWeight();
                            break;
                    }
                    
                    if (result != null) {
                        if (result.isEmpty()) {
                            System.out.println("There is no animal");
                        } else {
                            result.forEach(animal -> {
                                System.out.println(animal.display());
                            });
                        }
                    }
                    break;
                }
                case 5: {
                    showingMenu.print();
                    int subChoice = showingMenu.getChoice();
                    ArrayList<Animal> result = null;
                    switch (subChoice) {
                        case 1: {
                            animalTypeMenu.print();
                            int animalType = animalTypeMenu.getChoice();
                            result = zooServices.showByType(animalType);
                            break;
                        }
                        case 2: {
                            result = zooServices.showAll();
                            break;
                        }
                    }
                    if (result != null) {
                        if (result.isEmpty()) {
                            System.out.println("There is no animal!");
                        } else {
                            result.forEach(animal -> {
                                System.out.println(animal.display());
                            });
                        }
                    }
                    break;
                }
                case 6:
                    if (zooServices.store() == 1) {
                        System.out.println("Store data successfully!");
                    } else {
                        System.out.println("Store data fail!");
                    }
                    break;
                default:
                    isContinue = false;
            }
        } while (isContinue);

    }
}
