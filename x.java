package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.w;

public class x {
    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity b(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    public static w a(Fragment fragment) {
        return a(fragment, (w.b) null);
    }

    public static w a(FragmentActivity fragmentActivity) {
        return a(fragmentActivity, (w.b) null);
    }

    public static w a(Fragment fragment, w.b bVar) {
        Application a = a(b(fragment));
        if (bVar == null) {
            bVar = w.a.a(a);
        }
        return new w(fragment.getViewModelStore(), bVar);
    }

    public static w a(FragmentActivity fragmentActivity, w.b bVar) {
        Application a = a((Activity) fragmentActivity);
        if (bVar == null) {
            bVar = w.a.a(a);
        }
        return new w(fragmentActivity.getViewModelStore(), bVar);
    }
}
