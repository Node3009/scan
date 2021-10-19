package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public class CompositeGeneratedAdaptersObserver implements f {
    private final e[] a;

    CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        this.a = eVarArr;
    }

    @Override // androidx.lifecycle.f
    public void a(i iVar, Lifecycle.Event event) {
        n nVar = new n();
        for (e eVar : this.a) {
            eVar.a(iVar, event, false, nVar);
        }
        for (e eVar2 : this.a) {
            eVar2.a(iVar, event, true, nVar);
        }
    }
}
