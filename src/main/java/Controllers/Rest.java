package Controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Rest {

  private static OkHttpClient client = new OkHttpClient();
  static String response1;

    public void getClient() throws IOException {
        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/country?name=" + HomePageController.countryResult() )
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "889076f26amsh71f18b14ec7f68bp1b70acjsn0e8f34826e4e")
                .build();

        Response response = client.newCall(request).execute();
        response.close();
        response1 = response.body().string();

//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String resp = response.body().string();
//            CountryDto cD = mapper.readValue(resp, CountryDto.class);
//        }
//        catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    static String getResponse1(){
        return response1;
    }
}
