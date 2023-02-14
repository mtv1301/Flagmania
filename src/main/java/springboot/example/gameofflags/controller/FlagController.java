package springboot.example.gameofflags.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.gameofflags.service.FlagService;

@RestController
@RequestMapping("/flags")
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> startGame() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(flagService.startGame());
    }

    @GetMapping
    public ResponseEntity<byte[]> getImageOfFlag(@RequestParam String path)
            throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(flagService.getImageOfFlagByPath(path));
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountryNamesByCodeFlags(@RequestParam List<String> codeFlags) {
        return ResponseEntity
                .ok()
                .body(flagService.getCountryNamesByCodeFlags(codeFlags));
    }
}
