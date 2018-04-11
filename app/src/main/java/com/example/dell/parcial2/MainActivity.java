package com.example.dell.parcial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Spinner source;
    Spinner destination;
    AppCompatButton btn_convert;
    String values [] = new String[5];
    TextView from_api;
    TextView txt_result;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set spinner values
        values[0] = "";
        values[1] = "Binario";
        values[2] = "Octal";
        values[3] = "Hexadecimal";
        values[4] = "Decimal";
        txt_result = (TextView) findViewById(R.id.txt_result);
        number = (EditText) findViewById(R.id.number);

        //load values to spinners
        setValues();
        //convert acction
        btn_convert = (AppCompatButton) findViewById(R.id.btn_convert);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result();
            }
        });

    }



    //setear valores a la lista
    public void setValues(){
        List<String> spinnerArray =  new ArrayList<String>();
        for(String val : values){
            spinnerArray.add(val.toUpperCase());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        source = (Spinner) findViewById(R.id.source);
        from_api = (TextView) findViewById(R.id.from_api);
        destination = (Spinner) findViewById(R.id.destination);
        source.setAdapter(adapter);
        destination.setAdapter(adapter);
    }

        //calcular resultados
    public void result(){
        if(source.getSelectedItem() != null && source.getSelectedItem() != ""  && destination.getSelectedItem() != null && destination.getSelectedItem() != "" ){
            String src = source.getSelectedItem().toString();
            String dst = destination.getSelectedItem().toString();
            Toast.makeText(MainActivity.this, "Source: " + src + " Destination: " + dst + " Value: "+ number.getText().toString(), Toast.LENGTH_SHORT).show();
            txt_result.setText("Source: " + src + " Destination: " + dst + " Value: "+ number.getText().toString());
            Log.e("Aqui", src);
            Log.e("Aqui", dst);

            //hacer proceso
        }else{
            Toast.makeText(MainActivity.this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para conectar api
    public void getDataFromApi() {
     /*   ApiClient.getClient().posts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBodyResponse -> {
                    try {
                        if(responseBodyResponse.code() == 200){
                           // JSONObject response = new JSONObject(new String(responseBodyResponse.body().bytes()));
                            //int id = response..getInt("userId");
                            String bd = responseBodyResponse.body().bytes().toString();
                            from_api.setText("id:  body: " + bd);
                            //Toast.makeText(MainActivity.this, (new String(responseBodyResponse.body().bytes())), Toast.LENGTH_SHORT).show();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (JSONException f ){
                        f.printStackTrace();
                    }
                });
*/


    }



}
