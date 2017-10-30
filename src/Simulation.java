import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {

    private int numbersOfRocketsToSend = 0;

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

    private ArrayList<U1> loadU1(String nameOfFile) {
        ArrayList<Item> itemsArrayList = loadItems(nameOfFile);
        ArrayList<U1> U1ArrayList = new ArrayList<>();
        U1 u1 = new U1();
        for (Item item : itemsArrayList) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                U1ArrayList.add(u1);
                u1 = new U1();
            }
        }
        return U1ArrayList;
    }

    private ArrayList<U2> loadU2(String nameOfFile) {
        ArrayList<Item> itemsArrayList = loadItems(nameOfFile);
        ArrayList<U2> U2ArrayList = new ArrayList<>();
        U2 u2 = new U2();
        for (Item item : itemsArrayList) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                U2ArrayList.add(u2);
                u2 = new U2();
            }
        }
        return U2ArrayList;
    }

    private int runSimulation(ArrayList<Rocket> rocketArrayList) {
        int totalCost = 0;
        for (Rocket rocket : rocketArrayList) {
            if (!rocket.launch()) {
                rocket.launch();
                numbersOfRocketsToSend++;
                System.out.println("*Rocket is sent again, because of explosion*");
            }

            if (!rocket.land()) {
                rocket.land();
                numbersOfRocketsToSend++;
                System.out.println("*Rocket is sent again, because of crashing*");
            }
            totalCost = numbersOfRocketsToSend * rocket.getRocketCost();
        }
        System.out.println("We need " + numbersOfRocketsToSend + " rocket(s).");
        return totalCost;

    }

}
