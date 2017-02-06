package com.dareu.mobile.activity.service;

import android.util.Log;

import com.dareu.mobile.utils.NotificationUtils;
import com.dareu.web.dto.response.message.AbstractMessage;
import com.dareu.web.dto.response.message.MessageType;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by jose.rubalcaba on 10/09/2016.
 */

public class DareuMessagingService extends FirebaseMessagingService {

    private static final String TAG = "DareuMessagingService";
    public DareuMessagingService(){
        super();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();

        remoteMessage.getNotification();

        //dispatch notification
        NotificationUtils.dispatchNotification(getApplicationContext(), data);
    }


}
