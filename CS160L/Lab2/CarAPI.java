import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CarAPI {
    private static JSONObject jsonObject;

    // Helper function to get the JSONObject from the API call
    private static void makeAPICall(int year, String make, String model, String requestType) {
        try {
            // Construct the URL with query parameters
            String urlStr = "https://carapi.app/api/"+requestType +
                    "&verbose=yes&year="+year+"&make="+make.replace(" ", "%20")+"&model="+model.replace(" ", "%20");
            URL url = new URL(urlStr);

            // Open a connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get the response code
            int responseCode = conn.getResponseCode();
            //System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            // They need to add org.json to dependence
            // Parse the entire JSON response into a JSONObject
            jsonObject = new JSONObject(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the battery capacity of an electric car.
     * If the car has no battery capacity information, it returns null.
     *
     * @param year the year of the car
     * @param make the make of the car
     * @param model the model of the car
     * @return the battery capacity of the electric car, null if no capacity, or "hidden" if the year is not between 2015-2020
     *
     */
    public static double getBatteryCapacity(int year, String make, String model) {
        makeAPICall(year, make, model, "mileages?sort=battery_capacity_electric&direction=desc");
        // Get the Battery Capacity
        JSONArray listings = jsonObject.getJSONArray("data");
        JSONObject firstListing = listings.getJSONObject(0);
        double fuelTankCapacity = firstListing.getDouble("battery_capacity_electric");
        return fuelTankCapacity;
    }

    /**
     * Function to get the price of a car.
     *
     * @param year the year of the car
     * @param make the make of the car
     * @param model the model of the car
     * @return the price of the car, "hidden" if the year is not between 2015-2020, or null if no price information is available
     */
    public static double getCarPrice(int year, String make, String model){
        makeAPICall(year, make, model, "mileages?");
        // Get the price
        JSONArray listings = jsonObject.getJSONArray("data");
        JSONObject firstListing = listings.getJSONObject(0);
        JSONObject secondElement = firstListing.getJSONObject("make_model_trim");
        double price = secondElement.getDouble("msrp");
        return price;
    }

    /**
     * Function to get the fuel tank capacity of a car.
     *
     * @param year the year of the car
     * @param make the make of the car
     * @param model the model of the car
     * @return the fuel tank capacity of the car, "hidden" if the year is not between 2015-2020,
     * or null if no capacity information is available
     */
    public static double getFuelTankCapacity(int year, String make, String model){
        makeAPICall(year, make, model, "mileages?");
        JSONArray listings = jsonObject.getJSONArray("data");
        JSONObject firstListing = listings.getJSONObject(0);
        double fuelTankCapacity = firstListing.getDouble("fuel_tank_capacity");
        return fuelTankCapacity;
    }

    /**
     * Returns the engine type of a car.
     * Can be any string of these diesel, electric, electric (fuel cell),
     * flex-fuel (FFV), gas, hybrid, mild hybrid, natural gas (CNG), plug-in hybrid.
     * <p>
     * We only care about diesel, electric, gas
     *
     * @param year the year of the car
     * @param make the make of the car
     * @param model the model of the car
     * @return the engine type of the car, or null if no engine type information is available
     */
    public static String getCarType(int year, String make, String model){
        makeAPICall(year,make,model,"engines");
        JSONArray listings = jsonObject.getJSONArray("data");
        JSONObject firstListing = listings.getJSONObject(0);
        String engineType = firstListing.getString("engine_type");
        return engineType;
    }

}
