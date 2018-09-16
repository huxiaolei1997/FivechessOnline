package com.example.mystery.fivechessonline;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mystery.fivechessonline.bean.ChessTable;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class HallActivity extends AppCompatActivity {
    private static final String TAG = HallActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        setupHall();
    }

    private void setupHall() {
        String url = "http://fivechess.tzchenyu.com/chess_table";
        final Request request = new Request.Builder().url(url).build();
        try {
            MainActivity.okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getApplicationContext(), "Error in get chess table", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String content = response.body().string();
                    Gson gson = new Gson();
                    final ChessTable[] checktables = gson.fromJson(content, ChessTable[].class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.hall);
                            LinearLayout oneLine = null;
                            for (int i = 0, length = checktables.length; i < length; i++) {
                                if (i % 2 == 0) {
                                    oneLine = new LinearLayout(getApplicationContext());
                                    oneLine.setOrientation(LinearLayout.HORIZONTAL);
                                    linearLayout.addView(oneLine);
                                }
                                View view = getLayoutInflater().inflate(R.layout.table, null);
                                view.findViewById(R.id.black).setBackground(ActivityCompat.getDrawable(getApplicationContext(), R.drawable.down));
                                view.findViewById(R.id.white).setBackground(ActivityCompat.getDrawable(getApplicationContext(), R.drawable.down));
                                oneLine.addView(view);
                            }
                        }
                    });

                }
            });
        } catch (Exception e) {
            Log.i("HallActivity Exception ", e.getMessage());
        }
    }

}
