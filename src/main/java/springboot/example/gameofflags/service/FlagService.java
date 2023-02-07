package springboot.example.gameofflags.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Service
@Log4j2
public class FlagService {
    private final List<String> CODE_FLAGS = Arrays.asList("AD", "AF", "AG", "AL", "AO", "AR",
            "AT", "AU", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ",
            "BN", "BO", "BR", "BS", "BT", "BW", "BY", "BZ", "DZ");

    public List<String> startGame() {
        int index = 0;
        List<String> listCountries = new ArrayList<>();
        for (int i = 0; i < CODE_FLAGS.size(); i++) {
            index = (int)(Math.random() * CODE_FLAGS.size());
        }
        for (int i = 0; i < 3; i++) {
            listCountries.add(CODE_FLAGS.get((int)(Math.random() * CODE_FLAGS.size())));
        }
        listCountries.add(CODE_FLAGS.get(index));
        List<String> entities = new ArrayList<>(listCountries);
        entities.add("flags/" + CODE_FLAGS.get(index) + ".png");
        log.info("Random flags: " + entities + " are shown for user.");
        return entities;
    }

    public byte[] getFlagByPath (String path) throws IOException {
        ClassPathResource imgFile = new ClassPathResource(path);
        log.info("Flag with path: " + path + " are shown for user.");
        return StreamUtils.copyToByteArray(imgFile.getInputStream());
    }

    public List<String> getCountryByFlag(List<String> codeFlags) {
        List<String> countries = new ArrayList<>();
        for (String cf: codeFlags) {
            Locale obj = new Locale("", cf);
            countries.add(obj.getDisplayCountry());
        }
        log.info("Country name: " + countries + " are shown for user.");
        return countries;
    }
}
