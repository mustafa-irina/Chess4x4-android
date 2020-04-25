package com.example.chess4x4_android_version;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Game2x2 extends AppCompatActivity {
    FrameLayout MyGame;
    LinearLayout layoutR;
    FrameLayout BrotherGame;
    RecyclerView lobby;
    DataAdapter adapter;
    List<String> Messagers = new ArrayList<>();
    EditText messagerInLobby;
    Button sentInLobby;
    int halfDisplay;
    int MaxSizeMessage;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2x2);

        messagerInLobby = (EditText) findViewById(R.id.sendEdit);
        sentInLobby = (Button) findViewById(R.id.sendgame);

        //test();

        lobby = (RecyclerView) findViewById(R.id.listGame);
        adapter = new DataAdapter(this, Messagers);
        lobby.setAdapter(adapter);
        lobby.setHasFixedSize(true);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int newH = (int) Math.floor(width / 2);
        MyGame = (FrameLayout) findViewById(R.id.myGame);
        MyGame.setMinimumWidth(newH);
        layoutR = (LinearLayout) findViewById(R.id.layoutGameB);
        layoutR.setMinimumWidth(newH);


        int sizeSymbol = this.getResources().getDimensionPixelSize(R.dimen.messageinchat);
        halfDisplay = newH;
        MaxSizeMessage = (int) Math.floor(halfDisplay / sizeSymbol - 3);
    }

    void test() {
        for (int i = 0; i < 100; i++) {
            Messagers.add(Integer.toString(i));
        }
    }

    public void sendGame2x2(View view) {
        String equals = messagerInLobby.getText().toString();
        int sizeText = (int) equals.length();
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)lobby.getLayoutParams();
//        int w = (int) params.weight;

//        if (MaxSizeMessage < sizeText) {
//            equals = this.correctionMessage(equals);
//        }

        if (!equals.equals("")) {
            Messagers.add(equals);
            messagerInLobby.setText("");
        }
        lobby.scrollToPosition(adapter.getItemCount() - 1);
//        params.weight = w--;
//        lobby.setLayoutParams(params);
    }

    public String correctionMessage (String message) {
        String [] arrayWords = message.split(" ");
        message = "";
        String line = "";
        String stock;
        for (int i = 0; i < arrayWords.length; i++) {
            if (line.length() + arrayWords[i].length() + 1 > MaxSizeMessage) {
                if (line.length() != 0) {
                    message = message.concat(line).concat("\n");
                    line = "";
                }
                if (arrayWords[i].length() > MaxSizeMessage) {
                    line = line.concat(arrayWords[i].substring(0, MaxSizeMessage - 1));
                    stock = correctionMessage(arrayWords[i].substring(MaxSizeMessage));
                    message = message.concat(line).concat("\n");
                    line = stock;
                } else {
                    line = line.concat(arrayWords[i]);
                }
            } else {
                if (line.length() != 0) {
                    line = line.concat(" ").concat(arrayWords[i]);
                } else { line = line.concat(arrayWords[i]); }

            }

        }
        message = message.concat(line);
        return message;
    }
}
