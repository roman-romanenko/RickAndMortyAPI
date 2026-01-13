package org.example.rickandmortyapi.service;

import org.example.rickandmortyapi.model.RMCharacterDTO;
import org.example.rickandmortyapi.model.RMCharakter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RMService {

    private final RestClient restClient;

    public RMService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<RMCharakter> getAllCharacters() {
        return restClient.get()
                .uri("/character")
                .retrieve()
                .body(RMCharacterDTO.class)
                .results();
    }

    public RMCharakter getCharacterById(String id) {
        return restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(RMCharakter.class);
    }

    public List<RMCharakter> getFilteredCharactersByStatus(String status) {
        return restClient.get()
                .uri("/character?status=" + status)
                .retrieve()
                .body(RMCharacterDTO.class)
                .results();
    }

    public long getSpeciesStatistic(String species) {
        return restClient.get()
                .uri("/character?status=alive&species=" + species)
                .retrieve()
                .body(RMCharacterDTO.class)
                .info().count();
    }
}
