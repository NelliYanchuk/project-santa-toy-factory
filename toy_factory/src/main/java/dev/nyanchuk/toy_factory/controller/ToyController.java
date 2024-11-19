package dev.nyanchuk.toy_factory.controller;

import java.util.List;

import dev.nyanchuk.toy_factory.dto.*;
import dev.nyanchuk.toy_factory.model.BadToy;
import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.repository.*;
import dev.nyanchuk.toy_factory.singleton.ToyRepositorySingleton;
import dev.nyanchuk.toy_factory.view.*;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void postGoodToy(GoodToyDTO goodToyDto) {

        GoodToy toy = new GoodToy(goodToyDto.title(), true, goodToyDto.brand(), goodToyDto.recommendedAge(), goodToyDto.category());
        repository.setDB("good_toy");
        repository.saveGoodToy(toy);
        ElfView.addToyResponse();
    }

    public void postBadToy(BadToyDTO badToyDto) {
        
        BadToy toy = new BadToy(badToyDto.title(), false, badToyDto.content());
        repository.setDB("bad_toy");
        repository.saveBadToy(toy);
        ElfView.addToyResponse();
    }

    // Method to show all good toys
    public void showGoodToys() {
        // Set the repository to fetch good toys
        repository.setDB("good_toy");

        // Fetching all good toys from the repository
        List<GoodToy> goodToys = (List<GoodToy>) repository.getToys();

        // Passing the list of good toys to the view to display
        ToyView.displayGoodToys(goodToys);
    }



}