package androidx.lifecycle;

public abstract class Lifecycle {

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract State a();

    public abstract void a(h hVar);

    public abstract void b(h hVar);

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(State state) {
            return compareTo(state) >= 0;
        }
    }
}
