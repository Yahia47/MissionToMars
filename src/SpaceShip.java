public interface SpaceShip {
    // Indicate if the launch was successful.
    boolean launch();

    // Indicate if the landing was successful.
    boolean land();

    // Returns true if the rocket can carry that item, returns false otherwise.
    boolean canCarry(Item item);

    // Update the current of the rocket.
    void carry(Item item);
}
