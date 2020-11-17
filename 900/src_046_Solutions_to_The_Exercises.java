import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

import book.javamvc.mydatetimeejb.
      interfaces.MyDateTimeRemote;

public class Client {
  public static void main(String[] args) {	  	
    String remoteServerHost = "localhost";
    String remoteServerPort = "3700";
    Properties props = new Properties();
    props.setProperty("java.naming.factory.initial", 
      "com.sun.enterprise.naming." + 
      "SerialInitContextFactory");
    props.setProperty("java.naming.factory.url.pkgs", 
      "com.sun.enterprise.naming");
    props.setProperty("java.naming.factory.state",
      "com.sun.corba.ee.impl.presentation.rmi." + 
      "JNDIStateFactoryImpl");
    props.setProperty("org.omg.CORBA.ORBInitialHost", 
      remoteServerHost);
    props.setProperty("org.omg.CORBA.ORBInitialPort", 
      remoteServerPort);
    try {
      InitialContext ic = new InitialContext(props);
      MyDateTimeRemote testEJB = (MyDateTimeRemote)
        ic.lookup("book.javamvc.mydatetimeejb."+
                  "interfaces.MyDateTimeRemote");
      System.out.println(testEJB.date(
            "yyyy-MM-dd HH:mm:ss"));
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}
