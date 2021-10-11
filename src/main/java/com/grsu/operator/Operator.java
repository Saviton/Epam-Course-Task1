package com.grsu.operator;

import com.grsu.tariff.entity.Tariff;

import java.util.TreeSet;

public interface Operator {

    public TreeSet<Tariff> getTariffs();

    public void addAllTariffs(TreeSet<Tariff> tariffs);

    public void addAllTariffs(Tariff[] tariffs);

    public void addTariffs(Tariff tariff);

    public long getTotalNumberOfClients();

    public TreeSet<Tariff> findByFreeGbInternet(Double lowerValue, Double topValue);

    public TreeSet<Tariff> findByfreeMinutes(Double lowerValue, Double topValue);

    public TreeSet<Tariff> findByfreePopularServices(boolean freePopularServices);

    public TreeSet<Tariff> findBySubscription(Double lowerValue, Double topValue);

    public TreeSet<Tariff> findByAllParameters(Double lowerGbInternet, Double topGbInternet,
                                               Double lowerFreeMinutes,Double topFreeMinutes,
                                               boolean freePopularServices,
                                               Double lowerSubscription,Double topSubscription);

    public void printTariffs();
}
