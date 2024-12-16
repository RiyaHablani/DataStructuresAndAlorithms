class Solution {
    public double angleClock(int hour, int minutes) {
         // Normalize hour to a 12-hour format
        hour = hour % 12;

        // Calculate the position of the hour hand in degrees
        // Each hour represents 30 degrees (360 / 12), and each minute shifts the hour hand by 0.5 degrees (30 / 60)
        double hourAngle = (hour * 30) + (minutes * 0.5);

        // Calculate the position of the minute hand in degrees
        // Each minute represents 6 degrees (360 / 60)
        double minuteAngle = minutes * 6;

        // Calculate the absolute difference between the two angles
        double angle = Math.abs(hourAngle - minuteAngle);

        // The smaller angle is the minimum of the calculated angle and its complement (360 - angle)
        return Math.min(angle, 360 - angle);
    }
}