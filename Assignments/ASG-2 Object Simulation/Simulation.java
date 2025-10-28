import vehicles.Car;
import vehicles.Helicopter;
import vehicles.Vehicle;

public class Simulation {
    public static void main(String[] args) {
        System.out.println("Welcome to the super super accurate Car VS Helicopter Simulation!");
        // Create a Car object with random attributes
        Car primaryCar = new Car(
            Math.random() * 180 + 150,        // maxCapableSpeed: 150–330
            (int)(Math.random() * 11) + 10,   // acceleration: 10–20
            (int)(Math.random() * 700) + 900, // weight: 900–1600
            (int)(Math.random() * 221) + 180, // enginePower: 180–400
            (int)(Math.random() * 6) + 5,     // tireGrip: 5–10
            (int)(Math.random() * 11) + 5     // turnRate: 5–15
        );
    
        // Create a Helicopter object with random attributes
        Helicopter primaryHelicopter = new Helicopter(
            Math.random() * 220 + 180,       // maxCapableSpeed: 180–400
            (int)(Math.random() * 11) + 10,  // acceleration: 10–20
            (int)(Math.random() * 3000) + 1200, // weight: 1200–4200
            (int)(Math.random() * 501) + 300,   // liftPower: 300–800
            (int)(Math.random() * 6) + 5,       // rotorEfficiency: 5–10
            (int)(Math.random() * 2400) + 400   // altitude: 400–2800
        );

        System.out.println("\nInitial Vehicle Stats:");
        System.out.println("Car - Max Speed: " + primaryCar.getMaxCapableSpeed() + " km/h, Acceleration: " + primaryCar.getAcceleration() + " km/h, Weight: " + primaryCar.getVehicleWeight() + " kg, Engine Power: " + primaryCar.getEnginePower() + ", Tire Grip: " + primaryCar.getTireGrip() + ", Turn Rate: " + primaryCar.getTurnRate());
        System.out.println("Helicopter - Max Speed: " + primaryHelicopter.getMaxCapableSpeed() + " km/h, Acceleration: " + primaryHelicopter.getAcceleration() + " km/h, Weight: " + primaryHelicopter.getVehicleWeight() + " kg, Lift Power: " + primaryHelicopter.getLiftPower() + ", Rotor Efficiency: " + primaryHelicopter.getRotorEfficiency() + ", Altitude: " + primaryHelicopter.getAltitude() + " m");

        // Simulate weather debuff (40% chance)
        System.out.println("\nChecking for bad weather...");
        if (Math.random() < 0.4) { // 40% chance
            System.out.println("Bad weather hit both vehicles. Applying debuffs...");
            primaryCar.weatherDebuff();
            primaryHelicopter.weatherDebuff();
        } else {
            System.out.println("Weather is clear.");
        }

        // Run
        System.out.println("\n-- Starting the race! --");
        runRace(primaryCar, primaryHelicopter);
        System.out.println("\nFinal Vehicle Stats After Race:");
        System.out.println("Car: " + primaryCar);
        System.out.println("Helicopter: " + primaryHelicopter);

    }

    
    /**
     * Method to change a vehicle object's race position depending on its speed.
     * @param vehicle Vehicle object whose
     */
    public static void updateRacePosition(Vehicle vehicle) {
        int positionIncrease = (int)(vehicle.getSpeed() / 10); // The faster the speed, the more the position increases
        int newPosition = vehicle.getRacePositionPercentage() + positionIncrease;
        if (newPosition > 100) {
            newPosition = 100; // Cap at 100%
            vehicle.setSpeed(0); // Stop the vehicle if it reaches the finish line
        }
        vehicle.setRacePositionPercentage(newPosition);
    }

    /**
     * Method to run a while loop simulating the race until one vehicle reaches 100% race position.
     * @param car Car object participating
     * @param helicopter Helicopter object participating
     */
    public static void runRace(Car car, Helicopter helicopter) {
        while (car.getRacePositionPercentage() < 100 && helicopter.getRacePositionPercentage() < 100) {
            // Update speeds based on their specific calculations
            double newCarSpeed = car.calcSpeed(car.getSpeed(), car.getVehicleWeight(), car.getAcceleration());
            double newHelicopterSpeed = helicopter.calcSpeed(helicopter.getSpeed(), helicopter.getVehicleWeight(), helicopter.getAcceleration());

            car.setSpeed(newCarSpeed);
            helicopter.setSpeed(newHelicopterSpeed);

            // random chance of an obstacle appearing
            if (Math.random() < 0.2) { // 20% chance
                placeObstacle(car, helicopter);
            }

            // random 5 percent chance of turbo boost for car
            if (Math.random() < 0.05) {
                car.turboBoost();
            }

            // random 5 percent chance of tailwind buff for helicopter
            if (Math.random() < 0.05) {
                helicopter.tailwindBuff();
            }

            // random chance for engine issues for car
            if (Math.random() < 0.03) { // 3% chance
                car.engineIssueDebuff();
            }

            // Update race positions
            updateRacePosition(car);
            updateRacePosition(helicopter);

            // Print car and helicopter status every 10% of the race
            if (car.getRacePositionPercentage() % 10 == 0 || helicopter.getRacePositionPercentage() % 10 == 0) {
                System.out.println("\n---");
                System.out.println("Car: " + car);
                System.out.println("Helicopter: " + helicopter);
                System.out.println("---");
            }
        }
    }

    /**
     * Method to randomly place an obstacle with a certain altitude and turn radius.
     * if the vehicle cannot overcome the obstacle, it slows down by 10%.
     * if the air vehicle cannot overcome the obstacle, it slows down by 10%.
     * @param car Car object participating
     * @param helicopter Helicopter object participating
    */
    public static void placeObstacle(Car car, Helicopter helicopter) {
        int obstacleTurnRadius = (int)(Math.random() * 20) + 5; // between 5 and 25
        int obstacleHeight = (int)(Math.random() * 2500) + 500; // between 500 and 3000

        System.out.println("\nAn obstacle has appeared with Turn Radius: " + obstacleTurnRadius + ", and Height: " + obstacleHeight);

        // Check if car can navigate the turn
        if (!car.attemptTurn(obstacleTurnRadius)) {
            // slow down by a random percentage between 5 and 15
            int randomSlowDown = (int)(Math.random() * 11) + 5; // between 5 and 15
            car.slowDownByPercentage(randomSlowDown);
            System.out.println("Car failed to navigate the turn, slowing it down by " + randomSlowDown + "%");
        } else {
            System.out.println("Car successfully navigated the turn.");
        }

        // Check if helicopter can clear the mountain
        if (!helicopter.canClearMountain(obstacleHeight)) {
            // slow down by a random percentage between 5 and 15
            int randomSlowDown = (int)(Math.random() * 11) + 5; // between 5 and 15
            helicopter.slowDownByPercentage(randomSlowDown);
            System.out.println("Helicopter failed to clear the mountain, slowing it down by " + randomSlowDown + "%");
            
            // if altitude is less than obstacle height, increase it while making sure its not above max altitude of 3000
            int newAltitude = helicopter.getAltitude() + 500;
            if (newAltitude > 3000) {
                newAltitude = 3000;
            }

            helicopter.setAltitude(newAltitude);
            System.out.println("Helicopter altitude increased to " + newAltitude + "m");
        } else {
            System.out.println("Helicopter successfully cleared the mountain.");
        }
    }
}
