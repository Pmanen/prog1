package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class Mondriaan
{
  public static void main(String[] args)
  {
    speed(20);
    makeRectangles(100);
  }

  public static void makeLine(int n)
  {
    while (n-- > 0)
    {
      if (!onBall())
        putBall();
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

  public static void makeRectangle(int size, int useless)
  {
    while (useless-- > 0)
    {
      makeLine(size);
      turnRight();
    }
  }

  public static void turn(int n){
    while (n-- > 0)
      turnRight();
  }

  public static void goSomewhere(int size, int yOffset, int xOffset){
    walk(yOffset);
    turnRight();
    walk(xOffset);
    turnLeft();
    makeRectangle(size, 4);
    turn(3);
    walk(xOffset);
    turnLeft();
    walk(yOffset);
    turn(2);
  }

  public static void buildHelper(int size){
    goSomewhere(size, random(0, 16 - size), random(0, 31 - size));
  }

  public static void makeRectangles(int n){
    while (n-- > 0)
    {
      buildHelper(random(1, 16));
    }
  }
}
