package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;

/* access modifiers changed from: package-private */
public class ReflectiveGenericLifecycleObserver implements f {
    private final Object a;
    private final b.a b = b.a.b(this.a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
    }

    @Override // androidx.lifecycle.f
    public void a(i iVar, Lifecycle.Event event) {
        this.b.a(iVar, event, this.a);
    }
}
