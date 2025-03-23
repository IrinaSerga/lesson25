package com.dmdev.HT_MultiThread;


public class Rocket {
    private final EnumCrystalColor color;
    private final CrystalPlanet planet;


    public Rocket(EnumCrystalColor color, CrystalPlanet planet) {
        this.color = color;
        this.planet = planet;
    }

    /**
     * здесь обрабатываем что может улететь ни с чем
     */
    public int grabCrystals() {
        int collected = planet.collectCrystals(color);

        if (collected > 0) {
            System.out.println("Rocket with " + color + " collected " + collected + " crystals");
        } else {
            System.out.println("Rocket with " + color + " collected zero crystals");
        }
        return collected;
    }


}
