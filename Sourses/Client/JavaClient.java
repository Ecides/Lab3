import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;

public class JavaClient {
    public static void main(String[] args) {
        try {
            XmlRpcClient server = new XmlRpcClient("http://localhost:8080");
            Vector<Integer> params = new Vector<>();
            int celsius = 0;

            // Перевірка, чи передані аргументи
            if (args.length >= 1) {
                try {
                    celsius = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Помилка: Невірний формат числа. Використовується значення за замовчуванням (0°C).");
                }
            } else {
                System.out.println("Аргументи не передані. Використовується значення за замовчуванням (0°C).");
            }

            params.addElement(celsius);
            Object result = server.execute("sample.fahrenheits", params);
            int fahrenheits = ((Integer) result).intValue();
            System.out.println("Температура у Фаренгейтах: " + fahrenheits);
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}