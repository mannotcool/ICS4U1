package vehicles;

/**
 * This class is the base for a Helicopter object, which is a type of Vehicle.
 * 
 * @author Nick Stoyanov
 * @version Oct 26, 2025
 */
public class Helicopter extends Vehicle {
    private int liftPower = 0;
    private int rotorEfficiency = 0;
    private int altitude = 0;

    /**
     * Constructor for a Helicopter object.
     * @param speed Current speed of the helicopter
     * @param maxCapableSpeed maximum capable speed of the helicopter
     * @param acceleration acceleration of the helicopter
     * @param weight weight of the helicopter
     * @param liftPower lift power of the helicopter
     * @param rotorEfficiency rotor efficiency of the helicopter
     * @param altitude altitude of the helicopter
     * @param racePositionPercentage percentage of race completed
     */
    public Helicopter(double speed, double maxCapableSpeed, int acceleration, int weight, int liftPower, int rotorEfficiency, int altitude, int racePositionPercentage) {
        super(speed, maxCapableSpeed, acceleration, weight, racePositionPercentage);
        setLiftPower(liftPower);
        setRotorEfficiency(rotorEfficiency);
        setAltitude(altitude);
    }

    /**
     * No argument constructor
     */
    public Helicopter(){
        super(0, 0, 0, 0, 0);
        this.liftPower = 0;
        this.rotorEfficiency = 0;
        this.altitude = 0;
    }

    /**
     * Accessor method to access the lift power of the helicopter.
     * @return helicopter lift power
     */
    public int getLiftPower() {
        return liftPower;
    }

    /**
     * Accessor method to access the rotor efficiency of the helicopter.
     * @return helicopter rotor efficiency
     */
    public int getRotorEfficiency() {
        return rotorEfficiency;
    }

    /**
     * Accessor method to get the altitude of the helicopter.
     * @return helicopter altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * Mutator method to set the lift power of the helicopter. To ensure it's reasonable, it only accepts values between 
     * 100 to 800.
     * 
     * @param newLiftPower new lift power to be set
     */
    public void setLiftPower(int newLiftPower) {
        if (newLiftPower < 100) {
            System.err.println("Lift power must be at least 100. Defaulting to 100...");
            liftPower = 100;
        } else if (newLiftPower > 800) {
            System.err.println("Lift power must be at most 800. Defaulting to 800...");
            liftPower = 800;
        } else {
            liftPower = newLiftPower;
        }
    }

    /**
     * Mutator method to set the rotor efficiency of the helicopter. To ensure it's reasonable, it only accepts values between 
     * 1 to 10.
     * 
     * @param newRotorEfficiency new rotor efficiency to be set
     */
    public void setRotorEfficiency(int newRotorEfficiency) {
        if (newRotorEfficiency < 1) {
            System.err.println("Rotor efficiency must be at least 1. Defaulting to 1...");
            rotorEfficiency = 1;
        } else if (newRotorEfficiency > 10) {
            System.err.println("Rotor efficiency must be at most 10. Defaulting to 10...");
            rotorEfficiency = 10;
        } else {
            rotorEfficiency = newRotorEfficiency;
        }
    }

    /**
     * Mutator method to set the altitude of the helicopter. 
     * To ensure it's reasonable, it only accepts values between 0 to 3000.
     * 
     * @param newAltitude new altitude to be set
     */
    public void setAltitude(int newAltitude) {
        if (newAltitude < 0) {
            System.err.println("Altitude must be at least 0. Defaulting to 0...");
            altitude = 0;
        } else if (newAltitude > 3000) {
            System.err.println("Altitude must be at most 3000. Defaulting to 3000...");
            altitude = 3000;
        } else {
            altitude = newAltitude;
        }
    }

    /**
     * Method to calculate a hypothetical speed of a helicopter while still considering the weight of itself.
     * This method considers other helicopter specific factors such as a vehicles lift power, and the rotor efficiency.
     * 
     * @param speed Vehicle Speed
     * @param weight Vehicle Weight
     * @param acceleration Vehicle Acceleration
     * @return accurate speed of helicopter
     */
    @Override
    public double calcSpeed(double speed, int weight, int acceleration) {
       // the 0.015 and 0.001 factors represent drag from air resistance and altitude respectively
       return speed + ((liftPower * (double) rotorEfficiency) / (double) weight) * acceleration - (speed * 0.015) - (altitude * 0.001);
    }
    
    /**
     * This method is ment to see if the helicopter can successfully cross on top of a mountain without hitting it. 
     * @param mountainHeight height of the mountain to cross
     * @return true if helicopter can clear the mountain, false otherwise
     */    
    public boolean canClearMountain(int mountainHeight) {
        if (altitude > mountainHeight) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for providing a general tailwind buff to the helicopter, increasing its rotor efficiency by a random amount between 1 and 3.
     * This buff will not allow the rotor efficiency to exceed 10.
     */
    public void tailwindBuff() {
        int buffAmount = (int)(Math.random() * 3) + 1; // Random number between 1 and 3
        int newRotorEfficiency = rotorEfficiency + buffAmount;

        // ensure rotor efficiency does not exceed 10
        if (newRotorEfficiency > 10) {
            newRotorEfficiency = 10;
        }

        setRotorEfficiency(newRotorEfficiency);
        System.out.println("Tailwind buff applied! Rotor efficiency is now: " + newRotorEfficiency);
    }

    /**
     * The weather debuff method simulates the effect of bad weather conditions on the helicopter's rotor efficiency.
     * It reduces the rotor efficiency by a random amount between 1 and whatever the original rotor efficiency was, ensuring that the rotor efficiency does not fall below 1.
     */
    @Override
    public void weatherDebuff() {
        int debuffAmount = (int)(Math.random() * rotorEfficiency) + 1; // Random number between 1 and original rotor efficiency
        int newRotorEfficiency = rotorEfficiency - debuffAmount;

        // ensure rotor efficiency does not fall below 1
        if (newRotorEfficiency < 1) {
            newRotorEfficiency = 1;
        }

        setRotorEfficiency(newRotorEfficiency);
        System.out.println("Due to bad weather, the helicopter's rotor efficiency is now: " + newRotorEfficiency);
    }

    /** 
     * Method to reduce or increase the altitude of the helicopter by a specified amount.
     * This is primarly used for simulating climbing or descending.
     * @param altitudeChange amount to change the altitude by (can be negative)
     */
    public void changeAltitude(int altitudeChange) {
        int newAltitude = altitude + altitudeChange;
        setAltitude(newAltitude);
        System.out.println("Helicopter altitude changed to: " + newAltitude);
    }

}
