package creational.factory;
public class FreeMembership implements Membership {
    @Override
    public void getBenefits() {
        System.out.println("Free membership: Limited access.");
    }
}
