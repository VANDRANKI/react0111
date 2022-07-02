package me.roybailey.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Task object
 */
public class Task {

    public static class Builder {

        private String guid;
        private String name;
        private String description;
        private LocalDateTime dueDate;
        private Integer effort;
        private Integer progress;

        public Builder withGuid(String guid) {
            this.guid = guid;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDueDate(String dueDate) {
            this.dueDate = LocalDateTime.parse(dueDate, DateTimeFormatter.ISO_DATE_TIME);
            return this;
        }

        public Builder withEffort(int effort) {
            this.effort = effort;
            return this;
        }

        public Builder withProgress(int progress) {
            this.progress = progress;
            return this;
        }

        public Task build() {
            return new Task(
                    (this.guid == null)? UUID.randomUUID().toString() : this.guid,
                    this.name,
                    this.description,
                    this.dueDate,
                    this.effort,
                    this.progress
            );
        }
    }

    public static Builder builder() {
        return new Task.Builder();
    }

    //
    //
    //

    private String guid;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private Integer effort;
    private Integer progress;

    public Task(String guid, String name) {
        this(guid, name, name,
                LocalDateTime.now().plusDays(5),
                100, 0);
    }

    public Task(
            String guid,
            String name,
            String description,
            LocalDateTime dueDate,
            Integer effort,
            Integer progress
    ) {
        this.guid = guid;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.effort = effort;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Task{" +
                "guid=" + guid +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", progress=" + progress +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Integer getEffort() {
        return effort;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return !(guid != null ? !guid.equals(task.guid) : task.guid != null);

    }

    @Override
    public int hashCode() {
        return guid != null ? guid.hashCode() : 0;
    }
}
