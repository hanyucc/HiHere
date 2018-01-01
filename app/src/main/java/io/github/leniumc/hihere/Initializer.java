package io.github.leniumc.hihere;

import android.app.Application;

import net.gotev.uploadservice.UploadService;

/**
 * Created by leniumc on 11/12/17.
 */

public class Initializer extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // setup the broadcast action namespace string which will
        // be used to notify upload status.
        // Gradle automatically generates proper variable as below.
        UploadService.NAMESPACE = BuildConfig.APPLICATION_ID;
    }
}