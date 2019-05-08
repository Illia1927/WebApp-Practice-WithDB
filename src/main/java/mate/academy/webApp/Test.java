package mate.academy.webApp;

import mate.academy.webApp.dao.CodeDao;
import mate.academy.webApp.dao.impl.CodeDaoImpl;
import mate.academy.webApp.model.Code;

public class Test {
    public static void main(String[] args) {
        CodeDao codeDao = new CodeDaoImpl();
        Code code = new Code(2L, 1L, 1L, "1488");
        codeDao.addCode(code);
        System.out.println(codeDao.getCodeByValue("1488"));
        codeDao.deleteCodeById(2L);
        System.out.println(codeDao.getCodeByValue("1488"));
    }
}
