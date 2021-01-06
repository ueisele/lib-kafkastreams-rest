package net.uweeisele.kstreams.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.apache.kafka.streams.KafkaStreams;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class JettyJerseyRestServerBuilder implements Supplier<JettyRestServer> {

    private final int port;

    private Set<Object> resources = new HashSet<>();

    private KafkaStreams streams;

    public JettyJerseyRestServerBuilder(int port) {
        this.port = port;
    }

    @Override
    public JettyRestServer get() {
        return build();
    }

    public JettyRestServer build() {
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server();
        jettyServer.setHandler(context);

        final ResourceConfig rc = new ResourceConfig();
        rc.registerInstances(resources);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //rc.register(new JacksonJaxbJsonProvider(mapper, DEFAULT_ANNOTATIONS));
        rc.register(JacksonFeature.class);

        final ServletContainer sc = new ServletContainer(rc);
        final ServletHolder holder = new ServletHolder(sc);
        context.addServlet(holder, "/*");

        final ServerConnector connector = new ServerConnector(jettyServer);
        connector.setPort(port);
        jettyServer.addConnector(connector);

        return new JettyRestServer(jettyServer);
    }

    public JettyJerseyRestServerBuilder withResource(Object resource) {
        resources.add(resource);
        return this;
    }

    public JettyJerseyRestServerBuilder withKafkaStreams(KafkaStreams streams) {
        this.streams = streams;
        return this;
    }
}
