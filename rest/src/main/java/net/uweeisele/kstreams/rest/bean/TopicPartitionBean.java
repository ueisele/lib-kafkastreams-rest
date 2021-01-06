package net.uweeisele.kstreams.rest.bean;

import org.apache.kafka.common.TopicPartition;

import java.util.Objects;

public class TopicPartitionBean {

    private int partition;
    private String topic;

    public TopicPartitionBean() {
    }

    public TopicPartitionBean(TopicPartition topicPartition) {
        this(topicPartition.partition(), topicPartition.topic());
    }

    public TopicPartitionBean(int partition, String topic) {
        this.partition = partition;
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "TopicPartitionBean{" +
                "partition=" + partition +
                ", topic='" + topic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicPartitionBean that = (TopicPartitionBean) o;
        return partition == that.partition &&
                Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partition, topic);
    }
}
