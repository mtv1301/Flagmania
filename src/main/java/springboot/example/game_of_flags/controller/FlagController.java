package springboot.example.game_of_flags.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flags")
public class FlagController {
    private final List<String> CODE_FLAGS = Arrays.asList("AD", "AF", "AG", "AL", "AO", "AR",
            "AT", "AU", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ",
            "BN", "BO", "BR", "BS", "BT", "BW", "BY", "BZ", "DZ");

    @RequestMapping(value = "/next", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> startGame() {
        int index = 0;
        ArrayList<String> listCountries = new ArrayList<>();
        for (int i = 0; i < CODE_FLAGS.size(); i++) {
            index = (int)(Math.random() * CODE_FLAGS.size());
        }
        for (int i = 0; i < 3; i++) {
            listCountries.add(CODE_FLAGS.get((int)(Math.random() * CODE_FLAGS.size())));
        }
        listCountries.add(CODE_FLAGS.get(index));
        List<String> entities = new ArrayList<>(listCountries);
        entities.add("flags/" + CODE_FLAGS.get(index) + ".png");
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(entities);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getFlag(@RequestParam String path) throws IOException {
        ClassPathResource imgFile = new ClassPathResource(path);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountryByFlag(@RequestParam("codeFlags") List<String> codeFlags) {
        ArrayList<String> countries = new ArrayList<>();
        for (String cf: codeFlags) {
            Locale obj = new Locale("", cf);
            countries.add(obj.getDisplayCountry());
        }
        System.out.println(countries);
        return ResponseEntity
                .ok()
                .body(countries);
    }
}
