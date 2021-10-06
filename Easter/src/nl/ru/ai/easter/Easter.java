package nl.ru.ai.easter;

import java.util.Scanner;

public class Easter
{
  static boolean isLeapYear(int year)
  {
    return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
  }

  static int numberOfDaysInMonth(int year, Month month)
  {
    switch(month)
    {
      case FEBRUARY:
        return isLeapYear(year)? 29 : 28;
      case APRIL:
      case JUNE:
      case SEPTEMBER:
      case NOVEMBER:
        return 30;
      default:
        return 31;
    }
  }

  static Month easterMonth(int year)
  {
    return Month.month((mjbFormula(year) / 31));
  }

  static int easterDay(int year)
  {
    return (mjbFormula(year) % 31) +1;
  }

  static int mjbFormula(int year)
  {
    int a,b,c,d,e,f,g,h,i,k,L,m;
    a = year % 19;
    b = year / 100;
    c = year % 100;
    d = b / 4;
    e = b % 4;
    f = (b + 8) / 25;
    g = (b - f + 1) / 3;
    h = (19 * a + b - d - g + 15) % 30;
    i = c / 4;
    k = c % 4;
    L = (32 + 2 * e + 2 * i - h - k) % 7;
    m = (a + 11 * h + 22 * L) / 451;
    return(h + L - 7 * m + 114);
  }

  static int dayNumberInYear(int day, Month month, int year)
  {
    int monthNumber,dayNumber;
    monthNumber = month.number();
    dayNumber = 0;
    while(--monthNumber > 0)
    {
      dayNumber = dayNumber + numberOfDaysInMonth(year,Month.month(monthNumber));
    }
    return (dayNumber + day);
  }

  static Month monthInYearOfDayNumber(int dayNumber, int year)
  {
    int monthNumber, intDay;
    monthNumber = 1;
    intDay = 1;
    for(int loop=1; loop < dayNumber; loop++)
    {
      intDay++;
      if(numberOfDaysInMonth(year,Month.month(monthNumber)) < intDay)
      {
        intDay = 1;
        monthNumber++;
      }
    }
    return Month.month(monthNumber);
  }

  static int dayInMonthOfDayNumber(int dayNumber, int year)
  {
    Month month = monthInYearOfDayNumber(dayNumber,year);
    int monthDays = dayNumberInYear(0,month,year);
    int dayInMonth = dayNumber - monthDays;
    return dayInMonth;
  }

  static void showHolyDays(int year)
  {
    int easterDayInt = dayNumberInYear(easterDay(year),easterMonth(year),year);
    System.out.println("Easter is on " +easterDay(year) +" " +easterMonth(year));
    System.out.print("Carnival starts on " +dayInMonthOfDayNumber(easterDayInt - 49,year) +" "
            +monthInYearOfDayNumber(easterDayInt - 49,year) +" ");
    System.out.println("and is until " +dayInMonthOfDayNumber(easterDayInt - 47,year) +" "
            +monthInYearOfDayNumber(easterDayInt - 47,year));
    System.out.println("Good Friday is on " +dayInMonthOfDayNumber(easterDayInt - 2,year) +" "
            +monthInYearOfDayNumber(easterDayInt - 2,year));
    System.out.println("Whitsuntide is on " +dayInMonthOfDayNumber(easterDayInt + 49,year) +" "
            +monthInYearOfDayNumber(easterDayInt + 49,year));
    System.out.println("Ascension day is on " +dayInMonthOfDayNumber(easterDayInt + 39,year) +" "
            +monthInYearOfDayNumber(easterDayInt + 39,year));
  }

  public static void main(String[] arguments)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Calendar Tool.");
    System.out.print("Enter '1' to check if a year is a leap year. ");
    System.out.println("Enter '2' to get the holy days for a given year.");
    int userInput = input.nextInt();
    if(userInput == 1)
    {
      getLeapYear(input);
    }
    else if(userInput == 2)
    {
      getHolyDays(input);
    }
    else
    {
      System.out.println("Not a valid input.");
    }
    showYear(input);
  }

  private static void showYear(Scanner input)
  {
    int year = input.nextInt();
    int month = input.nextInt();
    int daySpaces = dayNumberInYear(easterDay(year),easterMonth(year),year);
    System.out.println(daySpaces);
    int startPoint = daySpaces;
    while(startPoint % 7 != 0)
    {
      startPoint++;
      System.out.println(startPoint);
    }
    daySpaces = 7 - (startPoint - daySpaces); //number of spaces at the beginning of the calendar/first month
    int endSpaces = 7 - ((daySpaces + numberOfDaysInMonth(year,Month.month(month))) % 7); //number of spaces at end of month
    System.out.println(daySpaces +" " +endSpaces);
  }

  private static void getHolyDays(Scanner input)
  {
    System.out.print("Please enter the year you would like to get holy days for: ");
    int year = input.nextInt();
    System.out.println("Holy days for " +year);
    showHolyDays(year);
  }

  private static void getLeapYear(Scanner input)
  {
    System.out.print("Please enter the year you would like check: ");
    int year = input.nextInt();
    if(isLeapYear(year))
    {
      System.out.println(year +" is a leap year.");
    }
    else
    {
      System.out.println(year +" is not a leap year");
    }
  }
}
