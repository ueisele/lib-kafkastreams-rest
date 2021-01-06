package net.uweeisele.kstreams.rest.resource.local;

import net.uweeisele.kstreams.rest.bean.LinkBean;
import net.uweeisele.kstreams.rest.bean.StateBean;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.state.HostInfo;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;
import java.util.HashSet;
import java.util.Set;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/instance")
@Singleton
public class InstanceResource {

    private final KafkaStreams streams;
    private final HostInfo hostInfo;

    public InstanceResource(KafkaStreams streams, HostInfo hostInfo) {
        this.streams = streams;
        this.hostInfo = hostInfo;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Set<LinkBean> toc(@Context UriInfo uriInfo) {
        Set<LinkBean> toc = new HashSet<>();
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").type("GET").build()));
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(getClass(), "state")).rel("state").type("GET").build()));
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(getClass(), "metadata")).rel("metadata").type("GET").build()));
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(getClass(), "store")).rel("store").type("GET").build()));
        return toc;
    }

    @GET
    @Path("/state")
    @Produces(APPLICATION_JSON)
    public StateBean state() {
        return new StateBean(streams.state().name());
    }

    @Path("/metadata")
    public MetadataResource metadata() {
        return new MetadataResource(streams.localThreadsMetadata(),
                streams.allMetadata().stream().filter(s -> hostInfo.equals(s.hostInfo())).findFirst().orElse(null));
    }

    @GET
    @Path("/store")
    @Produces(APPLICATION_JSON)
    public StateStoreResource store() {
        return null;
    }

}
