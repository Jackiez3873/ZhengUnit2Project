import java.lang.Math;
public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public double slope() {
        return (y2 - y1) / (x2 - x1);
    }
    public String equation() {
        if (yIntercept() < 0 && slope() != 0) {
            return  "y = " + ((y2 - y1) + "/" + (x2 - x1)) + "x " + yIntercept();
        } else if (yIntercept() > 0 && slope() != 0) {
            return "y = " + ((y2 - y1) + "/" + (x2 - x1)) + "x +" + yIntercept();
        } else if (yIntercept() == 0 && slope() != 0) {
            return "y = " + ((y2 - y1) + "/" + (x2 - x1)) + "x";
        } else if (yIntercept() != 0 && slope() == 0) {
            return "y = " + yIntercept();
        }
        return " ";
    }
    public String coordinateForX(double x) {
        x = Math.round(x * 100) /100.0;
        double yCoordinate = roundedToHundredth(slope() * x + yIntercept());
        return "(" + x + " , " + yCoordinate + ")";
    }
    public String lineInfo() {
        return ("The two points are: (" + x1 + ", " + y1 + ")" + " and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is " + distance());
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}