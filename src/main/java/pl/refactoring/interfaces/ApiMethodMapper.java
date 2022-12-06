package pl.refactoring.interfaces;

import pl.refactoring.dto.DataToSent;

import java.util.Optional;

public interface ApiMethodMapper<InformationType>
{
  Optional<InformationType> createInformationType(DataToSent data);
}
