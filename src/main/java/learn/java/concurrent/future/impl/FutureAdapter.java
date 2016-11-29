package learn.java.concurrent.future.impl;

import learn.java.concurrent.future.IFuture;
import learn.java.concurrent.future.IFutureListener;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/25.
 */
public class FutureAdapter<V> implements IFuture<V> {

    private Collection<IFutureListener<V>> listeners = new CopyOnWriteArrayList<IFutureListener<V>>();

    public IFuture<V> addIFutureListener(IFutureListener listener) {
        if (listener == null){
            throw new NullPointerException("listener is null");
        }
        if (isDone()){ // 如果完成任务，立即通知监听器
            notifyListener(listener);
        }

        return null;
    }

    /**
     * 通知监听器
     */
    private void notifyListener(IFutureListener listener) {

    }

    public IFuture<V> removeIFutureListener(IFutureListener listener) {
        return null;
    }

    public IFuture<V> await() throws InterruptedException {
        return null;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public V get() throws InterruptedException, ExecutionException {
        return null;
    }

    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
