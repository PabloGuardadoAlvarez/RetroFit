package retrofitgerrit.vogella.com.retrofitgerrit;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static retrofitgerrit.vogella.com.retrofitgerrit.Controller.BASE_URL;

public interface GerritAPI {

    @GET("changes/")
    Call<List<Change>> loadChanges(@Query("q") String status);


    static GerritAPI create(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GerritAPI.class);
    }

}

