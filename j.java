package androidx.lifecycle;

import android.util.Log;
import androidx.arch.core.b.b;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class j extends Lifecycle {
    private androidx.arch.core.b.a<h, a> a = new androidx.arch.core.b.a<>();
    private Lifecycle.State b;
    private final WeakReference<i> c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<Lifecycle.State> g = new ArrayList<>();

    public j(i iVar) {
        this.c = new WeakReference<>(iVar);
        this.b = Lifecycle.State.INITIALIZED;
    }

    public void a(Lifecycle.State state) {
        b(state);
    }

    public void a(Lifecycle.Event event) {
        b(b(event));
    }

    private void b(Lifecycle.State state) {
        if (this.b != state) {
            this.b = state;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        Lifecycle.State state = this.a.d().getValue().a;
        Lifecycle.State state2 = this.a.e().getValue().a;
        if (state == state2 && this.b == state2) {
            return true;
        }
        return false;
    }

    private Lifecycle.State c(h hVar) {
        Map.Entry<h, a> d2 = this.a.d(hVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = d2 != null ? d2.getValue().a : null;
        if (!this.g.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.g;
            state = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.b, state2), state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(h hVar) {
        i iVar;
        a aVar = new a(hVar, this.b == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.a.a(hVar, aVar) == null && (iVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            Lifecycle.State c2 = c(hVar);
            this.d++;
            while (aVar.a.compareTo((Enum) c2) < 0 && this.a.c(hVar)) {
                c(aVar.a);
                aVar.a(iVar, e(aVar.a));
                c();
                c2 = c(hVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    private void c() {
        ArrayList<Lifecycle.State> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.g.add(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void b(h hVar) {
        this.a.b(hVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State a() {
        return this.b;
    }

    static Lifecycle.State b(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private static Lifecycle.Event d(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Lifecycle.Event.ON_DESTROY;
            case STARTED:
                return Lifecycle.Event.ON_STOP;
            case RESUMED:
                return Lifecycle.Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    private static Lifecycle.Event e(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.arch.core.b.a<androidx.lifecycle.h, androidx.lifecycle.j$a> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(i iVar) {
        b<K, V>.d c2 = this.a.c();
        while (c2.hasNext() && !this.f) {
            Map.Entry entry = (Map.Entry) c2.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo((Enum) this.b) < 0 && !this.f && this.a.c(entry.getKey())) {
                c(aVar.a);
                aVar.a(iVar, e(aVar.a));
                c();
            }
        }
    }

    private void b(i iVar) {
        Iterator<Map.Entry<h, a>> b2 = this.a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry<h, a> next = b2.next();
            a value = next.getValue();
            while (value.a.compareTo((Enum) this.b) > 0 && !this.f && this.a.c(next.getKey())) {
                Lifecycle.Event d2 = d(value.a);
                c(b(d2));
                value.a(iVar, d2);
                c();
            }
        }
    }

    private void d() {
        i iVar = this.c.get();
        if (iVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo((Enum) this.a.d().getValue().a) < 0) {
                b(iVar);
            }
            Map.Entry<h, a> e2 = this.a.e();
            if (!this.f && e2 != null && this.b.compareTo((Enum) e2.getValue().a) > 0) {
                a(iVar);
            }
        }
        this.f = false;
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        Lifecycle.State a;
        f b;

        a(h hVar, Lifecycle.State state) {
            this.b = l.a(hVar);
            this.a = state;
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar, Lifecycle.Event event) {
            Lifecycle.State b2 = j.b(event);
            this.a = j.a(this.a, b2);
            this.b.a(iVar, event);
            this.a = b2;
        }
    }
}
