package com.dmdev.HT_MultiThread;

public class Wizard  implements Runnable {
    private final String nameWizard;
    private final CrystalPlanet crystalPlanet;
    private final EnumCrystalColor color;
    private final Rocket rocket;
    private final int maxCount = 25;
    private int collectedCrystals  = 0;



    public Wizard(String name, CrystalPlanet crystalPlanet, EnumCrystalColor color) {
        this.nameWizard = name;
        this.crystalPlanet = crystalPlanet;
        this.color = color;
        this.rocket = new Rocket(color, crystalPlanet);
    }

    @Override
    public void run() {
        while (collectedCrystals  < maxCount) {
            int collected = rocket.grabCrystals();
            collectedCrystals += collected;

            System.out.println("Collected " + collected + " crystals" + " .Total: " + collectedCrystals);

            if (collectedCrystals >= maxCount) {
                System.out.println("Max count reached");
                break;
            }
            try {
                Thread.sleep(1000); //
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }


    }


}
