package kr.healchairserver.controller;

import static kr.healchairserver.domain.dto.FastChargerDto.Result;
import kr.healchairserver.service.FastChargerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class FastChargerController {

    private final FastChargerService service;

    @GetMapping("/fastChargers")
    public Page<Result> search(
        Pageable pageable
    ) {
        return service.search(pageable);
    }
}