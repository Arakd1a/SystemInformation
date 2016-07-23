import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.io.*;
public class Sysprop {
//VARS===========================================================TEST	
	static File 			cDrive 				= new File("c:");
	static File 			dDrive 				= new File("d:");
	static String 			computerName		= null; 
	static String			ipAddress			= null;
	static String			osName				= null;
	static String			osVersion			= null;
	static String			userName			= null;
	static long				discTotalC			= 0;
	static long 			discFreeC			= 0;
	static long				discTotalD			= 0;
	static long 			discFreeD			= 0;
	static boolean			isInternetReachable = false;
	static String			connectionStatus 	= null;
//===============================================================	
public static void main(String[] args){	//                   MAIN
getSysinfo();
printSysinfo();
//TEST CONNECTION================================================
while (isInternetReachable == false ) {
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	getSysinfo();
	printSysinfo();
}
//==============================================================
}
public static void getSysinfo(){
	computerName 		= 	computerName		(computerName);
	ipAddress 			=	ipAddress			(ipAddress);
	osName				=	osName				(osName);
	osVersion			=	osVersion			(osVersion);
	userName			=	userName			(userName);	
	discTotalC			=	discTotalC			(discTotalC);
	discFreeC			=	discFreeC			(discFreeC);
	discTotalD			=	discTotalD			(discTotalD);
	discFreeD			=	discFreeD			(discFreeD);
	isInternetReachable	=	isInternetReachable	(isInternetReachable);
	connectionStatus 	=	connectionStatus 	(connectionStatus);
}	
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

public static boolean isInternetReachable(boolean isInternetReachable)

{
    try {
        //make a URL to a known source
        URL url = new URL("http://www.google.com");

        //open a connection to that source
        HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

        //trying to retrieve data from the source. If there
        //is no connection, this line will fail
        @SuppressWarnings("unused")
		Object objData = urlConnect.getContent();

    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }
    return true;
}

public static String connectionStatus(String connectionStatus ){
	
	isInternetReachable =	isInternetReachable (isInternetReachable);
	
	if ( isInternetReachable == false){; 
	connectionStatus = "Not Detected";
	return connectionStatus;}
	else{
		connectionStatus = "Detected";
	return connectionStatus;}
}

public static void printSysinfo(){
	System.out.println("[SYSTEM INFORMATION]");
	nl();
	System.out.println("Computer Name:\t\t "	+ computerName);
	System.out.println("IP Address:\t\t "		+ ipAddress);
	System.out.println("Logged On User:\t\t "	+ userName);
	System.out.println("Internet Connection?:\t "	+ connectionStatus );
	nl();
	nl();
	System.out.println("Drive C");
	System.out.println("Total Disc Space:\t "	+ discTotalC + " GB");
	System.out.println("\t"+discFreeC + " GB" 	+ " of " + discTotalC + " GB" +  " free");
	nl();
	nl();
	System.out.println("Drive D");
	System.out.println("Total Disc Space:\t "	+ discTotalD + " GB");
	System.out.println("\t"+discFreeD + " GB" 	+ " of " + discTotalD + " GB" +  " free");
}
	
public static void nl(){
	System.out.println("");
	}
}
