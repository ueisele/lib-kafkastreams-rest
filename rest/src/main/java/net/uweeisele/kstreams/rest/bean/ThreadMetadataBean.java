package net.uweeisele.kstreams.rest.bean;

import org.apache.kafka.streams.processor.ThreadMetadata;

import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ThreadMetadataBean {

    private String threadName;

    private String threadState;

    private Set<TaskMetadataBean> activeTasks;

    private Set<TaskMetadataBean> standbyTasks;

    private String mainConsumerClientId;

    private String restoreConsumerClientId;

    private Set<String> producerClientIds;

    private String adminClientId;

    public ThreadMetadataBean() {
    }

    public ThreadMetadataBean(ThreadMetadata threadMetadata) {
        this(threadMetadata.threadName(),
                threadMetadata.threadState(),
                threadMetadata.activeTasks().stream().map(TaskMetadataBean::new).collect(toSet()),
                threadMetadata.standbyTasks().stream().map(TaskMetadataBean::new).collect(toSet()),
                threadMetadata.consumerClientId(),
                threadMetadata.restoreConsumerClientId(),
                threadMetadata.producerClientIds(),
                threadMetadata.adminClientId());
    }

    public ThreadMetadataBean(String threadName,
                              String threadState,
                              Set<TaskMetadataBean> activeTasks,
                              Set<TaskMetadataBean> standbyTasks,
                              String mainConsumerClientId,
                              String restoreConsumerClientId,
                              Set<String> producerClientIds,
                              String adminClientId) {
        this.threadName = threadName;
        this.threadState = threadState;
        this.activeTasks = activeTasks;
        this.standbyTasks = standbyTasks;
        this.mainConsumerClientId = mainConsumerClientId;
        this.restoreConsumerClientId = restoreConsumerClientId;
        this.producerClientIds = producerClientIds;
        this.adminClientId = adminClientId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }

    public Set<TaskMetadataBean> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTasks(Set<TaskMetadataBean> activeTasks) {
        this.activeTasks = activeTasks;
    }

    public Set<TaskMetadataBean> getStandbyTasks() {
        return standbyTasks;
    }

    public void setStandbyTasks(Set<TaskMetadataBean> standbyTasks) {
        this.standbyTasks = standbyTasks;
    }

    public String getMainConsumerClientId() {
        return mainConsumerClientId;
    }

    public void setMainConsumerClientId(String mainConsumerClientId) {
        this.mainConsumerClientId = mainConsumerClientId;
    }

    public String getRestoreConsumerClientId() {
        return restoreConsumerClientId;
    }

    public void setRestoreConsumerClientId(String restoreConsumerClientId) {
        this.restoreConsumerClientId = restoreConsumerClientId;
    }

    public Set<String> getProducerClientIds() {
        return producerClientIds;
    }

    public void setProducerClientIds(Set<String> producerClientIds) {
        this.producerClientIds = producerClientIds;
    }

    public String getAdminClientId() {
        return adminClientId;
    }

    public void setAdminClientId(String adminClientId) {
        this.adminClientId = adminClientId;
    }

    @Override
    public String toString() {
        return "ThreadMetadataBean{" +
                "threadName='" + threadName + '\'' +
                ", threadState='" + threadState + '\'' +
                ", activeTasks=" + activeTasks +
                ", standbyTasks=" + standbyTasks +
                ", mainConsumerClientId='" + mainConsumerClientId + '\'' +
                ", restoreConsumerClientId='" + restoreConsumerClientId + '\'' +
                ", producerClientIds=" + producerClientIds +
                ", adminClientId='" + adminClientId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadMetadataBean that = (ThreadMetadataBean) o;
        return Objects.equals(threadName, that.threadName) &&
                Objects.equals(threadState, that.threadState) &&
                Objects.equals(activeTasks, that.activeTasks) &&
                Objects.equals(standbyTasks, that.standbyTasks) &&
                Objects.equals(mainConsumerClientId, that.mainConsumerClientId) &&
                Objects.equals(restoreConsumerClientId, that.restoreConsumerClientId) &&
                Objects.equals(producerClientIds, that.producerClientIds) &&
                Objects.equals(adminClientId, that.adminClientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadName, threadState, activeTasks, standbyTasks, mainConsumerClientId, restoreConsumerClientId, producerClientIds, adminClientId);
    }
}
