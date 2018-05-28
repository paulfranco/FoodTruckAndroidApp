package co.paulfran.paulfranco.foodtruck.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import co.paulfran.paulfranco.foodtruck.holder.FoodTruckHolder;

public class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckHolder>{

    // Handle item on click events
    @Override
    public void onBindViewHolder(@NonNull FoodTruckHolder holder, int position) {

    }

    // Returns the number of items on our list
    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public FoodTruckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


}
