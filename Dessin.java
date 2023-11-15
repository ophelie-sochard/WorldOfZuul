import java.util.Random;
/**
 * A robot that moves around the world while drawing a line
 *
 * @author Thibault NIGGEL
 * @version 127/10/2023
 */
public class Dessin extends Robot{

    private String colourLine = "black";
    private static final String lesCouleurs[] = { "black", "red", "blue", "green", "yellow", "magenta", "white" };
    private boolean trace = true;
    
    /**
     * Constructor of the Dessin robot
     * @param newName, name of the Dessin robot
     * @param thisWorld, world in which the spiral robot will evolve
     */
    public Dessin(String newName, WorldOfRobot thisWorld) {
        //Creation of the robot with default coordinates
        super(newName, 0, 0, thisWorld);

        // Generate random coordinates until you get an unoccupied position
        do {
            xPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
            yPosition = (int) (Math.random() * (Robot.MAX_POSITION + 1));
        } while (!thisWorld.canItMove(xPosition, yPosition, this));

        // Add the robot to the list of robots and display it in the World
        thisWorld.addRobot(this);
        super.setColourBody("YELLOW");
        showRobot();
    }
    
    /**
     * Method to get the colour of the line drawn by the robot
     */
    public String getColourLine()
    {
        return colourLine;
    }
    
    /**
     * Metho to choose between "black", "red", "blue", "green", "yellow", "magenta", "white" for the line colour
     */
    public void setColourLine(String newColour)
    {
        colourLine = rendCouleur(newColour);
        showRobot();
    }
    
    /**
     * Method to verify if the new colour is known
     */
    private String rendCouleur(String newColour) {
        for (int i=0; i<lesCouleurs.length; i++)
            if (newColour.equalsIgnoreCase(lesCouleurs[i]))
              return newColour.toLowerCase();
        return "black";
    }
    
    /**
     * Method to set if the line is visible or not
     */
    public void setTracer(boolean mode) {
        trace = mode;
    }    
    
    /**
     * Method to manage the horizontal mouvement of the Dessin robot
     */
    public void moveHorizontal(int nbMove) {
        while (nbMove != 0) {
            int x = getXPosition();
            int y = getYPosition();
            
            boolean goingRight = (x != 10);
            boolean goingLeft = (x != 0);
            
            if (nbMove > 0)
            {
                if (goingRight)
                {
                    if (trace) CanvasRobot.ecrisHorizontal(xPosition, yPosition, colourLine);
                    x++;
                    setPosition(x,y);
                    nbMove--;
                } else {
                nbMove = -nbMove;
                }
            }
            
            if (nbMove < 0)
            {
                if (goingLeft)
                {
                    x--;
                    setPosition(x,y);
                    if (trace) CanvasRobot.ecrisHorizontal(xPosition, yPosition, colourLine);
                    nbMove++;
                } else {
                nbMove = -nbMove;
                }
            }
            showRobot();
        }
    }
    
    /**
     * Method to manage the vertical mouvement of the Dessin robot
     */
    public void moveVertical(int nbMove) {
        while (nbMove != 0) {
            int x = getXPosition();
            int y = getYPosition();
            
            boolean goingDown = (y != 10);
            boolean goingUp = (y != 0);
            
            if (nbMove > 0)
            {
                if (goingDown)
                {
                    if (trace) CanvasRobot.ecrisVertical(xPosition, yPosition, colourLine);
                    y++;
                    setPosition(x,y);
                    nbMove--;
                } else {
                nbMove = -nbMove;
                }
            }
            
            if (nbMove < 0)
            {
                if (goingUp)
                {
                    y--;
                    setPosition(x,y);
                    if (trace) CanvasRobot.ecrisVertical(xPosition, yPosition, colourLine);
                    nbMove++;
                } else {
                nbMove = -nbMove;
                }
            }
            showRobot();
        }
    }
    
    /*
     * Calls the moveFour() method four times to work better with moveAll() from the CanvasRobot class.
     */
    public void move()
    {
        for (int i = 0; i < 4; i++)
            moveFour();
    }
    
    /*
     * Method which makes the robot move in a random direction and with a random color.
     */
    public void moveFour()
    {
        Random rand = new Random(); 
    
        int choix = rand.nextInt(4);
        int rCoul = rand.nextInt(7);
        
        int x = getXPosition();
        int y = getYPosition();
        
        String color = lesCouleurs[rCoul];
        
        switch(choix) {
            case 0:
                if(this.canItMove(x+1, y) && this.canItDisplay(x+1, y)){
                    if (trace) CanvasRobot.ecrisHorizontal(xPosition, yPosition, color);
                    moveOne(x+1,y);
                }
                  break;
            case 1:
                if(this.canItMove(x-1, y) && this.canItDisplay(x-1, y)){
                    moveOne(x-1,y);
                    if (trace) CanvasRobot.ecrisHorizontal(xPosition, yPosition, color);
                }
                 break;
            case 2:
                if(this.canItMove(x, y+1) && this.canItDisplay(x, y+1)){
                    if (trace) CanvasRobot.ecrisVertical(xPosition, yPosition, color);
                    moveOne(x,y+1);
                }
                break;
            case 3:
                if(this.canItMove(x, y-1) && this.canItDisplay(x, y-1)){
                    moveOne(x,y-1);
                    if (trace) CanvasRobot.ecrisVertical(xPosition, yPosition, color);
                }
                break;
        }
    }
    
    /*
     * Moves one tile in any direction. Used in the move() method.
     */
    public void moveOne(int x, int y)
    {
        setPosition(x, y);
        showRobot();
    }
}