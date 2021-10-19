package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* access modifiers changed from: package-private */
public class FullLifecycleObserverAdapter implements f {
    private final d a;

    FullLifecycleObserverAdapter(d dVar) {
        this.a = dVar;
    }

    @Override // androidx.lifecycle.f
    public void a(i iVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.a.a(iVar);
                return;
            case ON_START:
                this.a.b(iVar);
                return;
            case ON_RESUME:
                this.a.c(iVar);
                return;
            case ON_PAUSE:
                this.a.d(iVar);
                return;
            case ON_STOP:
                this.a.e(iVar);
                return;
            case ON_DESTROY:
                this.a.f(iVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
