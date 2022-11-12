import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class D2 implements Callable<Long> {
    private long f1,f2;

    public D2(long f1, long f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public D2() {
    }

    @Override
    public Long call() throws Exception {
        long a=0;
        for(long i=f1;i<f2;i++){
            a+=i;
        }
        return a;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //只利用一个线程计算一亿的累加和
        long a=0;
        long l1 = System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            a+=i;
        }
        long l2 = System.currentTimeMillis();
        System.out.println("一共消耗时间："+(l2-l1));
        System.out.println("累加和："+a);


        //利用5个线程来计算
         a=0;
        l1 = System.currentTimeMillis();
        FutureTask []f=new FutureTask[5];
        for(int i=0;i<5;i++){
            FutureTask<Long> futureTask=new FutureTask<>(new D2(i*20000000,(i+1)*20000000));
            new Thread(futureTask).start();
           f[i]=futureTask;
        }
        for(int i=0;i<5;i++){
            Long o = (Long)f[i].get();//一定要把阻塞的方法拿出来
            a+=o;
            System.out.println("第"+i+"个线程累加和:"+a);
        }
        l2 = System.currentTimeMillis();
        System.out.println("5线程一共消耗时间："+(l2-l1));
        System.out.println("累加和："+a);
    }
}
