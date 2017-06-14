package kr.ac.jejunu.distance;

import kr.ac.jejunu.model.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by super on 2017-06-14.
 */
public class GpsDistanceCalculatorTest {
    private GpsDistanceCalculator gpsDistanceCalculator;

    @Before
    public void init() throws Exception{
        gpsDistanceCalculator = new GpsDistanceCalculator();
    }

    @Test
    public void distanceTest() throws Exception{
        Position position1 = new Position(38.898556, -77.037852);
        Position position2 = new Position(38.897147, -77.043934);
        int distance = 549;
        int result = (int)gpsDistanceCalculator.calculateDistance(position1, position2);
        assertEquals(distance, result);
    }
}
