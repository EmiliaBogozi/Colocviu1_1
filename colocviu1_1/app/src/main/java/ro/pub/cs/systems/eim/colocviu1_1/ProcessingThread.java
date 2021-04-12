package ro.pub.cs.systems.eim.colocviu1_1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.sql.Date;
import java.util.Random;

public class ProcessingThread extends Thread {
    private Context context = null;
    private String message = null;
    private boolean isRunning = true;

    public ProcessingThread(Context context, String instr) {
        this.context = context;
        this.message = instr;
    }

    @Override
    public void run() {
        Log.d(Constants.TAG, "Thread has started! ");
        sleep();
        sendMessage();
        Log.d(Constants.TAG, "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.INTENT_ACTION);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                new Date(System.currentTimeMillis()) + " " + message);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
