package behavioral.command;
public class CommandPatternDemo {
    public static void main(String[] args) {
        Drone drone = new Drone();

        Command takeOff = new TakeOffCommand(drone);
        Command land = new LandCommand(drone);
        Command capturePhoto = new CapturePhotoCommand(drone);

        DroneCommandDispatcher dispatcher = new DroneCommandDispatcher();
        
        dispatcher.executeCommand(takeOff);
        dispatcher.executeCommand(capturePhoto);
        dispatcher.executeCommand(land);
    }
}
