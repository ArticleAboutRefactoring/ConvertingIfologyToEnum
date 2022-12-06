package pl.refactoring.dto;

import pl.refactoring.enums.KindOfOperation;

public class DataToSent {
    private final KindOfOperation kindOfOperation;

    public DataToSent(KindOfOperation kindOfOperation) {
        this.kindOfOperation = kindOfOperation;
    }

    public KindOfOperation getKindOfOperation() {
        return kindOfOperation;
    }
}
