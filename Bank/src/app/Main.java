package app;

import bank.Client;
import bank.Company;
import bank.Person;
import java.util.ArrayList;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    static ArrayList<Client> clients = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clients.add(new Person("Pekar"));
        clients.add(new Person("Svecova"));
        clients.add(new Company("Skoda"));

        findClient("Pekar").addAccount(1000);
        findClient("Pekar").addAccount(500);
        findClient("Svecova").addAccount(1200);
        findClient("Skoda").addAccount(120);

        displayClients();

    }

    /**
     * zobrazi vsechny klienty
     */
    public static void displayClients() {
        for (Client client : clients) {
            System.out.println(client.displayNameOfClient());
            System.out.println("Celkova suma penez na vsech uctech: " + client.showSumAccountBalance());

        }
    }

    /**
     * najde klienta podle jmena
     *
     * @param name jmeno klienta
     * @return klienta(objekt) s timto jmenem
     */
    public static Client findClient(String name) {
        for (Client client : clients) {
            if (name.equals(client.getName())) {
                return client;
            }
        }
        return null;
    }

}
