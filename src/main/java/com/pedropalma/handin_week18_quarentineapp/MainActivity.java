package com.pedropalma.handin_week18_quarentineapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Covid19Api covid19Api = retrofit.create(Covid19Api.class);
        Call<List<Post>> call = covid19Api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    String content = "";
                    content += "Country: " + post.getCountry() + "\n";
                    content += "Country Code: " + post.getCountryCode() + "\n";
                    content += "New Confirmed: " + post.getNewConfirmed() + "\n";
                    content += "Total Confirmed: " + post.getTotalConfirmed() + "\n";
                    content += "New Deaths: " + post.getNewDeaths() + "\n";
                    content += "Total Deaths: " + post.getTotalDeaths() + "\n";
                    content += "New Recovered: " + post.getNewRecovered() + "\n";
                    content += "Total Recovered: " + post.getTotalRecovered() + "\n";
                    content += "Date: " + post.getDate() + "\n\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
