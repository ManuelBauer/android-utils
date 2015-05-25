package net.manuelbauer.android.async;

public class TaskThread<P,T> extends Thread {

    private AsyncOperation<P,T> operation;
    private FutureCallback<T> callback;
    private P input;

    public TaskThread(AsyncOperation<P,T> operation, P input, FutureCallback<T> callback) {
        this.operation = operation;
        this.callback = callback;
        this.input = input;
    }

    @Override
    public void run() {
        super.run();

        operation.doWork(input, callback);
    }
}