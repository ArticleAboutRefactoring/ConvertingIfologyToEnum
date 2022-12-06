package pl.refactoring.mappers.add;

import pl.refactoring.interfaces.ApiMethodMapper;
import pl.refactoring.dto.DataToSent;
import pl.refactoring.interfaces.InformationType;

import java.util.Optional;

public class AddDataMapper  implements ApiMethodMapper<InformationType> {
    public Optional<InformationType> createInformationType(DataToSent data) {
        return Optional.empty();
    }
}
