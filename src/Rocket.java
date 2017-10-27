public class Rocket implements SpaceShip {

    private int currentWeight;
    private int cargoLimit; // In Kilograms

    public Rocket(int cargoLimit)
    {
        currentWeight = 0;
        this.cargoLimit = cargoLimit;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return ( this.currentWeight + item.getWeight() ) <= this.cargoLimit;
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();
    }
}
