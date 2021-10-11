package com.grsu.operator.entity;

import com.grsu.operator.Operator;
import com.grsu.tariff.entity.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeSet;

public class MTC implements Operator {
    TreeSet<Tariff> tariffs = new TreeSet<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(MTC.class);

    @Override
    public TreeSet<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void addTariffs(Tariff tariff) {
        int predictedSize = this.tariffs.size() + 1;

        this.tariffs.add(tariff);

        if (predictedSize - this.tariffs.size() != 0)
            LOGGER.warn("OPERATOR: {} tariffs were not added", tariff);
        else
            LOGGER.info("TARIFF: Tariff with parameters " + tariff.toString() + " had been added");
    }

    @Override
    public void addAllTariffs(TreeSet<Tariff> tariffs) {
        for (Tariff tariff : tariffs)
            this.addTariffs(tariff);
    }

    @Override
    public void addAllTariffs(Tariff... tariffs) {
        for (Tariff tariff : tariffs)
            this.addTariffs(tariff);
    }


    @Override
    public long getTotalNumberOfClients() {
        long totalNumberOfClients = 0;

        for (Tariff tariff : tariffs)
            totalNumberOfClients += tariff.getNumberOfClients();

        return totalNumberOfClients;
    }

    @Override
    public TreeSet<Tariff> findByFreeGbInternet(Double lowerValue, Double topValue) {
        TreeSet<Tariff> findedTariffs = new TreeSet<>();

        for (Tariff tariff : tariffs) {
            if (tariff.getFreeGbInternet() >= lowerValue && tariff.getFreeGbInternet() <= topValue)
                findedTariffs.add(tariff);
        }

        return findedTariffs;
    }

    @Override
    public TreeSet<Tariff> findByfreeMinutes(Double lowerValue, Double topValue) {
        TreeSet<Tariff> findedTariffs = new TreeSet<>();

        for (Tariff tariff : tariffs) {
            if (tariff.getFreeMinutes() >= lowerValue && tariff.getFreeMinutes() <= topValue)
                findedTariffs.add(tariff);
        }

        return findedTariffs;
    }

    @Override
    public TreeSet<Tariff> findByfreePopularServices(boolean freePopularServices) {
        TreeSet<Tariff> findedTariffs = new TreeSet<>();

        for (Tariff tariff : tariffs)
            if (tariff.isFreePopularServices())
                findedTariffs.add(tariff);


        return findedTariffs;
    }

    @Override
    public TreeSet<Tariff> findBySubscription(Double lowerValue, Double topValue) {
        TreeSet<Tariff> findedTariffs = new TreeSet<>();

        for (Tariff tariff : tariffs) {
            if (tariff.getSubscription() >= lowerValue && tariff.getSubscription() <= topValue)
                findedTariffs.add(tariff);
        }

        return findedTariffs;
    }

    @Override
    public TreeSet<Tariff> findByAllParameters(Double lowerGbInternet, Double topGbInternet,
                                               Double lowerFreeMinutes, Double topFreeMinutes,
                                               boolean freePopularServices,
                                               Double lowerSubscription, Double topSubscription) {

        TreeSet<Tariff> findedTariffs = new TreeSet<>();

        for (Tariff tariff : tariffs) {
            if ((tariff.getFreeGbInternet() >= lowerGbInternet && tariff.getFreeGbInternet() <= topGbInternet) &&
                    (tariff.getFreeMinutes() >= lowerFreeMinutes && tariff.getFreeMinutes() <= topFreeMinutes) &&
                    tariff.isFreePopularServices() == freePopularServices &&
                    (tariff.getSubscription() >= lowerSubscription && tariff.getSubscription() <= topSubscription)
            )
                findedTariffs.add(tariff);
        }

        return findedTariffs;
    }

    @Override
    public void printTariffs() {
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }
}
