/**
 * A robot that can dance in the World
 *
 * @author Florian PAILLAS
 * @version 27/10/2023
 */
public class Danseur extends Robot {
    /**
     * Constructor of the Danseur robot
     * @param newName, name of the Danseur robot
     * @param thisWorld, world in which the spiral robot will evolve
     */
    public Danseur(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
        super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("GREEN");
        showRobot();
    }
    
    /**
     * Metho to manage the mouvement of the Danseur robot
     */
    public void move() {
        try {
        xPosition=4;
        yPosition=4;
        showRobot();
        for (int i=0; i<4; i++){
        xPosition +=1;
        showRobot();
        Thread.sleep(250);
        }
        for (int i=0; i<4; i++){
        xPosition -=1;
        showRobot();
        Thread.sleep(250);
        }
        for (int i=0; i<3; i++){
        yPosition +=1;
        showRobot();
        Thread.sleep(250);
        }
        for (int i=0; i<3; i++){
        yPosition -=1;
        showRobot();
        Thread.sleep(250);
        }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Method to manage the Valse dance
     */
    public void Valse() {
        try {
            xPosition =4;
            yPosition=4;
            showRobot();
            xPosition +=1;
            showRobot();
            Thread.sleep(250);
            xPosition -=1;
            showRobot();
            Thread.sleep(250);
            yPosition +=1;
            showRobot();
            Thread.sleep(250);
            yPosition -=1;
            showRobot();
            Thread.sleep(250);
            xPosition -=1;
            showRobot();
            Thread.sleep(250);
            xPosition -=1;
            showRobot();
            Thread.sleep(250);
            xPosition +=1;
            showRobot();
            Thread.sleep(250);
            yPosition -=1;
            showRobot();
            Thread.sleep(250);
            yPosition +=1;
            showRobot();
            Thread.sleep(250);
            xPosition +=1;
            showRobot();
            Thread.sleep(250);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}