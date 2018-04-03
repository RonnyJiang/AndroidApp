package net.kbbs.interfacedemo.callback;

/**
 * Created by ronny on 18-4-3.
 */

/**定义一个回调接口，
 * 然后定义一个类A，
 * 并在类A的方法中执行耗时操作，
 * 在耗时操作执行完成后调用onSuccess或failure接口，
 * 然后在mainactivity里面实现接口的所有抽象方法，然后new一个类A的对象，并执行耗时的方法。
 * 这样耗时方法执行完成后调的接口就自动走到onSuccess和failure里面了
 * 这就实现了主类不执行耗时任务，耗时任务交由子线程去完成，完成后告诉主线程执行的结果。**/
public interface OnInfoFetchCallback {
    /** 获取信息成功 **/
    void onSuccess(String info) throws InterruptedException;
    /** 获取信息失败　**/
    void onFailure();
}
