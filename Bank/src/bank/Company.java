package bank;

/**
 *
 * @author lenka.wrnatova
 */
public class Company extends Client {
    private String name;

    public Company(String name) {
        this.name = name;
    }
    
    

    @Override
    public String displayNameOfClient() {
        String company = "firma ";
        return company + this.name;
    }
    
    public static void main(String[] args) {
        Company c1 = new Company("Blboun s.r.o.");
        System.out.println(c1.displayNameOfClient());
    }
    
}
