public class D1 {
     public static void main(String[] args) {
         new Thread(new MyThread2()).start();
         new Thread(new MyThread()).start();
           for(int i=0;i<15;i++){
               System.out.println("我是main:"+i);
           }

     }




    static class MyThread extends Thread{

         //继承Thread类实现run方法
        @Override
        public void run() {
            System.out.println("我是run方法的");
            for(int i=0;i<10;i++){
                System.out.println("我是重写run的方法:"+i);
            }
        }
    }

    static  class MyThread2 implements Runnable {
         //继承runnable接口的方法
        @Override
        public void run() {
            System.out.println("我是继承runnable接口的方法");
            for(int i=0;i<10;i++){
                System.out.println("我是继承runnable接口的方法:"+i);
            }
        }
    }
}
