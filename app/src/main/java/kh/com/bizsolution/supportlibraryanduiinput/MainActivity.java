package kh.com.bizsolution.supportlibraryanduiinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {



    private RadioGroup rgd;
    private LinearLayout chkGrp;
    private Spinner spinner;

    private Switch aSwitch1,aSwitch2;
    private ToggleButton tb1,tb2;

    String[] array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgd= findViewById(R.id.rdg);
        rgd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdo1:
                        showToast("radio 1");
                        break;
                    case R.id.rdo2:
                        showToast("radio 2");
                        break;
                    case R.id.rdo3:
                        showToast("radio 3");
                        break;
                    case R.id.rdo4:
                        showToast("radio 4");
                        break;
                    case R.id.rdo5:
                        showToast("radio 5");
                        break;
                    default:
                        showToast("I don't know");
                        break;
                }
            }
        });

       array= getResources().getStringArray(R.array.spinner_item);

        chkGrp=findViewById(R.id.chkGroup);

        for (int i=0;i<chkGrp.getChildCount();++i){
            CheckBox chk= (CheckBox) chkGrp.getChildAt(i);
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    showToast(buttonView.getText()+" is "+isChecked);
                }
            });
        }

        spinner=findViewById(R.id.spinner1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showToast(array[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aSwitch1 = findViewById(R.id.switch1);
        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
            }
        });
        aSwitch2 = findViewById(R.id.switch2);
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
            }
        });


        tb1 = findViewById(R.id.toggle1);
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
            }
        });


        tb2 = findViewById(R.id.toggle1);

        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
