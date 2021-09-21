// Cody van Haalen - s1075021
// Pepijn van Manen - s4848004
package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class CatchThemAll
{

  public static void main(String[] args)
  {
    map("pokemap.map");
    speed(40);
    collectBalls();
    returnToStart();
    catchEmAll();
  }

  private static void collectBalls()
  {
    while (getNumberOfBalls() < 5)
    {
      if (onBall())
      {
        getBall();
      }
      else if (inFrontOfWall() && north())
      {
        turnRight();
        step();
        turnRight();
      }
      else if (inFrontOfWall() && south())
      {
        turnLeft();
        step();
        turnLeft();
      }
      else
      {
        step();
      }
    }
  }

  private static void returnToStart()
  {
    while (!inFrontOfWall())
    {
      step();
    }
    while (!west())
    {
      turnLeft();
    }
    while (!inFrontOfWall())
    {
      step();
    }
    while (!north())
    {
      turnRight();
    }
  }

  private static void catchEmAll()
  {
    while (getNumberOfPokemon() < 5)
    {
      if (onPokemon())
      {
        getPokemon();
      }
      else if (inFrontOfWall() && north())
      {
        turnRight();
        step();
        turnRight();
      }
      else if (inFrontOfWall() && south())
      {
        turnLeft();
        step();
        turnLeft();
      }
      else
      {
        step();
      }
    }
  }
}