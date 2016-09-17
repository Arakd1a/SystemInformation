import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class GetProp {
	
	
static File cDrive = new File("c:");
static File dDrive = new File("d:");
static String computerName = null; 
static String ipAddress	= null;
static String osName = null;
static String osVersion	= null;
static String userName = null;
static long	discTotalC = 0;
static long discFreeC = 0;
static long	discTotalD = 0;
static long discFreeD = 0;
static boolean isInternetReachable = false;
static String connectionStatus 	= null;
	
	
public static String computerName(String computerName ){
		try {
		computerName	=	InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			
		System.out.println("Error Finding Hostname");
		
		}
		return computerName;
}

public static String ipAddress(String ipAddress ){
	try {
		ipAddress	=	InetAddress.getLocalHost().getHostAddress();
	} catch (UnknownHostException e) {
		
	System.out.println("Error Finding IP Address");
	
	}
	return ipAddress;
}

public static String osName(String osName ){
		osName	=	System.getProperty("os.name");
		return osName;
}

public static String osVersion(String osVersion ){
	osVersion	=	System.getProperty("os.version");
	return osVersion;
}

public static String userName(String userName ){
	userName	=	System.getProperty("user.name");
	return userName;
}

public static Long discTotalC(Long discTotalC ){
	discTotalC	=	cDrive.getTotalSpace();
	discTotalC	=	discTotalC /1024 /1024 /1024;
	return discTotalC;
}

public static Long discFreeC(Long discFreeC ){
	discFreeC	=	cDrive.getFreeSpace();
	discFreeC	=	discFreeC /1024 /1024 /1024;
	return discFreeC;
}

public static Long discTotalD(Long discTotalD ){
	discTotalD	=	cDrive.getTotalSpace();
	discTotalD	=	discTotalD /1024 /1024 /1024;
	return discTotalD;
}

public static Long discFreeD(Long discFreeD ){
	discFreeD	=	cDrive.getFreeSpace();
	discFreeD	=	discFreeD /1024 /1024 /1024;
	return discFreeD;
}
	

}
