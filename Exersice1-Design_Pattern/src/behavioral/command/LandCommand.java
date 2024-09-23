package behavioral.command;
public class LandCommand implements Command {
    private Drone drone;

    public LandCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.land();
    }
}
