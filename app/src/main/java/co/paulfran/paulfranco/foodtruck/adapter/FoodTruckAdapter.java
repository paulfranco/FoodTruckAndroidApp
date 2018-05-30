package co.paulfran.paulfranco.foodtruck.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.paulfran.paulfranco.foodtruck.R;
import co.paulfran.paulfranco.foodtruck.holder.FoodTruckHolder;
import co.paulfran.paulfranco.foodtruck.model.FoodTruck;

public class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckHolder>{

    private ArrayList<FoodTruck> trucks;

    public FoodTruckAdapter(ArrayList<FoodTruck> trucks) {
        this.trucks = trucks;
    }

    // Handle item on click events
    @Override
    public void onBindViewHolder(FoodTruckHolder holder, int position) {

        final FoodTruck truck = trucks.get(position);
        holder.updateUI(truck);

    }

    // Returns the number of items on our list
    @Override
    public int getItemCount() {
        return trucks.size();
    }

    @Override
    public FoodTruckHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View truckCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_foodtruck, parent, false);
        return new FoodTruckHolder(truckCard);
    }


}
