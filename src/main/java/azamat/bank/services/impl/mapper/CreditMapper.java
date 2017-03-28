package azamat.bank.services.impl.mapper;

import azamat.bank.repository.model.credit.Credit;
import azamat.bank.services.model.credit.CreditDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Azamat on 4/11/2016.
 */
@Mapper
public interface CreditMapper {

    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    CreditDto creditToCreditDto(Credit credit);

    Credit creditDtoToCredit(CreditDto creditDto);
}
