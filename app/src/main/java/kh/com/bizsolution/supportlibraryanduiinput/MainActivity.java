package kh.com.bizsolution.supportlibraryanduiinput;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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

    SharedPreferences myPreference;

    private SharedPreferences.Editor sharedPreferenceEditor;


    private final String RADIO_GRP = "radiogroup";
    private final String CHK_BOX1 = "CHK_BOX1";
    private final String CHK_BOX2 = "CHK_BOX2";
    private final String CHK_BOX3 = "CHK_BOX3";
    private final String SPINNER = "Spinner";
    private final String SW1 = "sw1";

    private final String SW2 = "sw2";
    private final String TGL1 = "TGL1";
    private final String TGL2 = "TGL2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myPreference=getSharedPreferences("MainActivity",Context.MODE_PRIVATE);











        sharedPreferenceEditor=myPreference.edit();

        rgd= findViewById(R.id.rdg);

        int rgdIndex = myPreference.getInt(RADIO_GRP,0);

        ((RadioButton)rgd.getChildAt(rgdIndex)).setChecked(true);


        rgd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdo1:
                        showToast("radio 1");
                        sharedPreferenceEditor.putInt(RADIO_GRP,0);
                        sharedPreferenceEditor.apply();
                        break;
                    case R.id.rdo2:
                        showToast("radio 2");
                        sharedPreferenceEditor.putInt(RADIO_GRP,1);
                        sharedPreferenceEditor.apply();
                        break;
                    case R.id.rdo3:
                        showToast("radio 3");
                        sharedPreferenceEditor.putInt(RADIO_GRP,2);
                        sharedPreferenceEditor.apply();
                        break;
                    case R.id.rdo4:
                        showToast("radio 4");
                        sharedPreferenceEditor.putInt(RADIO_GRP,3);
                        sharedPreferenceEditor.apply();
                        break;
                    case R.id.rdo5:
                        showToast("radio 5");
                        sharedPreferenceEditor.putInt(RADIO_GRP,4);
                        sharedPreferenceEditor.apply();
                        break;
                    default:
                        showToast("I don't know");
                        break;
                }
            }
        });

       array= getResources().getStringArray(R.array.spinner_item);

        chkGrp=findViewById(R.id.chkGroup);
        boolean chk1 = myPreference.getBoolean(CHK_BOX1,false);
        ((CheckBox)findViewById(R.id.chk1)).setChecked(chk1);

        boolean chk2 = myPreference.getBoolean(CHK_BOX2,false);
        ((CheckBox)findViewById(R.id.chk2)).setChecked(chk2);

        boolean chk3 = myPreference.getBoolean(CHK_BOX3,false);
        ((CheckBox)findViewById(R.id.chk3)).setChecked(chk3);




        for (int i=0;i<chkGrp.getChildCount();++i){
            CheckBox chk= (CheckBox) chkGrp.getChildAt(i);
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(buttonView.getId()==R.id.chk1){
                        sharedPreferenceEditor.putBoolean(CHK_BOX1,isChecked);
                        sharedPreferenceEditor.apply();
                    }else if(buttonView.getId()==R.id.chk2){
                        sharedPreferenceEditor.putBoolean(CHK_BOX2,isChecked);
                        sharedPreferenceEditor.apply();
                    }else{
                        sharedPreferenceEditor.putBoolean(CHK_BOX3,isChecked);
                        sharedPreferenceEditor.apply();
                    }


                    showToast(buttonView.getText()+" is "+isChecked);
                }
            });
        }

        spinner=findViewById(R.id.spinner1);


        int spinnerIdx=myPreference.getInt(SPINNER,0);
        spinner.setSelection(spinnerIdx);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showToast(array[position]);
                sharedPreferenceEditor.putInt(SPINNER,position);
                sharedPreferenceEditor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aSwitch1 = findViewById(R.id.switch1);

        boolean sw1=myPreference.getBoolean(SW1,false);
        aSwitch1.setChecked(sw1);



        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
                sharedPreferenceEditor.putBoolean(SW1,isChecked);
                sharedPreferenceEditor.apply();
            }
        });
        aSwitch2 = findViewById(R.id.switch2);
        boolean sw2=myPreference.getBoolean(SW2,false);
        aSwitch2.setChecked(sw2);
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
                sharedPreferenceEditor.putBoolean(SW2,isChecked);
                sharedPreferenceEditor.apply();
            }
        });


        tb1 = findViewById(R.id.toggle1);
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
                sharedPreferenceEditor.putBoolean(TGL1,isChecked);
                sharedPreferenceEditor.apply();
            }
        });


        tb2 = findViewById(R.id.toggle2);

        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToast(buttonView.getText()+" is now "+(isChecked?"checked":"unchecked"));
                sharedPreferenceEditor.putBoolean(TGL2,isChecked);
                sharedPreferenceEditor.apply();

            }
        });
        boolean tbv1=myPreference.getBoolean(TGL1,false);
        tb1.setChecked(tbv1);

        boolean tbv2=myPreference.getBoolean(TGL2,false);
        tb2.setChecked(tbv2);
    }

    private void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
