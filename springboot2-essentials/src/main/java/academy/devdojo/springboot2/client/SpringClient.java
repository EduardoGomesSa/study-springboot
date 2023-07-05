package academy.devdojo.springboot2.client;


import academy.devdojo.springboot2.domain.Anime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SpringClient {

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(SpringClient.class);

        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
        logger.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        logger.info(object);

        Anime[] animesArray = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        logger.info(Arrays.toString(animesArray));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        logger.info(exchange.getBody());

        Anime isekai = Anime.builder().name("Sword Art Online").build();
        Anime animeSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", isekai, Anime.class);
        logger.info("Anime saved {}", animeSaved);
    }
}
