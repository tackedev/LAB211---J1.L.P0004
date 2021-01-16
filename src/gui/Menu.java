package gui;

import java.util.ArrayList;
import utils.KeyboardIO;

/**
 *
 * @author tackedev
 */
public class Menu {
    private final String title;
    private final ArrayList<String> options = new ArrayList<>();
    private final boolean othersOption;

    public Menu(String title, boolean othersOption) {
        this.title = title;
        this.othersOption = othersOption;
    }
    
    public void addOption(String option) {
        options.add(option);
    }
    
    public void print() {
        System.out.println("--------- " + title + " ---------");
        options.forEach(option -> {
            System.out.println(option);
        });
    }
    
    public int getChoice() {
        if (othersOption) {
            int size = options.size() - 1;
            return KeyboardIO.getInteger("Enter your choice [1-" + size + "]: ", "Input is not accepted");
        } else {
            int size = options.size();
            return KeyboardIO.getInteger("Enter your choice [1-" + size + "]: ", "Input is not accepted", 1, size);
        }
    }
    
}