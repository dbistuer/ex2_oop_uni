import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Race extends GraphicsProgram {
    private static final int NUM_TURTLES = 10;
    private static final int PAUSE = 550;
    private static final int RACE_PAUSE = 1;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Turtle[] TurtleList = new Turtle[10];
    public boolean finished = false;


    public void run() {
        screenSize.width = screenSize.width-100;
        screenSize.height = screenSize.height-50;
        this.resize(screenSize);
        setTurtlesOnStart();
        countBack();
        while(TurtleList[0].maxPosX()<screenSize.getWidth() && TurtleList[1].maxPosX()<screenSize.getWidth() && TurtleList[2].maxPosX()<screenSize.getWidth() &&
                TurtleList[3].maxPosX()<screenSize.getWidth() && TurtleList[4].maxPosX()<screenSize.getWidth() && TurtleList[5].maxPosX()<screenSize.getWidth() &&
                TurtleList[6].maxPosX()<screenSize.getWidth() && TurtleList[7].maxPosX()<screenSize.getWidth() && TurtleList[8].maxPosX()<screenSize.getWidth() &&
                TurtleList[9].maxPosX()<screenSize.getWidth() && !finished){
            for (Turtle turtle:TurtleList) {
                turtle.move(rollDie());
                this.pause(RACE_PAUSE);
                if(turtle.getTurtle().getX()+turtle.getTurtle().getWidth()>screenSize.getWidth()){
                    turtle.setColor(Color.red);
                    finished = true;
                    break;
                }
            }
        }

    }

    public int rollDie() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1, 6);
    }

    public void setTurtlesOnStart(){
        for(int index=0;index<NUM_TURTLES;index++){
            TurtleList[index]=new Turtle(index*Turtle.TURTLE_SIZE,Turtle.TURTLE_SIZE);
        }
        for (Turtle turtle:TurtleList) {
            add(turtle.getTurtle(),turtle.getPositionX(),turtle.getPositionY());
        }
    }

    public void countBack(){
        double startX;
        GRect number1 = createNumber();
        GRect number2 = createNumber();
        GRect number3 = createNumber();
        this.pause(PAUSE);
        startX = number1.getWidth()*1.5+50;
        add(number1,(screenSize.getWidth()/2-startX),(screenSize.getHeight()/2-number1.getHeight()/2));
        add(number2,(screenSize.getWidth()/2-(startX+number1.getWidth()+50)),(screenSize.getHeight()/2-number1.getHeight()/2));
        add(number3,(screenSize.getWidth()/2-(startX+((number1.getWidth()+50)*2))),(screenSize.getHeight()/2-number1.getHeight()/2));
        this.pause(PAUSE);
        number3.setVisible(false);
        this.pause(PAUSE);
        number2.setVisible(false);
        this.pause(PAUSE);
        number1.setVisible(false);
    }

    private GRect createNumber(){
        GRect number = new GRect(10,50);
        number.setColor(Color.GRAY);
        number.setFilled(true);
        return number;
    }

    public static void main(String[] args) {
        new Race().start(args);
    }
}


