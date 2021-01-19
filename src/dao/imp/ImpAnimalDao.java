package dao.imp;

import dao.inter.IAnimalDao;
import entities.Animal;
import entities.BipedalFlightlessAnimal;
import entities.BipedalFlyingAnimal;
import entities.FourLegsAnimal;
import entities.LeglessAnimal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import config.Configuration;
import java.util.StringTokenizer;

/**
 *
 * @author tackedev
 * @since Jan 12, 2021 11:48:52 AM
 */
public class ImpAnimalDao implements IAnimalDao {
 
    @Override
    public ArrayList<Animal> read() {
        try {
            File f = new File(Configuration.FIN);
            if (!f.exists()) {
                return  null;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            Animal animal = null;
            ArrayList<Animal> result = new ArrayList<>();
            
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                String[] prop = line.split(";");
                switch (prop[0]) {
                    case "1":
                        animal = new LeglessAnimal(Integer.parseInt(prop[0]), prop[1], prop[2], Integer.parseInt(prop[3]), prop[4], prop[5], prop[6], Double.parseDouble(prop[7]), prop[8], prop[9]);
                        break;
                    case "2":
                        animal = new BipedalFlightlessAnimal(Integer.parseInt(prop[0]), prop[1], prop[2], Integer.parseInt(prop[3]), prop[4], prop[5], prop[6], Double.parseDouble(prop[7]), prop[8], prop[9], Integer.parseInt(prop[10]), Boolean.parseBoolean(prop[11]));
                        break;
                    case "3":
                        animal = new BipedalFlyingAnimal(Integer.parseInt(prop[0]), prop[1], prop[2], Integer.parseInt(prop[3]), prop[4], prop[5], prop[6], Double.parseDouble(prop[7]), prop[8], prop[9], Integer.parseInt(prop[10]), Boolean.parseBoolean(prop[11]));
                        break;
                    case "4":
                        animal = new FourLegsAnimal(Integer.parseInt(prop[0]), prop[1], prop[2], Integer.parseInt(prop[3]), prop[4], prop[5], prop[6], Double.parseDouble(prop[7]), prop[8], prop[9]);
                        break;
                }
                result.add(animal);
            }
            
            br.close(); fr.close();
            
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public int write(ArrayList<Animal> list) {
        try {
            File f = new File(Configuration.FOUT);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            
            list.forEach(obj -> {
                pw.println(obj+"; ");
            });
            pw.close(); fw.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }
}
