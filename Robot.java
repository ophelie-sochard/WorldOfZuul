import java.lang.*;
import java.util.*;
import java.util.Random;
/**
 * The Robot class
 * 
 * @author Group 14
 * @version 27/10/2023
 */
public class Robot {
    public static final int MIN_NAME_LENGTH = 3;
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 11;
    private static int numberOfUnnamedRobots = 1;
    private int vitesse;
    private int direction; 
    private String name;
    public int xPosition;
    public int yPosition;
    private CanvasRobot canvasRobot; 
    private Canvas canvas;
    private WorldOfRobot worldR;
    private String colourBody;
    
    /**
     * Constructor for our robot object, if there is more robots than spots available in the world, the
       position is set to 0,0 and we have a game over.
     * @param x, robot's x position 
     * @param y, robot's y position
     * @param newName, name for our robot
     * @param worldR, world in which the robot will move in
     */
    public Robot(String name, int xPosition, int yPosition, WorldOfRobot worldR) {
        this.colourBody = "DEFAULT_COLOR";  // Set a default color
    
        // Verify and set the name
        if (name.trim().length() >= MIN_NAME_LENGTH) {
            this.name = name.trim();
        } else {
            this.name = "iRobot" + numberOfUnnamedRobots;
            numberOfUnnamedRobots++;
        }
    
        // Check if the world is not null and there is space for the robot
        if (worldR != null && worldR.getNumberOfRobots() < 122) {
            // Set position using the provided coordinates
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        } else {
            System.err.println("World is null or no space for the robot. Setting position to (0, 0).");
            this.xPosition = 0;
            this.yPosition = 0;
        }
    
        this.worldR = worldR;
        this.canvasRobot = new CanvasRobot(colourBody);
    }
    
    /**
     * Method to get the robot's name
     */
    public String getName() {
        return name;
    }

    /**
     * Class method to get the number of unnamed robots
     */
    public static int getNumberOfUnnamedRobots() {
        return numberOfUnnamedRobots;
    }

    /**
     * Method to set a robot's name
     */
    public void setName(String name) {
        // Verification of the name's length
        if (name.trim().length() >= MIN_NAME_LENGTH) {
            this.name = name.trim();
        } else {
            System.err.println("Name must have at least 3 characters");
        }
    }

    /**
     * Method to get the X posiiton of a robot
     */
    public int getXPosition() {
        return xPosition;
    }
    
    /**
     * Method to get the Y position of a robot
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Set an x position for the robot according to the given conditions. 
     * If the indicated parameters do not respect the conditions, the robot takes a place generated randomly.
     * @param x, horizontal robot position
     * @param y, vertical robot position
    */
    public void setPosition(int nx, int ny) {
        if (canItMove(nx, ny) && canItDisplay(nx, ny)) {
            this.xPosition = nx;
            this.yPosition = ny;
        }
    }
    
    /**
     * Method to set the colour body of a robot
     */
    public void setColourBody(String colourBody){
        this.colourBody= colourBody;
        canvasRobot.setColourBody(colourBody);
    }
    
    /**
     * Method to get the colour body of a robot
     */
    public String getColourBody(){
        return colourBody;
    }
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y){
        return worldR.canItMove(x, y, this);
    }
    
    /**
     * Allows moving robots according to their specifications.
     */
    public void move(){
        
    }
    
    /**
     * Tells if the position the robot tries to move in is included in the canvas
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * return true/false, the robot's position has a value between [0;10]
     */
    public boolean canItDisplay(int x, int y){
        if ((x >= MIN_POSITION) && (x <= MAX_POSITION) && (y >= MIN_POSITION) && (y <= MAX_POSITION)){
             return true;                   
            }
        else return false;    
    }
    
    /**
     * Display the robot using the canvas
     */
    public void showRobot(){
       this.canvasRobot.drawRobot(xPosition, yPosition);
    }
}