import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Draws robots on a canvas.
 * 
 * @author Patrick Girard 
 * @version 2021.08
 */
public class CanvasRobot
{
    static private Canvas canvas = Canvas.getCanvas(); 
    static private Random randomGenerator;
    
    static private ArrayList<CanvasRobot> canvasRobotList = new ArrayList<CanvasRobot>();
    static private boolean gameOver = false;
    // Coordiantes for redraw
    private boolean redrawable;
    private int x;
    private int y;
    
    static private int n = 0;
    private int lo = 30;
    private int la = 31;
    private int plo = 8;
    private int pla = 10;
    private int tlo = 26;
    private int tla = 13;
    private int qla = 4;
    private int milieu = 240;
    static private Colour colourHead = Colour.RED;
    private Colour colourBody = Colour.BLUE;
    static private Colour colourLeg = Colour.BLACK;
    static private Colour colourEye = Colour.GREEN;
    private Integer corps;
    private Integer brasG;
    private Integer brasD;
    private Integer jambeG;
    private Integer jambeD;
    private Integer tete;
    private Integer oeilD;
    private Integer oeilG;

    /**
     * CanvasRobot Constructor - Creates a new graphical robot, which can be drawn. 
     * if the colour is not correct, the colour body is set to BLUE
     * The robot is not drawn at this time (no coordinates)
     *
     * @param colour body colourBody
     */
    public CanvasRobot ( String colourBody )
    {
        // The random generator is instanciated if necessary
        if (randomGenerator == null) randomGenerator = new Random();
        // The different objects of the robot are instanciated, to allow the process of identification 
        // of graphical objects in the canvas. 
        corps = new Integer(randomGenerator.nextInt());
        brasG = new Integer(randomGenerator.nextInt());
        brasD = new Integer(randomGenerator.nextInt());
        jambeG = new Integer(randomGenerator.nextInt());
        jambeD = new Integer(randomGenerator.nextInt());
        tete = new Integer(randomGenerator.nextInt());
        oeilD = new Integer(randomGenerator.nextInt());
        oeilG = new Integer(randomGenerator.nextInt());

        this.colourBody = valueOf(colourBody);
        redrawable = false;
    }
    /**
     * Draws a robot onto the canvas - No verification on the coordinates. 
     * If the robot was already drawn, it is erased (thanks to Canvas)
     * stores the coordinates to allow redraw if the color changes
     *
     * @param  x,y  robot position
     */
    public void drawRobot(int x, int y)
    {
        int xp = x*50 + 5 ;
        int yp = y*50 ;
        canvas.draw(brasG, colourLeg, new Rectangle(xp, yp+15, 
                                     plo, pla));
        canvas.draw(brasD, colourLeg, new Rectangle(xp+la+2, yp+15, 
                                     plo, pla));
        canvas.draw(jambeG, colourLeg, new Rectangle(xp+10, yp+40, 
                                     plo, pla));
        canvas.draw(jambeD, colourLeg, new Rectangle(xp+la-8, yp+40, 
                                     plo, pla));
        canvas.draw(tete, colourHead, new Rectangle(xp+14, yp, 
                                     tla, tlo));
        canvas.draw(oeilG, colourEye, new Ellipse2D.Double(xp+14, yp+2, 
                                     qla, qla));
        canvas.draw(oeilD, colourEye, new Ellipse2D.Double(xp+21, yp+2, 
                                     qla, qla));
        canvas.draw(corps, colourBody, new Rectangle(xp+5, yp+12, 
                                     la, lo));
        this.x = x;
        this.y = y;
        redrawable = true;
    }
    
    /**
     * Method setColourBody
     * Sets the colour of the body and draw it again
     * 
     * @param colourBody the new colour
     */
    public void setColourBody(String colourBody){
        this.colourBody = valueOf(colourBody);
        if (redrawable) drawRobot(this.x, this.y);
    }
    
    /**
     * Method getColourBody
     *
     * @return The actual color of the body
     */
    public String getColourBody(){
        return colourBody.toString();
    }
    
    
    /**
     * Utilitary method valueOf
     * returns the value of the String param il enum Colour, with no sensitive letters
     * if the String is not a colour, returns "BLUE"
     *
     * @param colour the String that represents the colour
     * @return value in Colour enum
     */
    private static Colour valueOf(String colour){
       try {
            return Colour.valueOf(colour.toUpperCase());
        } catch (Exception e) {
        }
        return Colour.BLUE;
    }

    private boolean collision(){
        for (CanvasRobot c:canvasRobotList) 
            if ((c!=this)&&(x==c.x)&&(y==c.y)&&(c.redrawable))  
                return true;
        return false;
    }
    
    private boolean outOfCanvas() {
        if (x<0) return true;
        if (y<0) return true;
        if (x>11) return true;
        if (y>11) return true;
        return false;
    }
    
    private static void gameOver(){
        gameOver = true;
        canvas.gameOver();
    }
    
    public static void ecrisVertical(int x1, int y1, String color)
    {
        String trait = new String("Trait" + n++);
        Canvas canvas = Canvas.getCanvas(); 
        int xPosition = x1*50 + 18;
        int yPosition = y1*50 + 18;
        int la = 5;
        int lo = 55;
        Colour newColor = valueOf(color);
        canvas.draw(trait, newColor,
                        new Rectangle(xPosition, yPosition, la, lo));
    }

    /**
     * Trace un trait noir vers l'est
     *
     * @param  x1,y1   position du point de départ, en cases
     */
    public static void ecrisHorizontal(int x1, int y1, String color)
    {
        String trait = new String("Trait" + n++);
        Canvas canvas = Canvas.getCanvas(); 
        int xPosition = x1*50 + 18;
        int yPosition = y1*50 + 18;
        int la = 5;
        int lo = 55;
        Colour newColor = valueOf(color);
        canvas.draw(trait, newColor,
                        new Rectangle(xPosition, yPosition, lo, la));
    }

}