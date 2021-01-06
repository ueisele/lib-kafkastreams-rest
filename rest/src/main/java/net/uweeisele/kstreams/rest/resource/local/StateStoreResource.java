package net.uweeisele.kstreams.rest.resource.local;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.state.QueryableStoreTypes;

import javax.ws.rs.Path;

public class StateStoreResource {

    private final KafkaStreams streams;

    public StateStoreResource(KafkaStreams streams) {
        this.streams = streams;
    }

    @Path("/{storeType}/{storeName}")
    public Object keyValue() {

        return null;
    }
}
