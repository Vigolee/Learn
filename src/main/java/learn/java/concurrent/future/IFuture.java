package learn.java.concurrent.future;

import java.util.concurrent.Future;

/**
 * 扩展Future接口
 * Created by Vigo on 16/11/25.
 */
public interface IFuture<V> extends Future<V> {

    IFuture<V> addIFutureListener(IFutureListener listener);

    IFuture<V> removeIFutureListener(IFutureListener listener);

    IFuture<V> await() throws InterruptedException; //等待future的完成
}
