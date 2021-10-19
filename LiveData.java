package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object b = new Object();
    final Object a = new Object();
    int c = 0;
    volatile Object d;
    private androidx.arch.core.b.b<p<? super T>, LiveData<T>.b> e = new androidx.arch.core.b.b<>();
    private volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    public LiveData() {
        Object obj = b;
        this.f = obj;
        this.d = obj;
        this.g = -1;
        this.j = new Runnable() {
            /* class androidx.lifecycle.LiveData.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                Object obj;
                synchronized (LiveData.this.a) {
                    obj = LiveData.this.d;
                    LiveData.this.d = LiveData.b;
                }
                LiveData.this.b(obj);
            }
        };
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.d) {
            if (!bVar.a()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.e;
            int i3 = this.g;
            if (i2 < i3) {
                bVar.e = i3;
                bVar.c.a((Object) this.f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.b bVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (bVar == null) {
                androidx.arch.core.b.b<K, V>.d c2 = this.e.c();
                while (c2.hasNext()) {
                    b((LiveData<T>.b) ((b) ((Map.Entry) c2.next()).getValue()));
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void a(i iVar, p<? super T> pVar) {
        a("observe");
        if (iVar.getLifecycle().a() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iVar, pVar);
            LiveData<T>.b a2 = this.e.a(pVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(iVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                iVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(p<? super T> pVar) {
        a("observeForever");
        a aVar = new a(pVar);
        LiveData<T>.b a2 = this.e.a(pVar, aVar);
        if (a2 != null && (a2 instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (a2 == null) {
            aVar.a(true);
        }
    }

    public void b(p<? super T> pVar) {
        a("removeObserver");
        LiveData<T>.b b2 = this.e.b(pVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        boolean z;
        synchronized (this.a) {
            z = this.d == b;
            this.d = t;
        }
        if (z) {
            androidx.arch.core.a.a.a().b(this.j);
        }
    }

    /* access modifiers changed from: protected */
    public void b(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((LiveData<T>.b) null);
    }

    public T a() {
        T t = (T) this.f;
        if (t != b) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    public boolean e() {
        return this.c > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.b implements f {
        final i a;

        LifecycleBoundObserver(i iVar, p<? super T> pVar) {
            super(pVar);
            this.a = iVar;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.b
        public boolean a() {
            return this.a.getLifecycle().a().a(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.f
        public void a(i iVar, Lifecycle.Event event) {
            if (this.a.getLifecycle().a() == Lifecycle.State.DESTROYED) {
                LiveData.this.b((p) this.c);
            } else {
                a(a());
            }
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.b
        public boolean a(i iVar) {
            return this.a == iVar;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.b
        public void b() {
            this.a.getLifecycle().b(this);
        }
    }

    /* access modifiers changed from: private */
    public abstract class b {
        final p<? super T> c;
        boolean d;
        int e = -1;

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        b(p<? super T> pVar) {
            this.c = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.d) {
                this.d = z;
                int i = 1;
                boolean z2 = LiveData.this.c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.c;
                if (!this.d) {
                    i = -1;
                }
                liveData.c = i2 + i;
                if (z2 && this.d) {
                    LiveData.this.c();
                }
                if (LiveData.this.c == 0 && !this.d) {
                    LiveData.this.d();
                }
                if (this.d) {
                    LiveData.this.a((LiveData<T>.b) this);
                }
            }
        }
    }

    private class a extends LiveData<T>.b {
        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.b
        public boolean a() {
            return true;
        }

        a(p<? super T> pVar) {
            super(pVar);
        }
    }

    private static void a(String str) {
        if (!androidx.arch.core.a.a.a().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }
}
