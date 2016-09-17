import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Pinger {

	public static boolean isPingerOn = true;
	public static boolean netIsAvailable = true;

	public boolean isPingerOn() {
		while (SystemPropWindow.chckbxPing.isSelected())
		{
			isPingerOn = true;	
		return isPingerOn;
		} 
	{
			isPingerOn = false;	
		return isPingerOn;
		}
	}

	public static boolean turnPingerOn() {
		isPingerOn = true;
		return isPingerOn;

	}

	public static boolean turnPingerOff() {
		isPingerOn = false;
		return isPingerOn;
	}

	public static boolean netIsAvailable() {

		System.out.println("Pinging...");

		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			netIsAvailable = true;
			return netIsAvailable;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			netIsAvailable = false;
			return netIsAvailable;

		}

	}

}
