import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner myScanner;
    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welcome to linear equation calculator!");
        String answer = "y";
        while (answer.equals("y")) {
            System.out.println("Enter coordinate 1: ");
            String coordinate1 = myScanner.nextLine();
            int x1 = Integer.parseInt(coordinate1.substring(1, coordinate1.indexOf(",")));
            int y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2));
            System.out.println("Enter coordinate 2: ");
            String coordinate2 = myScanner.nextLine();
            int x2 = Integer.parseInt(coordinate2.substring(1, coordinate1.indexOf(",")));
            int y2 = Integer.parseInt(coordinate2.substring(coordinate1.indexOf(",") + 2));
            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
            System.out.println(equation.lineInfo());
            System.out.println("\nEnter a value for x: ");
            double x = myScanner.nextInt();
            System.out.println("\nThe point on this line is: " + coordinateForX(x));
            System.out.println("Would you like to enter another pair of coordinates? (y/n) ");
            answer = myScanner.nextLine();
        }
    }


}