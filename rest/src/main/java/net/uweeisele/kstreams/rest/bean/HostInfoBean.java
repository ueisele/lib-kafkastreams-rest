package net.uweeisele.kstreams.rest.bean;

import org.apache.kafka.streams.state.HostInfo;

import java.util.Objects;

public class HostInfoBean {

    private String host;
    private int port;

    public HostInfoBean() {
    }

    public HostInfoBean(HostInfo hostInfo) {
        this(hostInfo.host(), hostInfo.port());
    }

    public HostInfoBean(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HostInfoBean{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostInfoBean that = (HostInfoBean) o;
        return port == that.port &&
                Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
