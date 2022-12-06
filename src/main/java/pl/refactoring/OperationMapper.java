package pl.refactoring;


import pl.refactoring.mappers.add.AddDataMapper;
import pl.refactoring.mappers.delete.DeleteDataMapper;
import pl.refactoring.dto.DataToSent;
import pl.refactoring.enums.KindOfOperation;
import pl.refactoring.interfaces.InformationType;
import pl.refactoring.mappers.update.UpdateDataMapper;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum OperationMapper {
    ADD(KindOfOperation.ADD, new AddDataMapper()::createInformationType),
    UPDATE(KindOfOperation.UPDATE, new UpdateDataMapper()::createInformationType),
    REMOVE(KindOfOperation.DELETE, new DeleteDataMapper()::createInformationType);

    private final KindOfOperation kindOfOperation;
    private final Function<DataToSent, ? extends Optional<InformationType>> function;

    OperationMapper(KindOfOperation kindOfOperation, Function<DataToSent, Optional<InformationType>> function) {
        this.kindOfOperation = kindOfOperation;
        this.function = function;
    }

    public static Optional<InformationType> apply(DataToSent data) {
        return findBy(data.getKindOfOperation())//
                .map(OperationMapper::getFunction)//
                .flatMap(operation -> operation.apply(data));
    }

    public static Optional<OperationMapper> findBy(KindOfOperation kindOfOperation) {
        return Stream.of(values())//
                .filter(isTheSameTypeOfOperation(kindOfOperation))//
                .findFirst();
    }

    private static Predicate<OperationMapper> isTheSameTypeOfOperation(KindOfOperation kindOfOperation) {
        return operation -> operation.getKindOfOperation().equals(kindOfOperation);
    }

    public KindOfOperation getKindOfOperation() {
        return kindOfOperation;
    }

    public Function<DataToSent, ? extends Optional<InformationType>> getFunction() {
        return function;
    }

}