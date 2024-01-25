package it.unibs.se_project.business.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.business.GenereExtra;

public class GeneriExtraDictionary {
    private HashMap<String, GenereExtra> generiExtraMap;

    @JsonCreator
    public GeneriExtraDictionary(
        @JsonProperty("generi_extra") HashMap<String, GenereExtra> generiExtra
    ) {
        this.generiExtraMap = generiExtra;
    }

    public GenereExtra getGenereExtra(String genereExtraName) {
        return generiExtraMap.get(genereExtraName);
    }

    public void putGenereExtra(GenereExtra genereExtra) {
        generiExtraMap.put(genereExtra.getNome(), genereExtra);
    }

    public List<GenereExtra> getGeneriExtraList() {
        return new ArrayList<>(generiExtraMap.values());
    }
}
