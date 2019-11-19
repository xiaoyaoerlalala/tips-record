package com.houyao.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置堆的大小为固定值：-Xms10m -Xmx10m
 * 不断地创建对象，并保证GC Root与这些对象有可达的路径，避免垃圾回收机制清除这些对象
 * 在对象数量达到最大堆的容量限制后就会产生内存溢出异常。
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
        int i = 0;
        while (true) {
            //new OOMObject();
            oomObjects.add(new OOMObject());
            //获取当前空闲的内存容量byte单位
            long heapFreeSize = Runtime.getRuntime().freeMemory();
            System.out.println(heapFreeSize);
        }
    }
}
