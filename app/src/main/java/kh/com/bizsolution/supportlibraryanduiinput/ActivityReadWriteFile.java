package kh.com.bizsolution.supportlibraryanduiinput;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ActivityReadWriteFile extends AppCompatActivity {


    EditText edtRtf;
    private Button btnSave,btnRead;
    private TextView readtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_file);

        int read=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE);
        int write=ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if(read!=PackageManager.PERMISSION_GRANTED&&write!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},120);
        }

        edtRtf = findViewById(R.id.edtRtf);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        readtext= findViewById(R.id.readedText);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeFile(ActivityReadWriteFile.this,"richtext",edtRtf.getText().toString());
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fileExisted(ActivityReadWriteFile.this,"richtext")){
                    String textFromFile = readFile(ActivityReadWriteFile.this,"richtext");
                    readtext.setText(textFromFile);
                }else {
                    readtext.setText("File is not exist");
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"READ File Granted",Toast.LENGTH_LONG).show();
        }
        if (grantResults[1]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Write File Granted",Toast.LENGTH_LONG).show();
        }
    }

    public static void writeFile(final Context context, String filename, String text) {
        try {
            // Stream to write file
            File file = getFile(context, filename);
            Writer out = new BufferedWriter
                    (new OutputStreamWriter
                            (new FileOutputStream(file /*,true*/), "UTF-8"));

            out.write(text);

            out.close();

        } catch (Exception e) {
            //Log.e("error save text", e.getMessage() + "-");
        }
    }

    public static String readFile(final Context context, String filename) {
        String text = "";
        try {
            File file = getFile(context, filename);
            if (file.exists()) {
                // Stream to read file
                FileInputStream fin = new FileInputStream(file);
                Reader reader = new InputStreamReader(fin, "UTF-8");
                BufferedReader br = new BufferedReader(reader);
                final StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line.trim());
                }
                br.close();
                fin.close();

                text = sb.toString();

            }
        } catch (Exception e) {

        }
        return text;
    }

    public static File getFile(final Context context, String filename) {
//        return new File(context.getFilesDir(), filename);
        return new File(context.getExternalCacheDir(), filename);
    }

    public static boolean fileExisted(Context context,String fileName){
        return getFile(context,fileName).exists();
    }
    public static boolean removeFile(final Context context,final String fileName){
        return  getFile(context,fileName).delete();
    }
}
