package com.dmdev.HT_MultiThread;

public class GameRunner {
    public static void main(String[] args) {
        CrystalPlanet planet = new CrystalPlanet();

        Thread fireWizard = new Thread(new Wizard("Маги огня", planet, EnumCrystalColor.RED));
        Thread airWizard = new Thread(new Wizard("Маги воздуха", planet, EnumCrystalColor.WHITE));


        // бесконечній цикл
        Thread crystalGenerator = new Thread(() -> {
            while (true) {
                planet.generateCrystals();
                try {
                    Thread.sleep(1000);  //имитация генерации раз в сутки 86400 секунд
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        // стратуем потоки
        crystalGenerator.start();
        fireWizard.start();
        airWizard.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Посылаем сигналы остановки
        crystalGenerator.interrupt();
        fireWizard.interrupt();
        airWizard.interrupt();


        try {
            // Ожидание завершения всех потоков
            crystalGenerator.join();
            fireWizard.join();
            airWizard.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Game is end");
    }
}


