package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t;

public class s implements i {
    private static final s i = new s();
    t.a a = new t.a() {
        /* class androidx.lifecycle.s.AnonymousClass2 */

        @Override // androidx.lifecycle.t.a
        public void a() {
        }

        @Override // androidx.lifecycle.t.a
        public void b() {
            s.this.a();
        }

        @Override // androidx.lifecycle.t.a
        public void c() {
            s.this.b();
        }
    };
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private boolean e = true;
    private Handler f;
    private final j g = new j(this);
    private Runnable h = new Runnable() {
        /* class androidx.lifecycle.s.AnonymousClass1 */

        public void run() {
            s.this.e();
            s.this.f();
        }
    };

    static void a(Context context) {
        i.b(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.b++;
        if (this.b == 1 && this.e) {
            this.g.a(Lifecycle.Event.ON_START);
            this.e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.c++;
        if (this.c != 1) {
            return;
        }
        if (this.d) {
            this.g.a(Lifecycle.Event.ON_RESUME);
            this.d = false;
            return;
        }
        this.f.removeCallbacks(this.h);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.c--;
        if (this.c == 0) {
            this.f.postDelayed(this.h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.b--;
        f();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.c == 0) {
            this.d = true;
            this.g.a(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.b == 0 && this.d) {
            this.g.a(Lifecycle.Event.ON_STOP);
            this.e = true;
        }
    }

    private s() {
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        this.f = new Handler();
        this.g.a(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c() {
            /* class androidx.lifecycle.s.AnonymousClass3 */

            @Override // androidx.lifecycle.c
            public void onActivityCreated(Activity activity, Bundle bundle) {
                t.b(activity).a(s.this.a);
            }

            @Override // androidx.lifecycle.c
            public void onActivityPaused(Activity activity) {
                s.this.c();
            }

            @Override // androidx.lifecycle.c
            public void onActivityStopped(Activity activity) {
                s.this.d();
            }
        });
    }

    @Override // androidx.lifecycle.i
    public Lifecycle getLifecycle() {
        return this.g;
    }
}
