public class Rocket implements SpaceShip {

    private int currentWeight;
    private int cargoLimit; // In Kilograms
    private int rocketCost = 0;

    public Rocket(int cargoLimit, int rocketCost)
    {
        currentWeight = 0;
        this.cargoLimit = cargoLimit;
        this.rocketCost = rocketCost;
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

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getRocketCost() {
        return rocketCost;
    }
}
