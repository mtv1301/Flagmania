package springboot.example.gameofflags.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import springboot.example.gameofflags.repository.CountryRepository;

@Service
@Log4j2
public class FlagService {
    private final int COUNT_OF_COUNTRIES_FOR_DISPLAY = 4;
    private final CountryRepository countryRepository;

    public FlagService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<String> startGame() {
        List<String> listCountryCods = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_COUNTRIES_FOR_DISPLAY; i++) {
            listCountryCods.add(countryRepository.findById((long) (Math.random() * countryRepository.findAll()
                    .size())).get().getCountryCode());
        }
        List<String> entities = new ArrayList<>(listCountryCods);
        Random rand = new Random();
        entities.add("flags/" + listCountryCods.get(rand.nextInt(listCountryCods.size())) + ".png");
        return entities;
    }

    public byte[] getImageOfFlagByPath(String path) throws IOException {
        ClassPathResource imgFile = new ClassPathResource(path);
        log.info("Flag with path: " + path + " are shown for user.");
        return StreamUtils.copyToByteArray(imgFile.getInputStream());
    }

    public List<String> getCountryNamesByCodeFlags(List<String> codeFlags) {
        List<String> countries = new ArrayList<>();
        for (String cf: codeFlags) {
            Locale obj = new Locale("", cf);
            countries.add(obj.getDisplayCountry());
        }
        return countries;
    }
}
