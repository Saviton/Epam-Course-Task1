package com.grsu;

import com.grsu.operator.entity.MTC;
import com.grsu.tariff.entity.Tariff;

public class Main {
    public static void main(String[] args) {
        MTC MTC = new MTC();
        MTC.addAllTariffs(
                new Tariff("Безлимитище+", Double.POSITIVE_INFINITY, 400.0, true, 25.48, 2900),
                new Tariff("Супер max 50", 50.0, Double.POSITIVE_INFINITY, true, 36.40, 1200),
                new Tariff("Супер 10", 10.0, 400.0, true, 21.30, 700),
                new Tariff("Супер Голос", 5.0, Double.POSITIVE_INFINITY, true, 24.90, 1000),
                new Tariff("Супер 25", 25.0, Double.POSITIVE_INFINITY, true, 30.60, 1500),
                new Tariff("Супер", 1.0, 200.0, true, 10.81, 1500));

        MTC.printTariffs();

        System.out.println("\nFind by all parameters:");
        System.out.println(MTC.findByAllParameters(1.0, 10.0,
                100.0, 200.0, true, 10.0, 25.0));

        System.out.println("\nFind by freeGbInternet: ");
        System.out.println(MTC.findByFreeGbInternet(1.0, 10.0));

        System.out.println("\nFind by free popular services");
        System.out.println(MTC.findByfreePopularServices(true));

        System.out.println("\nFind by free minutes");
        System.out.println(MTC.findByfreeMinutes(100.0, 200.0));

        System.out.println("\nFind by subscription");
        System.out.println(MTC.findBySubscription(15.0, 22.0));

    }
}
