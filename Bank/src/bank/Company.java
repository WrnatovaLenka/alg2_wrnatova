package bank;

/**
 *
 * @author lenka.wrnatova
 */
public class Company extends Client {

    private String name;

    //konstruktor
    public Company(String name) {
        super(name);
    }

    /**
     * metoda vraci firna + jmeno_firmy
     *
     * @return
     */
    @Override
    public String displayNameOfClient() {
        String company = "firma ";
        return company + this.getName();
    }

}
