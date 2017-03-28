package azamat.bank.services.impl.mapper;

import azamat.bank.repository.model.user.User;
import azamat.bank.services.model.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Azamat on 4/10/2016.
 */
/**
 * UserMapper transforms entity to dto objects and vice versa.
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}