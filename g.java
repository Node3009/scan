package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

class g {
    private static AtomicBoolean a = new AtomicBoolean(false);

    static void a(Context context) {
        if (!a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }

    static class a extends c {
        @Override // androidx.lifecycle.c
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.c
        public void onActivityStopped(Activity activity) {
        }

        a() {
        }

        @Override // androidx.lifecycle.c
        public void onActivityCreated(Activity activity, Bundle bundle) {
            t.a(activity);
        }
    }
}
