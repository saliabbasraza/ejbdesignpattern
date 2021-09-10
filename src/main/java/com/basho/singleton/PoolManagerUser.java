package com.basho.singleton;

import javax.inject.Inject;

public class PoolManagerUser {
    @Inject
    private PoolManager poolManager;

    public void usePool() {
        final Object object = poolManager.borrowObject();

        // Do some object work

        poolManager.returnObject(object);
    }
}
