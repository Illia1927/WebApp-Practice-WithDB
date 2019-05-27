package mate.academy.webApp.dao.jdbcDao;

import mate.academy.webApp.model.Code;

import java.util.Optional;

public interface CodeDao {

    void addCode(Code code);

    Optional<Code> getCodeByValue(String value);

    Optional<Code> getCodeById(Long userId, String value);

    void deleteCodeById(Long id);
}
