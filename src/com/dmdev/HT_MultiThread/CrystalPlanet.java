package com.dmdev.HT_MultiThread;

import java.util.Random;

public class CrystalPlanet {
    private volatile  int redCount = 0;
    private volatile  int whiteCount = 0;
    private final Random random = new Random();


    /**
     * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки
     * (может быть 1 красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).
     */

    public synchronized void generateCrystals() {
        int count = random.nextInt(4) + 2; // nextInt(n) генерирует случайное целое число в диапазоне от 0 до n-1, т е 0,1,2,3. Нужно сдвинуть на 2 и начинать с него, потому и +2
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                redCount++;
            } else {
                whiteCount++;
            }
        }
        System.out.println("Выросло всего кристаллов: " + count + " ("
                + EnumCrystalColor.RED + redCount + ", " + EnumCrystalColor.WHITE + whiteCount + ")");
    }


    // сбор кристаллов, synchronized потому что могут обращаться обе ракеты одновременно(я так предполагаю)
    public synchronized int collectCrystals(EnumCrystalColor color) {
        int collected = 0;
        if (color == EnumCrystalColor.RED) {
            if (redCount > 0) {
                int crystalsToCollect = random.nextInt(4) + 2; // Генерация случайного числа от 2 до 5
                collected = Math.min(crystalsToCollect, redCount); // Если crystalsToCollect меньше redCount, берем его, иначе берем redCount. Идеа заменяет на Math.min
                redCount -= collected;
            }
        } else if (color == EnumCrystalColor.WHITE) {
            if (whiteCount > 0) {
                collected = Math.min(random.nextInt(4) + 2, whiteCount);
                whiteCount -= collected;
            }
        }
        return collected;
    }
}
