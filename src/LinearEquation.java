
public class LinearEquation {
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;
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
        if (y1 == y2) {
            return 0;
        }
        return ((double)y2 - y1) / ((double)x2 - x1);
    }
    public String equation() {
        String yOverX = " " + (y2 - y1) + "/" + (x2 - x1);
        if (((y2 - y1) < 0) && ((x2 - x1) < 0)) {
            yOverX = " " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        } else if ((y2 - y1) < 0) {
            yOverX = " -" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        } else if ((x2 - x1) < 0) {
            yOverX = " -" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        }
        if ((x2 - x1) != 0) {
            if ((y2 - y1) % (x2 - x1) == 0) {
                if ((x2 - x1) != 1) {
                    yOverX = " " + slope();
                }
            }
        }
        if ((y2 - y1) != 0) {
            if ((x2 - x1) % (y2 - y1) == 0) {
                if ((y2 - y1) != 1) {
                    yOverX = " " + slope();
                }
            }
        }
        if (slope() == 1) {
            yOverX = " ";
        } else if (slope() == -1) {
            yOverX = " -";
        }
        if (yIntercept() < 0 && slope() != 0) {
            return  "y =" + yOverX + "x " + yIntercept();
        } else if (yIntercept() > 0 && slope() != 0) {
            return "y =" + yOverX + "x + " + yIntercept();
        } else if (yIntercept() == 0 && slope() != 0) {
            return "y =" + yOverX + "x";
        } else if (yIntercept() != 0 && slope() == 0) {
            return "y =" + yIntercept();
        }
        return " ";
    }
    public String coordinateForX(double x) {
        x = Math.round(x * 100) /100.0;
        double yCoordinate = roundedToHundredth(slope() * x + yIntercept());
        return "(" + x + " , " + yCoordinate + ")";
    }
    public String lineInfo() {
        if (x1 == x2) {
            return "The points are on the vertical line x = " + x1;
        }
        return ("The two points are: (" + x1 + ", " + y1 + ")" + " and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is " + distance());
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}