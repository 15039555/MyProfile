package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float GPA = Float.parseFloat(etGPA.getText().toString());


        boolean trueOrFalse = false;
        if(ckbLike.isChecked()){
            trueOrFalse = true;
            }

        int pos = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA", GPA);
        prefEdit.putBoolean("TrueOrFalse", trueOrFalse);
        prefEdit.putInt("pos", pos);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName = prefs.getString("name", "");
        Float GPA = prefs.getFloat("GPA", 0);
        int pos = prefs.getInt("pos", 0);
        boolean trueOrFalse = prefs.getBoolean("TrueOrFalse", false);
        etName.setText(strName);
        etGPA.setText(GPA +"");
        ckbLike.setChecked(trueOrFalse);
        rgGender.check(pos);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName =(EditText) findViewById(R.id.editTextName);
        etGPA = (EditText) findViewById(R.id.editTextGPA);
        rgGender = (RadioGroup) findViewById(R.id.RadioGroupGender);
        ckbLike = (CheckBox) findViewById(R.id.checkBoxLIkeProgramming);


    }

}
