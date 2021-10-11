package com.grsu.tariff;

public interface Tariff {

    @Override
    public String toString();

    public String getName();

    public void setName(String name);

    public Double getFreeGbInternet();

    public void setFreeGbInternet(Double freeGbInternet);

    public Double getFreeMinutes();

    public void setFreeMinutes(Double freeMinutes);

    public boolean isFreePopularServices();

    public void setFreePopularServices(boolean freePopularServices);

    public double getSubscription();

    public void setSubscription(double subscription);

    public long getNumberOfClients();

    public void setNumberOfClients(long numberOfClients);

}
