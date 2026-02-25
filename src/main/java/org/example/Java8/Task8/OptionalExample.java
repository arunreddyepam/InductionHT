package org.example.Java8.Task8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class OptionalExample <S> {
    public static void main(String[] args) {
        List<Optional<String>> namesOptional = Arrays.asList(
                Optional.of("John"),
                Optional.empty(),
                Optional.of("Jane"),
                Optional.empty()
        );
    List<String> names = namesOptional.stream().filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println(names);

}};
