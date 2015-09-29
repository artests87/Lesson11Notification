package com.example.artests.lesson11notofications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    private static final int NOTIFY_ID=201;
    private static final int NOTIFY_ID2=202;
    private static final int NOTIFY_ID3=203;
    private static final int NOTIFY_ID4=204;

    private static NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancelAll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static void cancelAllNotifications(){
        manager.cancelAll();
    }

    public void sendNotificationWithButtons(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setTicker(getString(R.string.ticker2))
                .setContentTitle(getString(R.string.Title2))
                .setContentText(getString(R.string.Text2))
                .setSmallIcon(R.drawable.sherlock).setContentIntent(pendingIntent)
                .addAction(R.drawable.lesson9_popup_menu, getString(R.string.firstAction), pendingIntent)
                .addAction(R.drawable.lesson10, getString(R.string.second_action), pendingIntent)
                .addAction(R.drawable.lesson11, getString(R.string.thread_action), pendingIntent)
                .setAutoCancel(true);


        manager.notify(NOTIFY_ID,builder.build());
    }

    public void sendNotificationWithLongText(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/K-tjLqd36EU"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        String bigText=getString(R.string.big_text);
        NotificationCompat.BigTextStyle bigTextStyle=new NotificationCompat.BigTextStyle().bigText(bigText);
        NotificationCompat.Builder buider = new NotificationCompat.Builder(this)
                .setTicker(getString(R.string.ticker2))
                .setContentTitle(getString(R.string.content_title))
                .setSmallIcon(R.drawable.sherlock)
                .setStyle(bigTextStyle)
                .setWhen(System.currentTimeMillis())
                .addAction(R.drawable.lesson10, getString(R.string.firstAction), pendingIntent)
                .setAutoCancel(true);

        manager.notify(NOTIFY_ID2, buider.build());
    }

    public void sendNotoficationWithBigImage(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://files7.adme.ru/files/news/part_105/1054460/2062510-R3L8T8D-1000-15sfQUIPA0o.jpg"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.BigPictureStyle bigPictureStyle=
                new NotificationCompat.BigPictureStyle().
                        bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.large));
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setContentTitle(getString(R.string.big_posting))
                .setTicker(getString(R.string.big_ticket))
                .setContentText(getString(R.string.notification_big))
                .setSmallIcon(R.drawable.large)
                .setStyle(bigPictureStyle)
                .addAction(R.drawable.lesson10, getString(R.string.launch_activity), pendingIntent)
                .setAutoCancel(true);

        manager.notify(NOTIFY_ID3,builder.build());
    }

    public void sendNotificationWithInbox(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.ru/search?q=%D0%BA%D0%BE%D1%82%D0%B8%D0%BA%D0%B8&newwindow=1&es_sm=93&tbm=isch&imgil=jzjGeJmzNWnkmM%253A%253B0waCciN6wnuxdM%253Bhttp%25253A%25252F%25252Fannetjohnson.livejournal.com%25252F173928.html&source=iu&pf=m&fir=jzjGeJmzNWnkmM%253A%252C0waCciN6wnuxdM%252C_&biw=1600&bih=755&usg=__gFYgdrLZxE_GlsJoZtbUVtaOmlI%3D&ved=0CCUQyjdqFQoTCNbdvZzWm8gCFYuULAod7NYGEQ&ei=YTcKVpapLoupsgHsrZuIAQ"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle()
                .addLine(getString(R.string.firstMessage)).addLine(getString(R.string.secondMessage))
                .addLine(getString(R.string.thirdMessage)).setSummaryText(getString(R.string.more));
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setTicker(getString(R.string.ticker2))
                .setContentTitle(getString(R.string.notification_inbox))
                .setContentText(getString(R.string.inbox_style))
                .setSmallIcon(R.drawable.lesson9_popup_menu)
                .setStyle(inboxStyle)
                .addAction(R.drawable.lesson10, getString(R.string.launch_activity), pendingIntent)
                .setAutoCancel(true);
        manager.notify(NOTIFY_ID4,builder.build());
    }

}
