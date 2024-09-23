package creational.factory;
public class EliteMembership implements Membership {
    @Override
    public void getBenefits() {
        System.out.println("Elite membership: VIP access and rewards.");
    }
}
