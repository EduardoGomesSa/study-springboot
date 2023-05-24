package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("anime")
public class AnimeController {
    private DateUtil dateUtil;
    public AnimeController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }
    @GetMapping(path = "/list")
    public List<Anime> list(){
        //log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("One Piece"), new Anime("Naruto"), new Anime("CDZ"));
    }
}
