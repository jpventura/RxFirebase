package com.kelvinapps.rxfirebase;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.internal.zzbmn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.util.List;

public class MockFirebaseUser extends FirebaseUser {

    @Nullable
    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public boolean isEmailVerified() {
        return false;
    }

    @NonNull
    @Override
    public String getUid() {
        return null;
    }

    @Override
    public FirebaseUser zzaX(boolean b) {
        return null;
    }

    @Override
    public void zza(@NonNull zzbmn zzbmn) {

    }

    @NonNull
    @Override
    public zzbmn zzVI() {
        return null;
    }

    @NonNull
    @Override
    public FirebaseUser zzU(@NonNull List<? extends UserInfo> list) {
        return null;
    }

    @Nullable
    @Override
    public String getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public Uri getPhotoUrl() {
        return null;
    }

    @NonNull
    @Override
    public String getProviderId() {
        return null;
    }

    @NonNull
    @Override
    public List<? extends UserInfo> getProviderData() {
        return null;
    }

    @Override
    public boolean isAnonymous() {
        return false;
    }

    @Nullable
    @Override
    public List<String> getProviders() {
        return null;
    }

    @NonNull
    @Override
    public FirebaseApp zzVH() {
        return null;
    }

    @NonNull
    @Override
    public String zzVK() {
        return null;
    }

    @NonNull
    @Override
    public String zzVJ() {
        return null;
    }
}
