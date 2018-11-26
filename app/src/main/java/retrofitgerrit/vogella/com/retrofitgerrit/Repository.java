package retrofitgerrit.vogella.com.retrofitgerrit;

import retrofit2.Call;
import retrofit2.http.Query;

import java.util.List;

class Repository   {
    private static volatile Repository ourInstance = new Repository();

     static Repository getInstance() {
    if (ourInstance == null){
            synchronized (Repository.class){
                if (ourInstance == null) {
                    ourInstance = new Repository();
                }
            }
        }
        return ourInstance;
    }

     private Repository() {
     }


    private GerritAPI apiService = GerritAPI.create();


     public Call<List<Change>> getGerrits(String query){
         return apiService.loadChanges(query);
     }

}
