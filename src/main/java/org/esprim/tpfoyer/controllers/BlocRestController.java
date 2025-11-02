package org.esprim.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Bloc;
import org.esprim.tpfoyer.service.iBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    iBlocService iBlocService;

    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return iBlocService.retrieveAllBloc();
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return iBlocService.retrievebloc(blocId);
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return iBlocService.addBloc(b);
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        iBlocService.removeBloc(blocId);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        return iBlocService.modifyBloc(b);
    }
}
