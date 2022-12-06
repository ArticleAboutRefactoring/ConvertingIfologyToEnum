package pl.refactoring.mappers.update;

import pl.refactoring.interfaces.ApiMethodMapper;
import pl.refactoring.dto.DataToSent;
import pl.refactoring.interfaces.InformationType;

import java.util.Optional;

public class UpdateDataMapper implements ApiMethodMapper<InformationType> {
    @Override
    public Optional<InformationType> createInformationType(DataToSent data) {
        return Optional.empty();
    }
}
