package callendar;

/**
 *
 * @author lenka.wrnatova
 */
public class Callendar {

    /**
     * determines day of week from date
     * @param day day
     * @param month month
     * @param year year
     * @return 0 - saturday
     *         1 - sunday
     *         2 - monday
     *         3 - tuesday
     *         4 - wednesday
     *         5 - thursday
     *         6 - friday
     */
   public static int determinationOfTheDayOfTheWeek(int day, int month, int year){
       int h, m;
       int K = year%100;
       int J = year/100;
       if(month == 1 || month == 2){
           m = month + 12;
       }else{
           m = month;
       }
       h = (day + ((13*(m+1))/5) + K + K/4 + J/4 - 2*J)%7;
       return h;
   }
   
    public static void main(String[] args) {
        System.out.println(determinationOfTheDayOfTheWeek(14, 4, 2020));
        System.out.println(determinationOfTheDayOfTheWeek(1, 6, 2019));
        System.out.println(determinationOfTheDayOfTheWeek(31, 8, 1995));
    }
    
}
