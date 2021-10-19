package androidx.lifecycle;

import java.util.HashMap;

public class y {
    private final HashMap<String, v> a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, v vVar) {
        v put = this.a.put(str, vVar);
        if (put != null) {
            put.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final v a(String str) {
        return this.a.get(str);
    }

    public final void a() {
        for (v vVar : this.a.values()) {
            vVar.b();
        }
        this.a.clear();
    }
}
