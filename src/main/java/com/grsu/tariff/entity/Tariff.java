package com.grsu.tariff.entity;

import java.util.Comparator;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tariff implements com.grsu.tariff.Tariff, Comparable<Tariff> {
    private String name;
    private Double freeGbInternet;
    private Double freeMinutes;
    private boolean freePopularServices;
    private double subscription;
    private long numberOfClients;

    private static final Logger LOGGER = LoggerFactory.getLogger(Tariff.class);

    public Tariff(String name, Double freeGbInternet, Double freeMinutes, boolean freePopularServices, double subscription, long numberOfClients) {
        this.name = name;
        this.freeGbInternet = freeGbInternet;
        this.freeMinutes = freeMinutes;
        this.freePopularServices = freePopularServices;
        if (freeGbInternet.equals(Double.POSITIVE_INFINITY))
            this.freePopularServices = true;
        this.subscription = subscription;
        this.numberOfClients = numberOfClients;
        LOGGER.debug("TARIFF: Tariff with parameters " + this.toString() + " was created");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getFreeGbInternet() {
        return freeGbInternet;
    }

    @Override
    public void setFreeGbInternet(Double freeGbInternet) {
        this.freeGbInternet = freeGbInternet;
    }

    @Override
    public Double getFreeMinutes() {
        return freeMinutes;
    }

    @Override
    public void setFreeMinutes(Double freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    @Override
    public boolean isFreePopularServices() {
        return freePopularServices;
    }

    @Override
    public void setFreePopularServices(boolean freePopularServices) {
        this.freePopularServices = freePopularServices;
    }

    @Override
    public double getSubscription() {
        return subscription;
    }

    @Override
    public void setSubscription(double subscription) {
        this.subscription = subscription;
    }

    @Override
    public long getNumberOfClients() {
        return numberOfClients;
    }

    @Override
    public void setNumberOfClients(long numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tariff)) return false;
        Tariff tariff = (Tariff) o;
        return isFreePopularServices() == tariff.isFreePopularServices() &&
                Double.compare(tariff.getSubscription(), getSubscription()) == 0 &&
                getNumberOfClients() == tariff.getNumberOfClients() &&
                getName().equals(tariff.getName()) &&
                getFreeGbInternet().equals(tariff.getFreeGbInternet()) &&
                getFreeMinutes().equals(tariff.getFreeMinutes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFreeGbInternet(), getFreeMinutes(), isFreePopularServices(), getSubscription(), getNumberOfClients());
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", freeGbInternet=" + freeGbInternet +
                ", freeMinutes=" + freeMinutes +
                ", freePopularServices=" + freePopularServices +
                ", subscription=" + subscription +
                ", numberOfClients=" + numberOfClients +
                '}';
    }


    @Override
    public int compareTo(Tariff o) {
        return Comparator.comparing(Tariff::getSubscription).thenComparing(Tariff::getNumberOfClients).compare(this, o);
//        return Long.compare(this.numberOfClients, o.numberOfClients);
    }
}
