package net.uweeisele.kstreams.rest.resource.local;

import org.apache.kafka.streams.state.QueryableStoreType;

import java.util.function.Function;

public class StateStoreResourceRegistry {

    public <T> StateStoreResourceRegistry register(QueryableStoreType<T> storeType, Function<T, Object> resourceFactory) {

        return this;
    }

    public <T> StateStoreResourceRegistry register(QueryableStoreType<T> storeType, String storeName, Function<T, Object> resourceFactory) {

        return this;
    }

    public <T> Function<T, Object> getResourceFactory(QueryableStoreType<T> storeType, String storeName) {

    }
}
