package org.example.rickandmortyapi.model;

import java.util.List;

public record RMCharacterDTO(RMInfo info, List<RMCharakter> results) {
}
