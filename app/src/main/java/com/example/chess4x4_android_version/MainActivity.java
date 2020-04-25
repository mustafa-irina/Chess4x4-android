package com.example.chess4x4_android_version;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> Messagers = new ArrayList<>();
    EditText messagerInLobby;
    Button sentInLobby;
    RecyclerView lobby;
    DataAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagerInLobby = (EditText) findViewById(R.id.messageInLobby);
        sentInLobby = (Button) findViewById(R.id.sentInLobby);

        test();

        lobby = (RecyclerView) findViewById(R.id.list);
        adapter = new DataAdapter(this, Messagers);
        lobby.setAdapter(adapter);
        //lobby.foreg   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//        adapter.notifyDataSetChanged();
//        lobby.post(new Runnable() {
//            final DataAdapter adapter1 = adapter;
//            @Override
//            public void run() {
//                lobby.smoothScrollToPosition(adapter1.getItemCount() - 1);
//            }
//        });
    }

    void test() {
        for (int i = 0; i < 100; i++) {
            Messagers.add(Integer.toString(i));
        }
    }


    public void sentInLobby(View view) {
        String equals = messagerInLobby.getText().toString();
        if (!equals.equals("")) {
            Messagers.add(messagerInLobby.getText().toString());
            messagerInLobby.setText("");
        }
        lobby.scrollToPosition(adapter.getItemCount() - 1);
    }

    public void Game2x2(View view) {
        Intent intent = new Intent(MainActivity.this, Game2x2.class);
        startActivity(intent);
    }
}
