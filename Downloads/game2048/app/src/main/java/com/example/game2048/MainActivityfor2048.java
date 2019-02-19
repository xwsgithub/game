package com.example.game2048;

import android.content.SharedPreferences.Editor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.view.WindowManager;


public class MainActivityfor2048 extends AppCompatActivity {


    private Button reset;

    public MainActivityfor2048(){
        mainActivity=this;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //去掉顶部标题
        getSupportActionBar().hide();
//去掉最上面时间、电量等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfor2048);
        sp=getSharedPreferences("TopScore",0);
        editor=sp.edit();

        tvScore=findViewById(R.id.tvScore);
        tvBestScore=findViewById(R.id.tvbestscore);
        tvScore.setText("0");
        tvScore.setTextSize(25);
        tvScore.setTextColor(0xfff5f5f5);

        reset=findViewById(R.id.textView3);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameViewfor2048.getGameview().startGame();

            }
        });



    }

    private GameViewfor2048 game;
    private int Score=0;

    private TextView tvScore;
    private TextView tvBestScore;
    private SharedPreferences sp;
    private Editor editor;


    private static MainActivityfor2048 mainActivity=null;

    public void showScore(){
        tvScore.setText(Score+"");
        tvScore.setTextSize(25);
        tvScore.setTextColor(0xfff5f5f5);

        tvBestScore.setText(sp.getInt("Best",0)+"");
        tvBestScore.setTextSize(25);
        tvBestScore.setTextColor(0xfff5f5f5);
    }

    public void addScore(int s){
        Score+=s;
        if(Score>sp.getInt("Best",0)){
            editor.putInt("Best",Score);
            editor.commit();
        }
        showScore();
    }

    public void clearScore(){
        if(Score!=0){
            Score=0;
            showScore();
        }
    }
    public static MainActivityfor2048 getMainActivity(){
        return mainActivity;
    }


}
