package xiaowu.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xiaowu.dao.IAccuntDao;
import xiaowu.domain.Account;
import xiaowu.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        IAccuntDao iAccuntDao = sqlSession.getMapper(IAccuntDao.class);
        List<Account> accounts = iAccuntDao.findAll();
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
