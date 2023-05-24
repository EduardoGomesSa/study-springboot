package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("animes")
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;
    private static final Logger logger = LogManager.getLogger(AnimeController.class);

    @GetMapping
    public List<Anime> list(){
        logger.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        //System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        return animeService.listAll();
    }
}
