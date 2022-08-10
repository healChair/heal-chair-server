package kr.healchairserver.service;

import static kr.healchairserver.domain.dto.FastChargerDto.Create;
import static kr.healchairserver.domain.dto.FastChargerDto.Result;
import java.util.List;
import kr.healchairserver.domain.model.FastCharger;
import kr.healchairserver.repository.FastChargerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FastChargerService {

    private final FastChargerRepository fastChargerRepository;

    @Transactional
    protected Result create(Create dto) {
        FastCharger fastCharger = dto.asEntity();

        return Result.of(fastChargerRepository.save(fastCharger));
    }

    public List<Result> search(Pageable pageable) {
        Page<FastCharger> fastChargers = fastChargerRepository.findAll(pageable);
        return Result.of(fastChargers);
    }

    @Transactional
    public void bulkDelete() {
        fastChargerRepository.deleteAllInBatch();
    }
}
