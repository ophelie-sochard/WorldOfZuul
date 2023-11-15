/**
 * A robot that can talk and calculate while moving diagonally in the World
 *
 * @author Marion DOSPITAL
 * @version 27/10/2023
 */
public class Savant extends Robot
{
    private String parler;
    private boolean goingRight = true;  
    private boolean goingDown = true;
    
    /**
     * Constructor of the Savant robot
     * @param newName, name of the Savant robot
     * @param thisWorld, world in which the spiral robot will evolve
     */
    public Savant(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
        super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("RED");
        showRobot();
    }
    
    /**
     * Method to talk : display the message given by the user
     */
    public void setParler(String message)
    {
        System.out.println("En français : " + message);
    }

    /**
     * Method for making calculations
     */
    public double effectuerCalcul(double nombre1, double nombre2, char operateur)
    {
        double resultat = 0.0;
        switch (operateur)
        {
            case '+':
                resultat = nombre1 + nombre2;
                break;
            case '-':
                resultat = nombre1 - nombre2;
                break;
            case '*':
                resultat = nombre1 * nombre2;
                break;
            case '/':
                if (nombre2 != 0)
                    resultat = nombre1 / nombre2;
                else
                    System.out.println("Division par zéro impossible.");
                break;
            default:
                System.out.println("Opérateur non reconnu.");
        }
        return resultat;
    }
    
    /**
     * Method to manage the mouvement of the Savant robot
     */
    public void move() {
        int maxX = MAX_POSITION - 1;  // Max limit in x
        int maxY = MAX_POSITION - 1;  // Max limit in y
        int currentX = getXPosition();
        int currentY = getYPosition();
        // Check if the robot reaches the limits and change position if necessary
        if (goingRight) {
            currentX++;
        } else {
            currentX--;
        }
        if (goingDown) {
            currentY++;
        } else {
            currentY--;
        }
        //Check if the robot reaches the limits and change orientation if necessary
        if (currentX == maxX) {
            goingRight = false;  // Change the orientation to left
        } else if (currentX == 0) {
            goingRight = true;  // Change the orientation to right
        }
        if (currentY == maxY) {
            goingDown = false;  // Change the orientation to up
        } else if (currentY == 0) {
            goingDown = true;  // Change the orientation to down
        }
        // Update the robot's position
        setPosition(currentX, currentY);
        // Display the Savant robot
        showRobot();
    }
}
