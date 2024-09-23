package behavioral.command;
public class TakeOffCommand implements Command {
    private Drone drone;

    public TakeOffCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.takeOff();
    }
}
