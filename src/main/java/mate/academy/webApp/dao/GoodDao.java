package mate.academy.webApp.dao;

import mate.academy.webApp.model.Good;

import java.util.ArrayList;
import java.util.Optional;

public interface GoodDao {
    Long addGood(Good good);

    void updateGood(Long id, Good good);

    void deleteGoodById(Long id);

    Optional<Good> getGoodById(Long id);

    ArrayList<Good> getAllGood();
}
