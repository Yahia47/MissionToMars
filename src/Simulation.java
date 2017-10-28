import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {

    private ArrayList<Item> loadItems(String nameOfFile) {
        ArrayList<Item> items = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(nameOfFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null) {
                String line = bufferedReader.readLine();
                String[] parts = line.split("(=)");
                Item item = new Item(parts[0], Integer.parseInt(parts[1]));
                items.add(item);
            }


        } catch (FileNotFoundException fnfe) {
            System.err.println("File was not found, " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("IO error has occurred " + ioe.getMessage());
        }

        return items;
    }

}
