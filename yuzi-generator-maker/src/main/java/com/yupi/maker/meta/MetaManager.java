package com.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    //volatile用于确保多线程环境下的内存可见性，保证meta被修改时所有线程都知道
    private static volatile Meta meta;

    //双检锁单例模式的使用，加锁与第二个if语句以确保对象初始化一次，第一个if语句确保不会多次加锁，避免影响性能
    public static Meta getMetaObject(){
        if(meta == null){
            synchronized (MetaManager.class){
                if(meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        return JSONUtil.toBean(metaJson, Meta.class);
    }
}
