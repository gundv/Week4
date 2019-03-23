package kh.com.bizsolution.supportlibraryanduiinput;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentText extends Fragment {


    TextView textView;

    String text;
    public FragmentText(){

    }


    public void setText(final String text){
        this.text = text;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.layout_fragment_a,null);

        textView = view.findViewById(R.id.textview);
        textView.setText(this.text);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
