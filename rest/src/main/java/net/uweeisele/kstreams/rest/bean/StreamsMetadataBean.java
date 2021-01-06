package net.uweeisele.kstreams.rest.bean;

import org.apache.kafka.streams.state.StreamsMetadata;

import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class StreamsMetadataBean {

    private HostInfoBean hostInfo;
    private Set<String> stateStoreNames;
    private Set<TopicPartitionBean> topicPartitions;

    public StreamsMetadataBean() {
    }

    public StreamsMetadataBean(StreamsMetadata streamsMetadata) {
        this(new HostInfoBean(streamsMetadata.hostInfo()),
                streamsMetadata.stateStoreNames(),
                streamsMetadata.topicPartitions().stream().map(TopicPartitionBean::new).collect(toSet()));
    }

    public StreamsMetadataBean(HostInfoBean hostInfo, Set<String> stateStoreNames, Set<TopicPartitionBean> topicPartitions) {
        this.hostInfo = hostInfo;
        this.stateStoreNames = stateStoreNames;
        this.topicPartitions = topicPartitions;
    }

    public HostInfoBean getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(HostInfoBean hostInfo) {
        this.hostInfo = hostInfo;
    }

    public Set<String> getStateStoreNames() {
        return stateStoreNames;
    }

    public void setStateStoreNames(Set<String> stateStoreNames) {
        this.stateStoreNames = stateStoreNames;
    }

    public Set<TopicPartitionBean> getTopicPartitions() {
        return topicPartitions;
    }

    public void setTopicPartitions(Set<TopicPartitionBean> topicPartitions) {
        this.topicPartitions = topicPartitions;
    }

    @Override
    public String toString() {
        return "StreamsMetadataBean{" +
                "hostInfo=" + hostInfo +
                ", stateStoreNames=" + stateStoreNames +
                ", topicPartitions=" + topicPartitions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamsMetadataBean that = (StreamsMetadataBean) o;
        return Objects.equals(hostInfo, that.hostInfo) &&
                Objects.equals(stateStoreNames, that.stateStoreNames) &&
                Objects.equals(topicPartitions, that.topicPartitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostInfo, stateStoreNames, topicPartitions);
    }
}
