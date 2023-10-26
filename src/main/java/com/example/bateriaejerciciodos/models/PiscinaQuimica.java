package com.example.bateriaejerciciodos.models;

import com.example.bateriaejerciciodos.Exception.ExcepcionPersonalizada;
import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PiscinaQuimica {

    private final int CAPACIDAD_MAXIMA = 2000;
    @Getter @Setter
    private static int totalCapacity = 0;
    @Getter @Setter
    private static int actualCapacity = 0;
    @Getter @Setter
    private static int randomFill = 0;

    public static void simulateTotalCapacity(double capacity) {
        totalCapacity = (int) (capacity * 1000);
    }

    public static double fillPool() throws ExcepcionPersonalizada {
        randomFill = new SecureRandom().nextInt(0, 1000);
        if (actualCapacity + randomFill > totalCapacity) {
            throw new ExcepcionPersonalizada("\n[ERROR] La piscina supero su capacidad maxima, se fija la piscina en: " + actualCapacity);
        } else {
            actualCapacity += randomFill;
        }
        return (actualCapacity / 1000.0) / (totalCapacity / 1000.0);
    }

    public static double emptyPool() throws ExcepcionPersonalizada {
        randomFill = new SecureRandom().nextInt(0, 1000);
        if (actualCapacity - randomFill < 0) {
            throw new ExcepcionPersonalizada("\n[ERROR] La piscina supero su capacidad maxima, se fija la piscina en: " + actualCapacity);
        } else {
            actualCapacity -= randomFill;
        }
        return (actualCapacity / 1000.0) / (totalCapacity / 1000.0);
    }

}
