import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_KEY = "5efbf3a444896b6b223df8cb"; // Replace with your API key
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        if (exchangeRate != -1) {
            double convertedAmount = amount * exchangeRate;
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Error fetching exchange rate.");
        }

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            @SuppressWarnings("deprecation")
            JsonParser jp = new JsonParser();
            @SuppressWarnings("deprecation")
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            if (jsonobj.get("result").getAsString().equals("success")) {
                JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
                return conversionRates.get(targetCurrency).getAsDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
