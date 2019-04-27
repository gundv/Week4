package kh.com.bizsolution.supportlibraryanduiinput;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivitySelector extends AppCompatActivity {


//    private Button btnSp,btnSf,btnRv;

    private TextView txtString;
    private ImageView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

//        btnSp = findViewById(R.id.sp);
//
//        btnSp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivitySelector.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        btnSf = findViewById(R.id.sf);
//        btnSf.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivitySelector.this,ActivityReadWriteFile.class);
//                startActivity(intent);
//            }
//        });
//        btnRv = findViewById(R.id.rv);
//        btnRv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivitySelector.this,RecyclerViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//
        webView = findViewById(R.id.htmlView);
        txtString = findViewById(R.id.reposnseString);


        final StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://api.domloung.com/api/movie/front/home" +
                        "?api=RV2GJd63iDNB3FcdQ46eiruQkFCwrkWtP9559WDvvmZA8cpeKHmiLCcdx9BX",
                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    Log.e("onResponse",obj.toString());
                    JSONArray jsonArray=obj.getJSONArray("data");
                    Log.e("onResponse",jsonArray.toString());
                    txtString.setText(jsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage()+"");
            }
        });
        MyApplication.addToQueue(request);

        MyApplication.loader.get(
                "https://i.ytimg.com/vi/-m6UKS1L0YQ/maxresdefault.jpg"
                , new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response
                    , boolean isImmediate) {
                webView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



    }
}
