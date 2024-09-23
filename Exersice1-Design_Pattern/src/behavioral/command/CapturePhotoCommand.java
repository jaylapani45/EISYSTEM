package behavioral.command;
public class CapturePhotoCommand implements Command {
    private Drone drone;

    public CapturePhotoCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.capturePhoto();
    }
}
