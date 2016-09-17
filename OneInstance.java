import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.nio.channels.FileLock;

public class OneInstance {

	public static boolean lock() {
		try {
			final File file = new File("syslock.lock");
			if (file.createNewFile()) {
				file.deleteOnExit();
				return true;
			}
			return false;
		} catch (IOException e) {
			return false;
		}
		
	}

}
