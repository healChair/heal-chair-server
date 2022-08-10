package kr.healchairserver.domain.dto.helper;

import java.util.function.Function;

public class DtoHelper {


    public static <T> Function<? super T, ? extends T> noInit() {
        return (arg) -> arg;
    }
}
