package com.grsu.operator;

import com.grsu.operator.entity.MTC;
import com.grsu.tariff.entity.Tariff;
import com.sun.source.util.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.mockito.Mockito.mock;

public class MTCTest {

    private static MTC MTC = new MTC();

    @BeforeAll
    public static void init() {
        MTC.addAllTariffs(
                new Tariff("Безлимитище+", Double.POSITIVE_INFINITY, 400.0, true, 25.48, 2900),
                new Tariff("Супер max 50", 50.0, Double.POSITIVE_INFINITY, true, 36.40, 1200),
                new Tariff("Супер 10", 10.0, 400.0, true, 21.30, 700),
                new Tariff("Супер Голос", 5.0, Double.POSITIVE_INFINITY, true, 24.90, 1000),
                new Tariff("Супер 25", 25.0, Double.POSITIVE_INFINITY, true, 30.60, 1500),
                new Tariff("Супер", 1.0, 200.0, true, 10.81, 1500));
    }

    @Test
    public void testGetTotalNumberOfClients() {

        //GIVEN
        long answer = 8800;

        //WHEN
        long predicted = MTC.getTotalNumberOfClients();

        //THEN
        Assertions.assertEquals(answer, predicted);

    }

    @Test
    void testFindByAllParameters() {
        TreeSet<Tariff> answer = new TreeSet<>();

        TreeSet<Tariff> actual = MTC.findByAllParameters(1.0, 10.0,
                100.0, 200.0, true, 10.0, 25.0);

        answer.add(new Tariff("Супер", 1.0, 200.0, true, 10.81, 1500));

        Assertions.assertEquals(answer, actual);
    }

}
