package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public class SingleGeneratedAdapterObserver implements f {
    private final e a;

    SingleGeneratedAdapterObserver(e eVar) {
        this.a = eVar;
    }

    @Override // androidx.lifecycle.f
    public void a(i iVar, Lifecycle.Event event) {
        this.a.a(iVar, event, false, null);
        this.a.a(iVar, event, true, null);
    }
}
