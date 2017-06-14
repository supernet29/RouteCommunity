package kr.ac.jejunu.distance;

import kr.ac.jejunu.model.Position;
import org.springframework.stereotype.Component;

/**
 * Created by super on 2017-06-14.
 */
@Component
public class GpsDistanceCalculator {
    public double calculateDistance(Position a, Position b){
        double radiusOfEarthKm = 6371;
        double differnceOfLatitude = degreeToRadian(a.getLatitude() - b.getLatitude());
        double differenceOfLongitude = degreeToRadian(a.getLongitude() - b.getLongitude());
        double alpha = Math.sin(differnceOfLatitude/2) * Math.sin(differnceOfLatitude/2) +
                Math.cos(degreeToRadian(a.getLatitude())) * Math.cos(degreeToRadian(b.getLatitude()))*
                        Math.sin(differenceOfLongitude/2) * Math.sin(differenceOfLongitude/2);
        double cetha = 2 * Math.atan2(Math.sqrt(alpha), Math.sqrt(1-alpha));
        double distanceWithMeter = radiusOfEarthKm * cetha * 1000;
        return distanceWithMeter;
    }

    private double degreeToRadian(double degree){
        return degree * (Math.PI / 180);
    }
}
