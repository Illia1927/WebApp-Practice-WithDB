package mate.academy.webApp.dao;

import mate.academy.webApp.model.Code;

import java.util.Optional;

public interface CodeDao {

    void addCode(Code code);

    Optional<Code> getCodeByValue(String value);

    Optional<Code> getCodeById(Long userId, String value);

    void deleteCodeById(Long id);
}
