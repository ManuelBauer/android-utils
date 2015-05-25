package net.manuelbauer.android.async;

public interface FutureCallback<T> {
    void onComplete(Exception ex, T result);
}
