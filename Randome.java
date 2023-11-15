import java.util.Random;
/**
 * A robot that randomly moves around the world if the place is free
 *
 * @author Ophélie SOCHARD
 * @version 127/10/2023
 */
public class Randome extends Robot
{
    /**
     * Constructor of the Randome robot
     * @param newName, name of the Randome robot
     * @param thisWorld, world in which the spiral robot will evolve
     */
     public Randome(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
        super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("PURPLE");
        showRobot();
    }
    
    /**
     * Random function : for any position x and y, the Randome robot get a number between 0 and 10
     */
    public int Random010(){
        Random rand = new Random();
        int r=rand.nextInt(11);
        return r;  
    }
    
    /**
     * Movement method : canItMove tells if the position the robot tries to move in is already occupied
     * and canItDisplay tells if the position the robot tries to move in is included in the canvas
     */
    public void move()
    {
        int ny = Random010();
        int nx = Random010();
        if(this.canItMove(nx, ny) && this.canItDisplay(nx, ny)){
            this.setPosition(nx, ny);
            showRobot();
        }
    }
}
