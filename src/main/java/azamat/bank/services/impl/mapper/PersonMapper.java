package azamat.bank.services.impl.mapper;

import azamat.bank.repository.model.person.Person;
import azamat.bank.services.model.person.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Azamat on 4/10/2016.
 */

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);
}
