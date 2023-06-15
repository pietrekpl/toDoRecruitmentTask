package toDoAppRecruitmentTask.toDoAppRecruitmentTask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Status {

    @JsonProperty("not_started")
    NOT_STARTED,
    @JsonProperty("pending")
    PENDING,
    @JsonProperty("completed")
    COMPLETED
}
