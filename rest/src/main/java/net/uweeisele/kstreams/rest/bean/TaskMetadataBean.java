package net.uweeisele.kstreams.rest.bean;

import org.apache.kafka.streams.processor.TaskMetadata;

import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TaskMetadataBean {

    private String taskId;

    private Set<TopicPartitionBean> topicPartitions;

    public TaskMetadataBean() {
    }

    public TaskMetadataBean(TaskMetadata taskMetadata) {
        this(taskMetadata.taskId(), taskMetadata.topicPartitions().stream()
                .map(TopicPartitionBean::new)
                .collect(toSet()));
    }

    public TaskMetadataBean(String taskId, Set<TopicPartitionBean> topicPartitions) {
        this.taskId = taskId;
        this.topicPartitions = topicPartitions;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Set<TopicPartitionBean> getTopicPartitions() {
        return topicPartitions;
    }

    public void setTopicPartitions(Set<TopicPartitionBean> topicPartitions) {
        this.topicPartitions = topicPartitions;
    }

    @Override
    public String toString() {
        return "TaskMetadataBean{" +
                "taskId='" + taskId + '\'' +
                ", topicPartitions=" + topicPartitions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskMetadataBean that = (TaskMetadataBean) o;
        return Objects.equals(taskId, that.taskId) &&
                Objects.equals(topicPartitions, that.topicPartitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, topicPartitions);
    }
}
