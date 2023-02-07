package springboot.example.gameofflags.dto.request;

import lombok.Data;

@Data
public class ChangePointsRequest {
    private Long flagId;
    private Long answerId;
    private Long userId;
}
