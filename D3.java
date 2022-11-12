public class D3 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            int count=5;
            Thread t2=new Thread(()->{
               while (true){
                   ThreadUtils.sleep(300);//创建一个工具类
                   System.out.println("我是t1的守护线程,t1是我的主线程，主线程结束我就会结束");
                  /* 守护线程拥有自动结束自己生命周期的特性，非守护线程却没有。如果垃圾回收线程是非守护线程，
                  当JVM 要退出时，由于垃圾回收线程还在运行着，导致程序无法退出，这就很尴尬。这就是为什么垃圾回收线程需要是守护线程。*/
               }
            });
            t2.setDaemon(true);//Java中把线程设置为守护线程的方法：在 start 线程之前调用线程的 setDaemon(true) 方法。
            t2.start();


            while (count >= 0) {

            ThreadUtils.sleep(300);
            System.out.println("我是用户线程"+count);
            count--;
            }
        });
        t1.start();
    }
}
