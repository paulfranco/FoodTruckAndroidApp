package co.paulfran.paulfranco.foodtruck.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.paulfran.paulfranco.foodtruck.R;
import co.paulfran.paulfranco.foodtruck.model.FoodTruck;

public class FoodTruckListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck_list);

        String url = "http://seattleapi.com/api/v1/foodtruck";
        final ArrayList<FoodTruck> foodTruckList = new ArrayList<>();

        // Sending a JSON Array Request with Volley
        final JsonArrayRequest getTrucks = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response.toString());

                try {
                    JSONArray foodTrucks = response;
                    for (int x = 0; x < foodTrucks.length(); x++) {
                        JSONObject foodTruck = foodTrucks.getJSONObject(x);
                        String name = foodTruck.getString("name");
                        String id = foodTruck.getString("_id");
                        String foodType = foodTruck.getString("foodType");
                        Double avgCost = foodTruck.getDouble("avgcost");

                        JSONObject geometry = foodTruck.getJSONObject("geometry");
                        JSONObject coordinatees = geometry.getJSONObject("coordinates");

                        Double latitude = coordinatees.getDouble("lat");
                        Double longitude = coordinatees.getDouble("long");

                        FoodTruck newFoodTruck = new FoodTruck(id, name, foodType, avgCost, latitude, longitude);

                        foodTruckList.add(newFoodTruck);
                    }
                } catch (JSONException e){
                    Log.v("JSON", "EXC" + e.getLocalizedMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("API", "ERR" + error.getLocalizedMessage());
            }
        });

        Volley.newRequestQueue(this).add(getTrucks);


    }
}
