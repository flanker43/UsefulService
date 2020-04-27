package Controllers;

import Dto.CountryDto;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Rest {

    private static OkHttpClient client = new OkHttpClient();
    //  static String response1;
    static String country1;
    static long confirmed1;
    static long recovered1;
    static long critical1;
    static long deaths1;
    static double latitude1;
    static double longitude1;

    public void getClient() throws IOException {
        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/country?name=" + HomePageController.countryResult())
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "889076f26amsh71f18b14ec7f68bp1b70acjsn0e8f34826e4e")
                .build();

        Response response = client.newCall(request).execute();
        response.close();
//        response1 = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String resp = response.body().string();
            CountryDto cD = mapper.readValue(resp, CountryDto.class);
            System.out.println(cD);
            country1 = cD.getCountry();
            confirmed1 = cD.getConfirmed();
            recovered1 = cD.getRecovered();
            critical1 = cD.getCritical();
            deaths1 = cD.getDeaths();
            latitude1 = cD.getLatitude();
            longitude1 = cD.getLongitude();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    static String getResponse1(){
//        return response1;
//    }
}
