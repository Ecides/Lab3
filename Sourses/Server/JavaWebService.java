import org.apache.xmlrpc.*;
public class JavaWebService
{
    public int fahrenheits(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static void main (String [] args) {
        try {
            System.out.println("Attempting to start XML-RPC Web Serviece...");
            WebServer server = new WebServer(8080);
            server.addHandler("sample",
            new JavaWebService());
            server.start();
            System.out.println("Started successfully.");
            System.out.println("Accepting requests");
        }
        catch (Exception exception) { System.err.println("Java Web Service: " + exception); }
    }
}