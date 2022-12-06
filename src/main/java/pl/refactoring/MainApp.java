package pl.refactoring;


import pl.refactoring.mappers.add.AddDataMapper;
import pl.refactoring.mappers.delete.DeleteDataMapper;
import pl.refactoring.dto.DataToSent;
import pl.refactoring.enums.KindOfOperation;
import pl.refactoring.interfaces.InformationType;
import pl.refactoring.mappers.update.UpdateDataMapper;

import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {
        DataToSent data = new DataToSent(KindOfOperation.ADD);
        Optional<InformationType> solutionUsingIfs = solveByIfs(data);
        Optional<InformationType> solutionUsingSwitch = solveBySwitch(data);
        Optional<InformationType> solutionUsingEnum = OperationMapper.apply(data);
    }

    private static Optional<InformationType> solveByIfs(DataToSent data) {
        if (KindOfOperation.ADD.equals(data.getKindOfOperation()))
            return new AddDataMapper().createInformationType(data);
        else if (KindOfOperation.UPDATE.equals(data.getKindOfOperation()))
            return new UpdateDataMapper().createInformationType(data);
        else if (KindOfOperation.DELETE.equals(data.getKindOfOperation()))
            return new DeleteDataMapper().createInformationType(data);

        return Optional.empty();
    }

    private static Optional<InformationType> solveBySwitch(DataToSent data) {
        switch (data.getKindOfOperation()) {
            case ADD:
                return new AddDataMapper().createInformationType(data);
            case UPDATE:
                return new UpdateDataMapper().createInformationType(data);
            case DELETE:
                return new DeleteDataMapper().createInformationType(data);
            default:
                return Optional.empty();
        }
    }

}
