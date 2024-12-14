import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;

public class JavaClient {
    public static void main(String[] args) {
        try {
            XmlRpcClient server = new XmlRpcClient("http://localhost:8080");
            Vector<Integer> params = new Vector<>();
            int a = 2, b = 3;

            // Check if arguments are provided
            if (args.length >= 2) {
                try {
                    a = Integer.parseInt(args[0]);
                    b = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number format. Using default values (a=2, b=3).");
                }
            } else {
                System.out.println("No arguments provided. Using default values (a=2, b=3).");
            }

            params.addElement(a);
            params.addElement(b);
            Object result = server.execute("sample.sum", params);
            int sum = ((Integer) result).intValue();
            System.out.println("The sum is: " + sum);
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}