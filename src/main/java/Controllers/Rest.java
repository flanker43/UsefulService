package Controllers;

import Dto.CountryDto;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Rest {

    private static OkHttpClient client = new OkHttpClient();
    private static ObjectMapper mapper = new ObjectMapper();

    public CountryDto getClient() throws IOException {
        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/country?name=" + HomePageController.countryResult())
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "889076f26amsh71f18b14ec7f68bp1b70acjsn0e8f34826e4e")
                .build();

        Response response = client.newCall(request).execute();


        try {
            String resp = response.body().string();
            response.close();
            List<CountryDto> cD = Arrays.asList(mapper.readValue(resp, CountryDto[].class));
            for (int i = 0; i<cD.size(); i++){
                return cD.get(i);
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
