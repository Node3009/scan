package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

public class t extends Fragment {
    private a a;

    /* access modifiers changed from: package-private */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new t(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    static t b(Activity activity) {
        return (t) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.a);
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        c(this.a);
        a(Lifecycle.Event.ON_START);
    }

    public void onResume() {
        super.onResume();
        d(this.a);
        a(Lifecycle.Event.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.a = null;
    }

    private void a(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof k) {
            ((k) activity).a().a(event);
        } else if (activity instanceof i) {
            Lifecycle lifecycle = ((i) activity).getLifecycle();
            if (lifecycle instanceof j) {
                ((j) lifecycle).a(event);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.a = aVar;
    }
}
