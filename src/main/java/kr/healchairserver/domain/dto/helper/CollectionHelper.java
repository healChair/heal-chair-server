package kr.healchairserver.domain.dto.helper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.data.util.Streamable;

public class CollectionHelper {

    public static <R, E> List<R> convertNCollect(Streamable<E> entities,
        Function<E, R> of) {
        return entities.stream()
            .map(of)
            .collect(Collectors.toList());
    }
}
