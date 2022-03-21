package LeeCode;

public class Soletion1344 {
    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes*6;
        double hourAngle = (hour%12)*30+minutes*0.5;
        double Angle = Math.abs(hourAngle-minutesAngle);
        return Math.min(Angle,360-Angle);
    }
}
