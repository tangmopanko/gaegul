package kr.hyeongmeme.gaegulbot.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class SimpleResponse {
    private String version;
    private String bleat;
    private String address;
    private String profile;
}
