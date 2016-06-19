package com.example.open.androidnotification;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void clickit(View view){
        notification();
    }

    public void notification(){
        Intent intent=new Intent(this,NotificationActivity.class);
        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(getApplicationContext());
        taskStackBuilder.addParentStack(NotificationActivity.class);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(123,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder=new Notification.Builder(this);
        builder.setContentTitle("Title Here");
        builder.setContentInfo("Information");
        builder.setContentText("Builder class for Notification objects.");
        builder.setSmallIcon(R.drawable.ic_stat_name);
        //Sound
        builder.setDefaults(Notification.DEFAULT_SOUND);
        //Action calling
        builder.setContentIntent(pendingIntent);

        Notification notification=builder.build();
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }
}
