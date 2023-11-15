/**
 * This robot moves in a spiral pattern. 
 * It can make a big spiral then a smaller one before going back to the center and turning green.
 *
 * @author Laurène DONG 
 * @version 27/10/2023
 */
public class Spiral extends Robot
{
    //This attribute defines the trajectory of the Spiral robot
    int trajectory = 1;
    //This attribute defines the spiraleRate of the Spiral robot
    int spiraleRate = 0;
    //This attribute defines the xtemp position of the Spiral robot
    int xtemp=5;
    //This attribute defines the ytemp position of the Spiral robot
    int ytemp=5;
    
    /**
     * Constructor to create the Spiral robot 
     * @param newName, name of the Spiral robot
     * @param thisWorld, world in which the spiral robot will evolve
    */
     public Spiral(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
        super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("MAGENTA");
        showRobot();
    }
    
     /**
     * A method that allows the Spiral robot to move while checking that the position isn't taken.
     * The robot becomes green when it goes back to the center of the world.
    */
    public void move(){
        int nx = getXPosition();
        int ny = getYPosition();
        
        // Trajectory 1 from left ro right -> EAST
        // Trajectory 2 from up to down -> SOUTH
        // Trajectory 3 from right to left -> WEST
        // Trajectory 4 from down to up -> NORTH
        
        if (trajectory == 1){ 
            xtemp = xtemp + 1+ spiraleRate;
        }
        else if (trajectory == 2){ 
            ytemp = ytemp +1+ spiraleRate;
        }
        else if (trajectory == 3){ 
            xtemp = xtemp -1- spiraleRate;
        }
        else {
            ytemp = ytemp - 1- spiraleRate;
        }         
        trajectory++;
        
        if (trajectory == 5 ) {
            trajectory = 1;
        }
        spiraleRate++;
        
        if (spiraleRate==6){
            spiraleRate=0;
            setPosition(5,5);
            setColourBody("GREEN");
        }
    
        if(canItMove(xtemp,ytemp)){
            setColourBody("MAGENTA");
        
            nx=xtemp;
            ny=ytemp;
            setPosition(nx,ny);
        }
        else{
            if(canItMove(5,5)){
                nx=5;
                ny=5;
                setPosition(nx,ny);
            }
        }
        // Display the Spiral robot
        showRobot();
    }
}