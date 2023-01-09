package springboot.example.gameofflags.dto;

import lombok.Data;

@Data
public class PointsRequestDto {
    private Long idFlag;
    private Long idAnswer;
    private Long userId;
}
