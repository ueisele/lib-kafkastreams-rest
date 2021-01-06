package net.uweeisele.kstreams.rest.resource.local;

import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

import java.util.function.Function;

public class GenericKeyValueStateStoreResourceBuilder<K> implements Function<ReadOnlyKeyValueStore<K, ?>, GenericKeyValueStateStoreResource<K>> {

    private final Function<String, K> keyMapper;

    public GenericKeyValueStateStoreResourceBuilder(Function<String, K> keyMapper) {
        this.keyMapper = keyMapper;
    }

    @Override
    public GenericKeyValueStateStoreResource<K> apply(ReadOnlyKeyValueStore<K, ?> readOnlyKeyValueStore) {
        return new GenericKeyValueStateStoreResource<>(readOnlyKeyValueStore, keyMapper);
    }

}
