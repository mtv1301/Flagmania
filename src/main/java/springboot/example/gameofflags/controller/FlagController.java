package springboot.example.gameofflags.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FlagService flagService;

    @RequestMapping(value = "/next", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> startGame() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(flagService.startGame());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> getFlag(@RequestParam String path)
            throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(flagService.getFlagByPath(path));
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountryByFlag(@RequestParam List<String> codeFlags) {
        return ResponseEntity
                .ok()
                .body(flagService.getCountryByFlag(codeFlags));
    }
}
