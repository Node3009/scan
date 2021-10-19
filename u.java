package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public class u {
    private final j a;
    private final Handler b = new Handler();
    private a c;

    public u(i iVar) {
        this.a = new j(iVar);
    }

    private void a(Lifecycle.Event event) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.run();
        }
        this.c = new a(this.a, event);
        this.b.postAtFrontOfQueue(this.c);
    }

    public void a() {
        a(Lifecycle.Event.ON_CREATE);
    }

    public void b() {
        a(Lifecycle.Event.ON_START);
    }

    public void c() {
        a(Lifecycle.Event.ON_START);
    }

    public void d() {
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle e() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        final Lifecycle.Event a;
        private final j b;
        private boolean c = false;

        a(j jVar, Lifecycle.Event event) {
            this.b = jVar;
            this.a = event;
        }

        public void run() {
            if (!this.c) {
                this.b.a(this.a);
                this.c = true;
            }
        }
    }
}
