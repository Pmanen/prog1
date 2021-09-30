package nl.ru.ai.easter;

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
        return (30);
      default:
        return (31);
    }
  }

  static Month easterMonth(int year)
  {
    // implement this function
    return Month.JANUARY;
  }

  static int easterDay(int year)
  {
    // implement this function
    return 0;
  }

  static int dayNumberInYear(int day, Month month, int year)
  {
    // implement this function
    return 0;
  }

  static Month monthInYearOfDayNumber(int dayNumber, int year)
  {
    // implement this function
    return Month.JANUARY;
  }

  static int dayInMonthOfDayNumber(int dayNumber, int year)
  {
    // implement this function
    return 0;
  }

  static void showHolyDays(int year)
  {
    // implement this function
  }

  static void printLabels(){
    System.out.print("Su Mo Tu We Th Fr Sa");
  }

  static void printLabelRow(){
    printLabels();
    System.out.print("  ");
    printLabels();
    System.out.print("  ");
    printLabels();
  }

  printMonthRow(int seq){

  }

  static void showYear(int year){
    printLabelRow();
  }

  public static void main(String[] arguments)
  {
    showYear(2021);
  }
}
