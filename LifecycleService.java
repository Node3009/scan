package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements i {
    private final u a = new u(this);

    public void onCreate() {
        this.a.a();
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        this.a.b();
        return null;
    }

    public void onStart(Intent intent, int i) {
        this.a.c();
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        this.a.d();
        super.onDestroy();
    }

    @Override // androidx.lifecycle.i
    public Lifecycle getLifecycle() {
        return this.a.e();
    }
}
