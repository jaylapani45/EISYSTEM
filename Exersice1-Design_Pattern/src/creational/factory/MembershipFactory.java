package creational.factory;
public class MembershipFactory {
    public static Membership createMembership(String type) {
        switch (type.toLowerCase()) {
            case "free":
                return new FreeMembership();
            case "premium":
                return new PremiumMembership();
            case "elite":
                return new EliteMembership();
            default:
                throw new IllegalArgumentException("Unknown membership type: " + type);
        }
    }
}
