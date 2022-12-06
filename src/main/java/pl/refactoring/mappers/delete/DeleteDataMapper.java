package pl.refactoring.mappers.delete;

import pl.refactoring.interfaces.ApiMethodMapper;
import pl.refactoring.dto.DataToSent;
import pl.refactoring.interfaces.InformationType;

import java.util.Optional;

public class DeleteDataMapper implements ApiMethodMapper<InformationType> {
    @Override
    public Optional<InformationType> createInformationType(DataToSent data) {
        return Optional.empty();
    }
}
