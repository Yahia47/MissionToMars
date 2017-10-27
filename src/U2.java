import java.util.Random;

public class U2 extends Rocket {
    // I'm sure there is a better way to do it, but I can't figure it out.
    private int U1CargoLimit = 29000;
    private double chanceOfLaunchExplosion = 0.04 * (super.getCurrentWeight() / U1CargoLimit);
    private double chanceOfLandingCrash = 0.08 * (super.getCurrentWeight() / U1CargoLimit);
    private double random = new Random().nextDouble();

    public U2() {
        // I'm sure there is a better way to do it, but I can't figure it out.
        super(29000);
    }

    @Override
    public boolean launch() {
        return chanceOfLaunchExplosion >= random;
    }

    @Override
    public boolean land() {
        return chanceOfLandingCrash >= random;
    }
}

