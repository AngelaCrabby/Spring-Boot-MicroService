package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)   // constructor with all args
@Embeddable // this class can be embedded into another class: e.g: RunningInformation class
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String username;
    private String address;

}
