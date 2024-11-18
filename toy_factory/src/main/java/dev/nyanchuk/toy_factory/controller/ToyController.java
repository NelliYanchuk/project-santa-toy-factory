package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.dto.*;
import dev.nyanchuk.toy_factory.repository.*;
import dev.nyanchuk.toy_factory.view.*;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = new ToyRepository();
    }

    public void postGoodToy(GoodToyDTO goodToyDto) {
        
        ElfView.addToyResponse();
    }

}