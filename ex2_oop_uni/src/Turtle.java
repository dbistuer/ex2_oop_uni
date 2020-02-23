import acm.graphics.GOval;

import java.awt.*;

public class Turtle{
    public static final int TURTLE_SIZE = 85;
    private int positionX;
    private int positionY;
    private int ratio;
    private Color color;
    private GOval turtle;

    public Turtle(int positionY,int ratio) {
        this.positionY = positionY;
        this.positionX = 0;
        this.ratio = ratio;
        this.color = Color.green;
        getTurtleReady();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getRatio() {
        return ratio;
    }

    public void setColor(Color color) {
        this.color = color;
        this.turtle.setFillColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public GOval getTurtle() {
        return turtle;
    }

    private void getTurtleReady(){
        turtle = new GOval(positionX,positionY,TURTLE_SIZE,TURTLE_SIZE);
        turtle.setFillColor(this.color);
        turtle.setFilled(true);
    }

    public int maxPosX(){
        return getPositionX()+TURTLE_SIZE*2;
    }

    public void move(int x){
        turtle.move(x,0);
    }

}