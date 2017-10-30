import java.util.Random;

public class U1 extends Rocket {

    // I'm sure there is a better way to do it, but I can't figure it out.
    private int U1CargoLimit = 18000;
    //private int RocketCost = 100000000;
    private double chanceOfLaunchExplosion = 0.05 * (super.getCurrentWeight() / U1CargoLimit);
    private double chanceOfLandingCrash = 0.01 * (super.getCurrentWeight() / U1CargoLimit);
    //private double chance = new Random().nextDouble();

    public U1() {
        // I'm sure there is a better way to do it, but I can't figure it out.
        super(18000, 100000000);
    }

    @Override
    public boolean launch() {
        double chance = new Random().nextDouble();
        if (chanceOfLaunchExplosion >= chance) {
            System.out.println("U1 exploded!");
            return false;
        } else {
            System.out.println("U1 launched successfully");
            return true;
        }
    }

    @Override
    public boolean land() {
        double chance = new Random().nextDouble();
        if (chanceOfLandingCrash >= chance) {
            System.out.println("U1 crashed!");
            return false;
        } else {
            System.out.println("U1 landed successfully");
            return true;
        }
    }

//    public int getRocketCost() {
//        return RocketCost;
//    }
}