package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class w {
    private final b a;
    private final y b;

    public interface b {
        <T extends v> T a(Class<T> cls);
    }

    public w(y yVar, b bVar) {
        this.a = bVar;
        this.b = yVar;
    }

    public <T extends v> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends v> T a(String str, Class<T> cls) {
        T t = (T) this.b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.a.a(cls);
        this.b.a(str, t2);
        return t2;
    }

    public static class c implements b {
        @Override // androidx.lifecycle.w.b
        public <T extends v> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public static class a extends c {
        private static a a;
        private Application b;

        public static a a(Application application) {
            if (a == null) {
                a = new a(application);
            }
            return a;
        }

        public a(Application application) {
            this.b = application;
        }

        @Override // androidx.lifecycle.w.b, androidx.lifecycle.w.c
        public <T extends v> T a(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.b);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }
}
