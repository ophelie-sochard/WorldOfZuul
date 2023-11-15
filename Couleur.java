import java.util.Random;
/**
 * A robot that changes color every movement
 * @author Lauranne LAIR 
 * @version 27/10/2023
 * */
public class Couleur extends Robot
{
    static private Random randomGenerator;
    private boolean goingRight = true;
    private int couleur = 1;
    /**
     * Constructor to create a Couleur robot
     * @param newName, name of the Couleur robot
     * @param thisWorld, world in which the couleur robot will evolve
     */
     public Couleur(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
         super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("BLUE");
        showRobot();
    }
    
    /**
     * Random generator for changing color 
     */
    public void randomColour(){
        // Generate a random number
        int r = new Random().nextInt(8);
        // Case on the random number to select a colour
        switch (r){
            case 1 : setColourBody("MAGENTA");break;
            case 2 : setColourBody("RED");break;
            case 3 : setColourBody("YELLOW");break;
            case 4 : setColourBody("GREEN");break;
            case 5 : setColourBody("BLUE");break;
            case 6 : setColourBody("PURPLE");break;
            case 7 : setColourBody("BLACK");break;
            case 0 : setColourBody("WHITE");break;
        }
    }
    
    /**
     * A method to manage the movement of the Couleur robot
     */
    public void move() {
        // Get the position of the robot
        int currentX = getXPosition();
        int currentY = getYPosition();
        // Check if the robot reaches the limits and change position if necessary
        if (goingRight) {
            // Go the the right
            currentX++;
        } else {
            // Go to the left
            currentX--;
        }
        // Check if the robot reaches the limits and change orientation if necessary
        if (currentX == 11) {
            // Change the orientation to the left
            goingRight = false;  
            currentX--;
        } else if (currentX == 0) {
            // Change the orientation to the right
            goingRight = true;
            currentX++;
        }
        // Update the position of the robot
        setPosition(currentX, currentY);
        // Change the color randomly
        randomColour();
        // Display the robot in the Wolrd
        showRobot();
    }
}

