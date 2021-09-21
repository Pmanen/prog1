// Cody van Haalen - s1075021
// Pepijn van Manen - s4848004
package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class Path
{
  public static void main(String[] args)
  {
    map("path.map");
    speed(50);
    checkFront();
    while (!east())
      turnRight();
  }

  public static void  checkFront(){
    if (!inFrontOfWall())
    {
      step();
      if (onBall())
        checkFront();
      else {
        turn(2);
        step();
        turn(2);
        checkLeft();
      }
    }
    else
      checkLeft();
  }

  public static void  checkLeft(){
    turnLeft();
    if (!inFrontOfWall()){
      step();
      if (onBall()) {
        checkFront();
      }
      else {
        turn(2);
        step();
        checkRight();
      }
    }
    else{
      turn(2);
      checkRight();
    }
  }

  public static void checkRight(){
    if (!inFrontOfWall()) {
      step();
      if (onBall()){
        checkFront();
      }
      else{
        turn(2);
        step();
      }
    }
  }

  public static void turn(int n){
    while (n-- > 0)
      turnRight();
  }
}
