package azamat.bank.services.impl.mapper;

import azamat.bank.repository.model.application.Application;
import azamat.bank.services.model.application.ApplicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Azamat on 4/10/2016.
 */
/**
 * ApplicationMapper transforms entity to dto objects and vice versa.
 */
@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDto applicationToApplicationDto(Application application);

    Application applicationDtoToApplication(ApplicationDto applicationDto);

}
