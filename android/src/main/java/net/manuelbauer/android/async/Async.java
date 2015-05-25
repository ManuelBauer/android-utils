package net.manuelbauer.android.async;

import java.util.ArrayList;
import java.util.List;

/**
 * Async provides various methods for asynchronous operations
 *
 * @author Manuel Bauer
 */
public class Async {

    private static String TAG = "Async";

    /**
     * List containing all queued operations
     */
    private List<AsyncOperation> operations = new ArrayList<>();

    /**
     * Add new operation to the queue
     *
     * @param operation
     * @return Async object for additional actions
     */
    public <I,O> Async addOperation(AsyncOperation<I, O> operation) {

        if(operation == null) {
            throw new IllegalArgumentException("AsyncOperation is null");
        }

        operations.add(operation);

        return this;
    }

    /**
     * Execute one operation after the other
     * @param finalCallback Callback which is called when all operations are completed
     */
    public <T> void series(final FutureCallback<T> finalCallback) {
        executeSeries(0, null, finalCallback);
    }

    private <I, O> void executeSeries(final int i, I input, final FutureCallback<O> finalCallback) {
        AsyncOperation<I,O> o = operations.get(i);

        new TaskThread<>(o, input, new FutureCallback<O>() {

            @Override
            public void onComplete(Exception ex, O result) {
                if(ex != null) {
                    finalCallback.onComplete(ex, null);
                } else {
                    if(i + 1 == operations.size()) {
                        finalCallback.onComplete(null, result);
                        return;
                    }

                    executeSeries(i + 1, result, finalCallback);
                }
            }
        }).start();
    }
}
