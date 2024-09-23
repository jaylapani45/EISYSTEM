package creational.factory;
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Membership membership = MembershipFactory.createMembership("premium");
        membership.getBenefits();
    }
}
