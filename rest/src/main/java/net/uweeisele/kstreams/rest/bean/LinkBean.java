package net.uweeisele.kstreams.rest.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.ws.rs.core.Link;
import java.net.URI;

import static java.util.Objects.requireNonNull;

public class LinkBean {

    private URI href;
    private String rel;
    private String type;

    public LinkBean() {
    }

    public LinkBean(Link link) {
        this(link.getUri(), link.getRel(), link.getType());
    }

    public LinkBean(URI href, String rel, String type) {
        this.href = requireNonNull(href);
        this.rel = requireNonNull(rel);
        this.type = requireNonNull(type);
    }

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public Link getLink() {
        return Link.fromUri(href).rel(rel).type(type).build();
    }
}
