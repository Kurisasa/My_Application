package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

public class MyApp extends Application {
    private ApplicationComponent component;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        component = DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();

        component.inject(this);

        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    return;
                }
                String token = task.getResult();
                Log.d("Firebase Token: %s", token);
            });
        } catch (Exception e) {
            Log.d("Token not found: %s", e.getLocalizedMessage());
        }
    }
    public static ApplicationComponent getComponent(Context context) {
        MyApp superbApp = getApplicationContextWithCatch(context);
        if (superbApp == null) return null;
        return superbApp.component;
    }

    private static MyApp getApplicationContextWithCatch(Context context) {
        try {
            return ((MyApp) context.getApplicationContext());
        } catch (ClassCastException c) {
            return null;
        }
    }
}
