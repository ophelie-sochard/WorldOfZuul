PROJECT TITLE: RobotV5
PURPOSE OF PROJECT: A goal-oriented robot
VERSION or DATE: 2021-08
AUTHORS: Patrick GIRARD

SUBJECT
Setters for the x and y position of the robot are a wrong solution. It is data oriented. 
A robot should have goal-oriented method. Concerning its position, a goal-oriented 
method should be “move()”, which should ask the robot to move…

At this step, we will replace our data-oriented method by a move goal-oriented method, 
whose behavior shall be to move one square in diagonals , so, to the right and to the bottom 
in one move.
If you are right, you can see that your robot is not able to move further that the middle 
of the canvas. Why?

Change your code to allow the robot to move from the top-left angle to the bottom-right angle.

Note: you are not allowed to modify either of the three classes Colour, Canvas and CanvasRobot.

PREREQUISITE
    Scenario #3 successful
    
SPECIAL INSTRUCTIONS
    1. Download the BlueJ project RobotV5
    2. Copy the Robot class from your previous project RobotV4 into this project, and compile it
    3. Change your x and y setters to private methods
    4. Write the move() method
    5. Assess your design
    6. Be sure you allow moving in all the canvas
    7. Run the Junit tests

SKILLS
    - Skill 1: Designing goal-oriented methods
    - Skill 2: Replace data-oriented methods 