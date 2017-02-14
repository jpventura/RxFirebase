package com.kelvinapps.rxfirebase;

import android.support.annotation.NonNull;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Nick Moskalenko on 24/05/2016.
 */
public class RxFirebaseConfig {

    @NonNull
    public static Observable<Void> fetch(@NonNull final FirebaseRemoteConfig config) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(ObservableEmitter<Void> emitter) throws Exception {
                RxHandler.assignOnTask(emitter, config.fetch());
            }
        });
    }

    @NonNull
    public static Observable<Void> fetch(@NonNull final FirebaseRemoteConfig config, final long cacheExpirationSeconds) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(ObservableEmitter<Void> emitter) throws Exception {
                RxHandler.assignOnTask(emitter, config.fetch(cacheExpirationSeconds));
            }
        });
    }

}
