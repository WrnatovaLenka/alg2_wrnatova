package bank;

/**
 *
 * @author lenka.wrnatova
 */
public class Person extends Client {

    private String name;

    //konstruktor
    public Person(String name) {
        super(name);
    }

    /**
     * zobrazi jmeno klienta s oslovenim
     *
     * @return jmeno klienta s oslovenim
     */
    @Override
    public String displayNameOfClient() {
        String addressingFemale = "pani ";
        String addressingMale = "pan ";
        if (isFemale(this.getName())) {
            return addressingFemale + this.getName();
        } else {
            return addressingMale + this.getName();
        }

    }

    /**
     * zjisti, jestli je osoba zena nebo muz
     *
     * @param name jmeno osoby
     * @return vraci true, pokuid je osoba zena, false jinak
     */
    private static boolean isFemale(String name) {
        if (name.length() <= 3) {
            return false;
        } else if ("ova".equals(getLastLetters(name))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * zobrazi tri posledni pismena jmena
     *
     * @param name jmeno, jehoz poslkedni pismena chci zjistit
     * @return posledni tri pismena
     */
    private static String getLastLetters(String name) {
        String lastLetters = "";
        char letter;
        for (int i = 0; i < 3; i++) {
            letter = name.charAt(name.length() - 1 - i);
            lastLetters = Character.toLowerCase(letter) + lastLetters;
        }
        return lastLetters;
    }

}
