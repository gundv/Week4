package kh.com.bizsolution.supportlibraryanduiinput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySelector extends AppCompatActivity {


    private Button btnSp,btnSf,btnRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        btnSp = findViewById(R.id.sp);

        btnSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySelector.this,MainActivity.class);
                startActivity(intent);
            }
        });


        btnSf = findViewById(R.id.sf);
        btnSf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySelector.this,ActivityReadWriteFile.class);
                startActivity(intent);
            }
        });
        btnRv = findViewById(R.id.rv);
        btnRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySelector.this,RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
