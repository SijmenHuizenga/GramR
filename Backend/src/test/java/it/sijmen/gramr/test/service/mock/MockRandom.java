package it.sijmen.gramr.test.service.mock;

import java.util.Random;

/**
 * Created by Sinius on 6-4-2016.
 */
public class MockRandom extends Random {

    public static int returnsAlways = 0;

    @Override
    public int nextInt(int bound) {
        return returnsAlways;
    }
}
