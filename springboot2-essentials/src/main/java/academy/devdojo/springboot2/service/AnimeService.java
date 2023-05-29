package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Anime findByIdOrThrownBadRequestException(Long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public List<Anime> list(){
        return animeRepository.findAll();
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();

        return animeRepository.save(anime);
    }

    public void delete(Long id){
        animeRepository.delete(findByIdOrThrownBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
        Anime animeSaved = findByIdOrThrownBadRequestException(animePutRequestBody.getId());

        Anime anime = Anime.builder()
                .id(animeSaved.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);
    }
}
