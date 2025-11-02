package org.esprim.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Universitie;

import org.esprim.tpfoyer.service.iUniversitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    iUniversitiesService iUniversiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universitie> getUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universitie retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return iUniversiteService.retrieveUniversite(universiteId);
    }

    @PostMapping("/add-universite")
    public Universitie addUniversite(@RequestBody Universitie u) {
        return iUniversiteService.addUniversite(u);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        iUniversiteService.removeUniversite(universiteId);
    }

    @PutMapping("/modify-universite")
    public Universitie modifyUniversite(@RequestBody Universitie u) {
        return iUniversiteService.modifyUniversite(u);
    }
}
