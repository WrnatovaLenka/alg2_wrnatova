package wrnatova_hurricane;

/**
 *
 * @author lenka.wrnatova
 */
public class Hurricane {

    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public double getSpeedInKmH() {
        return speed * (1.852);

    }

    public int getHurricaneCategory() {
        double speed = getSpeedInKmH();
        if (speed > 118 && speed < 154) {
            return 1;
        } else if (speed > 153 && speed < 178) {
            return 2;
        } else if (speed > 177 && speed < 209) {
            return 3;
        } else if (speed > 208 && speed < 252) {
            return 4;
        } else if (speed > 251) {
            return 5;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%-6d%-10s%-5d%-4d%-10s", year, month, pressure, speed, name);
    }

}
