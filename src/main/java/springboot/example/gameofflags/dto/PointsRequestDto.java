package springboot.example.gameofflags.dto;

import lombok.Data;

@Data
public class PointsRequestDto {
    private Long flagId;
    private Long answerId;
    private Long userId;
}
