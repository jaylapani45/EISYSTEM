package creational.factory;
public class PremiumMembership implements Membership {
    @Override
    public void getBenefits() {
        System.out.println("Premium membership: Full access.");
    }
}
