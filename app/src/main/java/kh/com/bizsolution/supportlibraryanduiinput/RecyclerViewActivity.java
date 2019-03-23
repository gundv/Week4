package kh.com.bizsolution.supportlibraryanduiinput;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecyclerViewActivity extends AppCompatActivity {


    // this list that will show the item
    RecyclerView rv;

    // the item that will render in the list as View
    JSONArray arr=new JSONArray();



    public FragmentText createFragment(){
        FragmentText fragmentText= new FragmentText();

        return fragmentText;
    }

    public void commitFragment(String text){
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentText fragmentText = createFragment();

        transaction.replace(R.id.container,fragmentText);
        transaction.addToBackStack(null);
        transaction.commit();


        //getSupportFragmentManager()
        //                .beginTransaction()
        //                .replace(R.id.container,fragmentText)
        //                .commit();

        transaction.remove(fragmentText);

        fragmentText.setText(text);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        try {

//bind the RecyclerView from XML to java activity
            rv=findViewById(R.id.recyclerview);

//Create Dummy JSONArray with the list of person name
            initArray();

//Using MyRecyclerViewAdapter to create adapter that use Current activity as the context and JSONArray arr
//as the binder and the data of the list
            MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(this,arr);

//To show all the item as in RecyclerView as the Horizontal or Vertical Scroll, we offer RecyclerView a layout manager
//to generate item in ListView
            LinearLayoutManager layoutManager=new LinearLayoutManager(this /*,LinearLayoutManager.HORIZONTAL, false*/);
            rv.setLayoutManager(layoutManager);

//Init Item decoration this item Decoration is generate margin in every item where in our case, we put 5dp as the margin in every item
//this method applied to every side of the item Marging Left,Right,Top, and Bottom

// TODO Uncomment two line below to see the different
//            ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.d5dp);
//            rv.addItemDecoration(itemDecoration);



            rv.setAdapter(adapter);



        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void initArray() throws JSONException{

            JSONObject people=new JSONObject();

            people.put("name","Mr. A");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. B");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. C");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. D");

            arr.put(people);people=new JSONObject();

            people.put("name","Mr. E");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. F");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. G");

            arr.put(people);
            people=new JSONObject();

            people.put("name","Mr. H");

            arr.put(people);


    }
    static class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

}
