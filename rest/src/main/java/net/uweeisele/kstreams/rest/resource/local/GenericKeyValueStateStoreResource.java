package net.uweeisele.kstreams.rest.resource.local;

import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

import java.util.function.Function;

public class GenericKeyValueStateStoreResource<K> {

    private final ReadOnlyKeyValueStore<K, ?> keyValueStore;

    private final Function<String, K> keyMapper;

    public GenericKeyValueStateStoreResource(ReadOnlyKeyValueStore<K, ?> keyValueStore, Function<String, K> keyMapper) {
        this.keyValueStore = keyValueStore;
        this.keyMapper = keyMapper;
    }
}
