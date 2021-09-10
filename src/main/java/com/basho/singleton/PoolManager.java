package com.basho.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Startup;
import javax.inject.Singleton;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@DependsOn("Configuration")
@Startup
@Singleton
public class PoolManager {
    private Queue<Object> pooledObjects;

    @PostConstruct
    public void constructExpensiveObjects() {
        pooledObjects = new LinkedBlockingQueue<>(1_000);
        for (int i = 0; i <= 1000; i++) {
            pooledObjects.offer(new Object());
        }
    }

    public void returnObject(Object object) {
        pooledObjects.offer(object);
    }

    public Object borrowObject() {
        return pooledObjects.poll();
    }
}
