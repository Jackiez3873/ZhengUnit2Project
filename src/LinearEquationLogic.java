import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner myScanner;
    private LinearEquation equation;

    private int x1;
    private int x2;

    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
        equation = null; // will initialize from user input
        x2 = 0;
        x1 = 0;
    }
    public void start() {
        greet();
        getEquationData();
    }
    private void getCoordinateInfo() {
        System.out.print("\nEnter coordinate 1: ");
        String coordinate1 = myScanner.nextLine();
        x1 = Integer.parseInt(coordinate1.substring(1, coordinate1.indexOf(",")));
        int y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.length() - 1));
        System.out.print("Enter coordinate 2: ");
        String coordinate2 = myScanner.nextLine();
        x2 = Integer.parseInt(coordinate2.substring(1, coordinate2.indexOf(",")));
        int y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.length() - 1));
        equation = new LinearEquation(x1, y1, x2, y2);
    }
    private void getEquationData() {
        String answer = "y";
        while (answer.equals("y")) {
            getCoordinateInfo();
            System.out.println("\n" + equation.lineInfo());
            if (x2 == x1) {
                System.out.print("\nEnter a value for x: ");
                double x = myScanner.nextDouble();
                System.out.println("\nThe point on this line is: " + equation.coordinateForX(x));
            }
            System.out.print("\nWould you like to enter another pair of coordinates? (y/n): ");
            answer = myScanner.nextLine();

        }
    }
    private void greet() {
        System.out.print("Welcome to linear equation calculator!");
    }


}