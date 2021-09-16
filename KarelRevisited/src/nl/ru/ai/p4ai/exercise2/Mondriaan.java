package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

// Cody van Haalen - s1075021
// Pepijn van Manen - s4848004

public class Mondriaan
{
  public static void main(String[] args)
  {
    speed(1);
    makeRectangles(1000);
  }

  public static void safeBall()
  {
    if (!onBall())
      putBall();
  }

  public static void makeLine(int n)
  {
    if (n == 0) {
      safeBall();
    }
    while (n-- > 0){
      safeBall();
      step();
    }
  }

  public static void walk(int n)
  {
    while (n-- > 0)
    {
      step();
    }
  }

  public static void makeRectangle(int sizeY, int sizeX, int useless)
  {
    while (useless-- > 0) {
      makeLine(sizeY - 1);
      turnRight();
      makeLine(sizeX - 1);
      turnRight();
    }
  }

  public static void turn(int n){
    while (n-- > 0)
      turnRight();
  }

  public static void goSomewhere(int sizeY, int sizeX, int yOffset, int xOffset){
    walk(yOffset);
    turnRight();
    walk(xOffset);
    turnLeft();
    makeRectangle(sizeY, sizeX, 2);
    turn(3);
    walk(xOffset);
    turnLeft();
    walk(yOffset);
    turn(2);
  }

  public static void buildHelper(int sizeY, int sizeX){
    goSomewhere(sizeY, sizeX, random(0, 16 - sizeY), random(0, 31 - sizeX));
  }

  public static void makeRectangles(int n){
    while (n-- > 0)
    {
      buildHelper(random(1, 16), random(1, 31));
    }
  }
}
