import java.util.Random;

public class U2 extends Rocket {
    // I'm sure there is a better way to do it, but I can't figure it out.
    private int U2CargoLimit = 29000;
    //private int RocketCost = 120000000;
    private double chanceOfLaunchExplosion = 0.04 * (super.getCurrentWeight() / U2CargoLimit);
    private double chanceOfLandingCrash = 0.08 * (super.getCurrentWeight() / U2CargoLimit);
    //private double chance = new Random().nextDouble();

    public U2() {
        // I'm sure there is a better way to do it, but I can't figure it out.
        super(29000, 120000000);
    }

    @Override
    public boolean launch() {
        double chance = new Random().nextDouble();
        if (chanceOfLaunchExplosion >= chance) {
            System.out.println("U2 exploded!");
            return false;
        } else {
            System.out.println("U2 launched successfully");
            return true;
        }
    }

    @Override
    public boolean land() {
        double chance = new Random().nextDouble();
        if (chanceOfLandingCrash >= chance) {
            System.out.println("U2 crashed!");
            return false;
        } else {
            System.out.println("U2 landed successfully");
            return true;
        }
    }

//    public int getRocketCost() {
//        return RocketCost;
//    }
}

