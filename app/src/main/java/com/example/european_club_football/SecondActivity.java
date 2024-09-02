package com.example.european_club_football;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    public class Club{
        List<String>getInfo(String dis){
            List<String>info= new ArrayList<>();
            if(dis.equals("La-Liga")) {
                info.add("Barcelona");
                info.add("Real Madrid");
                info.add("Atletico de Madrid");
                info.add("Girona FC");
            }

            if(dis.equals("English Premier League")) {
                info.add("Liverpool");
                info.add("Manchester City");
                info.add("Manchester United");
                info.add("Chelsea");
            }

            if(dis.equals("Bundesliga")) {
                info.add("Bayern Munich");
                info.add("Borussia Dortmund");
                info.add("Bayer 04 Leverkusen");
                info.add("Wolfsburg");
            }

            if(dis.equals("Serie A")) {
                info.add("Juventus FC");
                info.add("AC Milan");
                info.add("Inter Milan");
                info.add("As Roma");
            }

            return info;
        }
    }
    private Club club = new Club();
    public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView info2 =(TextView)  findViewById(R.id.club_legacy);
        Intent intent = getIntent();
        String club_name = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.team);
        List<String> infoList =club.getInfo(club_name);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Top Club List");
        messageView .setText(infoFormatted);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}