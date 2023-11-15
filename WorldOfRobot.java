import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * The WorldOfRobot class is a class that will create the world in which the robots will evolve and be displayed.
 * 
 * @Group 14
 * @version 27/10/2023
 */
public class WorldOfRobot
{
    //Define an ArrayList called worldList which the robot's position will be stored
    private ArrayList<Robot> worldList;
    //This attribute uses the CanvasRobot class to draw the robot on the canvas
    private CanvasRobot canvasRobot;
    //Define the x position of the robot
    private int x;
    //Define the y position of the robot
    private int y;
    //Define an instance variable with the number of robots in the world
    private int numberOfRobots;
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 11;
  
    /**
     * Constructor of the Wolrd of Robots
     */
    public WorldOfRobot()
    {
        this.worldList = new ArrayList<Robot>();        
    }
    
    /**
     * Returns the list of robots in the world     
     */
    public ArrayList<Robot> getList(){
        return this.worldList;
    }

    /**
     * Get the number of robot objects in the list
     * @return size
     */
    public int getNumberOfRobots(){
        numberOfRobots = worldList.size();
        return numberOfRobots;
    }
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y, Robot requestingRobot) {
        for (Robot robot : worldList) {
            // Verify if the posiiton is already occupied
            if (robot != requestingRobot && robot.getXPosition() == x && robot.getYPosition() == y) {
                return false;
            }
        }
        return (x >= MIN_POSITION && x <= MAX_POSITION && y >= MIN_POSITION && y <= MAX_POSITION);
    }
    
    /**
     * Allows to move all the robots present in the world at the same time
     */
    public void moveAll(){
        for (Robot rob : worldList)
            rob.move();
    }
    
    /**
     * Allows to move all the robots present in the world at the same time with a number of mouvement given by the user
     * @param w, number of moves
     */
    public void moveAutomatic(int w) {
    for (int moveCount = 0; moveCount < w; moveCount++) {
        for (Robot robot : worldList) {
            robot.move();
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
    }   
        
    /**
     * Add robots to the list of robots present in the world.
     */
    void addRobot(Robot r){
        this.worldList.add(r);
    }
}
