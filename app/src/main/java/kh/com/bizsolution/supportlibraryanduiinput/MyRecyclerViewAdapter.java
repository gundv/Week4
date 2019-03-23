package kh.com.bizsolution.supportlibraryanduiinput;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.Item> {


    private Context context;
    JSONArray arr;
    public  MyRecyclerViewAdapter(Context context, JSONArray arr){
        this.context=context;
        this.arr=arr;
    }

    /**
     *
     * @return the Size of array to for adapter to generate the item
     */

    @Override
    public int getItemCount() {
        return arr.length();
    }

    /**
     * This method create ViewHolder using LayoutInflater that inflate the View From layout resource folder
     * based current activity that we identified it as CONTEXT
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_view_item,null);

        return new Item(view);
    }

    /**
     * Binding ViewHolder to Adapter based on the position
     *
     * @param item is the ViewHolder where CardView is the item and TextView is the place where we
     *             assign the values, this Item was created in onCreateViewHolder
     * @param i is the index position in the array
     */

    @Override
    public void onBindViewHolder(@NonNull Item item, int i) {

        try{
            final JSONObject obj=arr.getJSONObject(i);
            item.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Toast.makeText(context,obj.getString("name"),Toast.LENGTH_LONG).show();

                        ((RecyclerViewActivity)context).commitFragment(obj.getString("name"));
                    }catch (Exception e){
                        Log.e("---->",e.getMessage()+"<--------");
                    }

                }
            });
            item.textView.setText(obj.getString("name"));
        }catch (Exception e){

        }



    }


    /**
     * this Item is extended from ViewHolder which is the static inner class of RecyclerView
     * Please make sure that the class is extended from this "RecyclerView.ViewHolder"
     * to avoid the error
     */
    static class Item extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        public Item(@NonNull View itemView) {
            super(itemView);
            cardView= itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.tvItem);
        }
    }
}
