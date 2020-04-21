package callendar;

/**
 *
 * @author lenka.wrnatova
 */
public class Callendar {

    /**
     * determines day of week from date
     *
     * @param day day
     * @param month month
     * @param year year
     * @return  0 - monday 
     *          1 - tuesday 
     *          2 - wednesday 
     *          3 - thursday 
     *          4 - friday 
     *          5 - saturday 
     *          6 - sunday
     */
    public static int determineTheDayOfTheWeek(int day, int month, int year) {
        int h, m;
        int K = year % 100;
        int J = year / 100;
        if (month == 1 || month == 2) {
            m = month + 12;
        } else {
            m = month;
        }
        h = (day + ((13 * (m + 1)) / 5) + K + K / 4 + J / 4 - 2 * J) % 7;
        return (h+5)%7;
    }

    /**
     * vraci pocet dni v mesici
     * @param month mesic
     * @param year rok
     * @return  pocet dni v mesici
     */
    public static int determineNumberOfDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return -1;
        }
    }
    
    /**
     * vyjadri slovne mesic
     * @param month mesic
     * @return 
     */
    public static String determineMonth(int month) {
        switch (month) {
            case 1:
                return "LEDEN";
            case 2:
                return "UNOR";
            case 3:
                return "BREZEN";
            case 4:
                return "DUBEN";
            case 5:
                return "KVETEN";
            case 6:
                return "CERVEN";
            case 7:
                return "CERVENEC";
            case 8:
                return "SRPEN";
            case 9:
                return "ZARI";
            case 10:
                return "RIJEN";
            case 11:
                return "LISTOPAD";
            case 12:
                return "PROSINEC";
            default:
                return "NECO JE TU BLBE";
        }
    }

    /**
     * urcuje, zda je rok prestupny
     * @param year rok
     * @return true, pokud je rok prestupny, false jinak
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
    /**
     * prints calendar for given month and year (btw I know that calendar is with single l)
     * @param month - month
     * @param year  - year
     */
    public static void printCallendar(int month, int year) {
        int day = 1;
        int start = determineTheDayOfTheWeek(1, month, year);
        int maxDay = determineNumberOfDaysInMonth(month, year);
        System.out.println(determineMonth(month) + " " + year);
        System.out.println("PO UT ST CT PA SO NE");
        for (int k = 0; k < start ; k++) {
                   System.out.print("   "); 
                }
        for (int i = 0; i < 7 - start; i++) {
            if(day<=maxDay){
            System.out.format("%2d ", day);
                day++;
            }
            
        }
        System.out.println("");
         
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if(day<=maxDay){
                System.out.format("%2d ", day);
                day++;
                }
            }
            System.out.println("");
        }
        
    }

    public static void main(String[] args) {
//        System.out.println(determineTheDayOfTheWeek(14, 4, 2020));
//        System.out.println(determineTheDayOfTheWeek(1, 6, 2019));
//        System.out.println(determineTheDayOfTheWeek(31, 8, 1995));
//        System.out.println(determineNumberOfDaysInMonth(2, 2020));
//        System.out.println(determineNumberOfDaysInMonth(2, 2100));
//        System.out.println(determineNumberOfDaysInMonth(2, 2400));
//        System.out.println(determineNumberOfDaysInMonth(2, 2019));
//         System.out.println(determineNumberOfDaysInMonth(8, 1995));
//          System.out.println(determineNumberOfDaysInMonth(11, 2030));
//          System.out.println(isLeapYear(2020));
//System.out.println(2020);
printCallendar(8, 1995);
printCallendar(4, 2020);
printCallendar(12, 2020);
//System.out.println(determineTheDayOfTheWeek(11, 6, 1972));
    }

}
