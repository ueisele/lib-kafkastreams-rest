package net.uweeisele.kstreams.rest;

import org.eclipse.jetty.server.Server;

import static java.util.Objects.requireNonNull;

public class JettyRestServer implements RestServer {

    private final Server server;

    JettyRestServer(Server server) {
        this.server = requireNonNull(server);
    }

    @Override
    public void start() throws Exception {
        server.start();
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }
}
