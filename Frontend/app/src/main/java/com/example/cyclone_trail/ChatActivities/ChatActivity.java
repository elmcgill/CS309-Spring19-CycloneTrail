package com.example.cyclone_trail.ChatActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cyclone_trail.CreateUserActivity;
import com.example.cyclone_trail.GameBoardActivity;
import com.example.cyclone_trail.LoginActivity;
import com.example.cyclone_trail.R;
import com.example.cyclone_trail.globals.GlobalVars;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    /*private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;*/
    private WebSocketClient cc;
    //List messageList = new ArrayList();

    Button  btn_back, btn_send;
    EditText userMessage;
    TextView chatView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        /*mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));*/

        btn_back = findViewById(R.id.btn_back);
        btn_send = findViewById(R.id.btn_send);
        userMessage = findViewById(R.id.userMessage);
        chatView = findViewById(R.id.chatView);


        btn_back.setOnClickListener(this);
        btn_send.setOnClickListener(this);

        Draft[] drafts = {new Draft_6455()};

        /**
         * If running this on an android device, make sure it is on the same network as your
         * computer, and change the ip address to that of your computer.
         */
        String w = "ws://cs309-vc-4.misc.iastate.edu:8080/socket/"+ GlobalVars.username;

        try {
            Log.d("Socket:", "Trying socket");
            cc = new WebSocketClient(new URI(w),(Draft) drafts[0]) {
                @Override
                public void onMessage(String message) {
                    Log.d("", "run() returned: " + message);
                    String s=chatView.getText().toString();
                    //t1.setText("hello world");
                    //Log.d("first", "run() returned: " + s);
                    //s=t1.getText().toString();
                    //Log.d("second", "run() returned: " + s);
                    chatView.setText(s+message);
                }

                @Override
                public void onOpen(ServerHandshake handshake) {
                    Log.d("OPEN", "run() returned: " + "is connecting");
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.d("CLOSE", "onClose() returned: " + reason);
                }

                @Override
                public void onError(Exception e)
                {
                    Log.d("Exception:", e.toString());
                }
            };
        }
        catch (URISyntaxException e) {
            Log.d("Exception:", e.getMessage());
            e.printStackTrace();
        }
        cc.connect();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_send:
                try {
                    cc.send(userMessage.getText().toString() + "\n");
                    userMessage.setText("");
                }
                catch (Exception e)
                {
                    Log.d("ExceptionSendMessage:", e.getMessage().toString());
                }
                break;
            default:
                break;
        }
    }
}
