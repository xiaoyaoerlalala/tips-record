package com.houyao.memory;

/**
 * 慎重：执行时有较大风险，可能会导致操作系统假死，执行前请一定保存当前工作
 * -Xss2M(这时候可以设置大些)
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void StackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.StackLeakByThread();
    }
}

