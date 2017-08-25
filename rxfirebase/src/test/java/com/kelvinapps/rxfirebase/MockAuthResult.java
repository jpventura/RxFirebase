package com.kelvinapps.rxfirebase;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MockAuthResult implements AuthResult {

    public MockAuthResult() {
        super();
    }

    @Override
    public FirebaseUser getUser() {
        return new MockFirebaseUser();
    }

}
