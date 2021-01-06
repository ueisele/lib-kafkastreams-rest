package net.uweeisele.kstreams.rest.resource.local;

import net.uweeisele.kstreams.rest.bean.LinkBean;
import net.uweeisele.kstreams.rest.bean.StreamsMetadataBean;
import net.uweeisele.kstreams.rest.bean.ThreadMetadataBean;
import org.apache.kafka.streams.processor.ThreadMetadata;
import org.apache.kafka.streams.state.StreamsMetadata;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class MetadataResource {

    private final Set<ThreadMetadata> localThreadMetadata;
    private final StreamsMetadata streamsMetadata;

    public MetadataResource(Set<ThreadMetadata> localThreadMetadata, StreamsMetadata streamsMetadata) {
        this.localThreadMetadata = localThreadMetadata;
        this.streamsMetadata = streamsMetadata;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Set<LinkBean> toc(@Context UriInfo uriInfo) {
        Set<LinkBean> toc = new HashSet<>();
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").type("GET").build()));
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(getClass(), "threads")).rel("threadMetadata").type("GET").build()));
        toc.add(new LinkBean(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(getClass(), "streams")).rel("streamsMetadata").type("GET").build()));
        return toc;
    }

    @GET
    @Path("/threads")
    @Produces(APPLICATION_JSON)
    public Set<ThreadMetadataBean> threads() {
        return localThreadMetadata.stream().map(ThreadMetadataBean::new).collect(toSet());
    }

    @GET
    @Path("/streams")
    @Produces(APPLICATION_JSON)
    public StreamsMetadataBean streams() {
        return new StreamsMetadataBean(streamsMetadata);
    }

}
