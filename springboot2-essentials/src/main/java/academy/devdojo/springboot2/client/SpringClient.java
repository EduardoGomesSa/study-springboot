package academy.devdojo.springboot2.client;


import academy.devdojo.springboot2.domain.Anime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringClient {

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(SpringClient.class);

        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
        logger.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        logger.info(object);
    }
}
