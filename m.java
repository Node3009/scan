package androidx.lifecycle;

import androidx.arch.core.b.b;
import java.util.Iterator;
import java.util.Map;

public class m<T> extends o<T> {
    private b<LiveData<?>, a<?>> e = new b<>();

    public <S> void a(LiveData<S> liveData, p<? super S> pVar) {
        a<?> aVar = new a<>(liveData, pVar);
        a<?> a2 = this.e.a(liveData, aVar);
        if (a2 != null && a2.b != pVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (a2 == null && e()) {
            aVar.a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void c() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void d() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    private static class a<V> implements p<V> {
        final LiveData<V> a;
        final p<? super V> b;
        int c = -1;

        a(LiveData<V> liveData, p<? super V> pVar) {
            this.a = liveData;
            this.b = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a.a(this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a.b(this);
        }

        @Override // androidx.lifecycle.p
        public void a(V v) {
            if (this.c != this.a.b()) {
                this.c = this.a.b();
                this.b.a(v);
            }
        }
    }
}
