package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

public class a extends v {
    @SuppressLint({"StaticFieldLeak"})
    private Application a;

    public a(Application application) {
        this.a = application;
    }

    public <T extends Application> T a() {
        return (T) this.a;
    }
}
