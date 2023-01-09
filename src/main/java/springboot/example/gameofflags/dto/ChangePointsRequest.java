package springboot.example.gameofflags.dto;

import lombok.Data;

@Data
public class ChangePointsRequest {
    private Long idFlag;
    private Long idAnswer;
    private Long userId;
}
