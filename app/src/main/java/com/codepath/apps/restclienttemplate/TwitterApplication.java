package com.codepath.apps.restclienttemplate;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.facebook.stetho.Stetho;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     RestClient client = RestApplication.getRestClient(Context context);
 *     // use client to send requests to API
 *
 */
public class TwitterApplication extends Application {

    MyDatabase myDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        myDatabase = Room.databaseBuilder(this, MyDatabase.class, MyDatabase.NAME)
                .fallbackToDestructiveMigration()
                .build();
        Stetho.initializeWithDefaults(this);
    }

    public static TwitterClient getRestClient(Context context) {
        return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, context);
    }

}