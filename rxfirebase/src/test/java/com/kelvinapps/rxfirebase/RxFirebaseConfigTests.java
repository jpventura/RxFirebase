package com.kelvinapps.rxfirebase;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Nick Moskalenko on 24/05/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class RxFirebaseConfigTests {

    @Mock
    private FirebaseRemoteConfig mockConfig;

    @Mock
    private Task<Void> mockTask;

    @Captor
    private ArgumentCaptor<OnCompleteListener> testOnCompleteListener;

    @Captor
    private ArgumentCaptor<OnSuccessListener> testOnSuccessListener;

    private Void mockRes = null;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        testOnCompleteListener = ArgumentCaptor.forClass(OnCompleteListener.class);
        testOnSuccessListener = ArgumentCaptor.forClass(OnSuccessListener.class);

        when(mockTask.addOnCompleteListener(testOnCompleteListener.capture())).thenReturn(mockTask);
        when(mockTask.addOnSuccessListener(testOnSuccessListener.capture())).thenReturn(mockTask);

        when(mockConfig.fetch()).thenReturn(mockTask);
        when(mockConfig.fetch(1)).thenReturn(mockTask);
    }

    @Test
    public void fetch() throws InterruptedException {

        TestObserver<Void> testObserver = new TestObserver<>();
        RxFirebaseConfig.fetch(mockConfig)
                .subscribeOn(Schedulers.trampoline())
                .subscribe(testObserver);

        testOnSuccessListener.getValue().onSuccess(mockRes);
        testOnCompleteListener.getValue().onComplete(mockTask);

        verify(mockConfig).fetch();

        // testObserver.assertNoErrors();
        testObserver.assertValueCount(1);
        // testObserver.assertReceivedOnNext(Collections.singletonList(mockRes));
        testObserver.assertComplete();
        testObserver.dispose();
    }

    @Test
    public void fetchWithExpiration() throws InterruptedException {

        TestObserver<Void> testObserver = new TestObserver<>();
        RxFirebaseConfig.fetch(mockConfig, 1)
                .subscribeOn(Schedulers.trampoline())
                .subscribe(testObserver);

        testOnSuccessListener.getValue().onSuccess(mockRes);
        testOnCompleteListener.getValue().onComplete(mockTask);

        verify(mockConfig).fetch(1);

        // testObserver.assertNoErrors();
        testObserver.assertValueCount(1);
        // testObserver.assertReceivedOnNext(Collections.singletonList(mockRes));
        testObserver.assertComplete();
        testObserver.dispose();
    }
}
