import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {

		if (!OneInstance.lock()) {
			System.out.println(
					"Cannot launch application. Check that no other instance is running and if so, delete the file syslock.lock");
			return;
		}
		TimerLoop.runTimer();
		Tray.runTray();
		ServerMain.run();

		Pinger Pinger = new Pinger();
		pingLooper();
	

	}

	
	public static void pingLooper(){
		
		if (Pinger.isPingerOn==true){
		do {
			Toolbox.sleep();
			Pinger.netIsAvailable();
			System.out.println("Connection status: " + Pinger.netIsAvailable);
			}
			while (Pinger.isPingerOn==true);
					
		}
		else {pingLooper();}
	}
	
}
