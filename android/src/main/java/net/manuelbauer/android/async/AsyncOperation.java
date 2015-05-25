package net.manuelbauer.android.async;

/**
 * Interface for Asynchronous operations
 */
public interface AsyncOperation<I, O> {

  void doWork(I input, FutureCallback<O> callback);
}
