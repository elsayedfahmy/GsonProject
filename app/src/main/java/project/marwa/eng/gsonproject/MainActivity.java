package project.marwa.eng.gsonproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import project.marwa.eng.gsonproject.model.Weather;
import project.marwa.eng.gsonproject.model.WeatherModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertJavaToJson();

    }
    public void convertJavaToJson(){
        Weather w = new Weather();
        w.setMain("main");
        w.setDescription("Desc");
        w.setIcon("icon");
        w.setId(123);


        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(w);

        WeatherModel weatherModel = new WeatherModel();
        weatherModel.setId(1);
        weatherModel.setWeather(weatherList);
        weatherModel.setBase("base");
        weatherModel.setName("Name");


        Gson gson = new Gson();
        String s = gson.toJson(weatherModel);
        Log.i("json",s);
    }
    public void parseJsonToJava(){
        String json="{\"coord\":{\"lon\":31.38,\"lat\":31.04},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":306.816,\"pressure\":1025.12,\"humidity\":43,\"temp_min\":306.816,\"temp_max\":306.816,\"sea_level\":1026.16,\"grnd_level\":1025.12},\"wind\":{\"speed\":4.93,\"deg\":344.001},\"clouds\":{\"all\":0},\"dt\":1472382701,\"sys\":{\"message\":0.0024,\"country\":\"EG\",\"sunrise\":1472354921,\"sunset\":1472401306},\"id\":360761,\"name\":\"Al Mansurah\",\"cod\":200}";
        Log.i("json",json);

        Gson gson = new Gson();
        WeatherModel weatherModel = gson.fromJson(json, WeatherModel.class);
        Log.i("weatherModel",weatherModel.getName());
        List<Weather> weatherList = weatherModel.getWeather();
        for(Weather weather :weatherList){
            Log.i("weather",weather.getDescription());

        }
    }
}
