package org.fit5042.heritagespringboot.controller;

import org.fit5042.heritagespringboot.entity.Heritage;
import org.fit5042.heritagespringboot.repository.HeritageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeritageController {
    @Autowired
    private HeritageRepository heritageRepository;
}
