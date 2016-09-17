import java.awt.event.*;
import javax.swing.*;

public class TimerLoop {

	public static void runTimer() throws Exception {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ...Perform a task...

				if (SystemPropWindow.chckbxPing.isSelected()) {
					;
					System.out.println("Ping on state is selected.");
					Pinger.turnPingerOn();

				} else {
					Pinger.turnPingerOff();

					System.out.println("Ping on state is not selected.");
				}

			}
		};
		Timer timer = new Timer(100, taskPerformer);
		timer.setRepeats(true);
		timer.start();

		Thread.sleep(1000);
	}
}
