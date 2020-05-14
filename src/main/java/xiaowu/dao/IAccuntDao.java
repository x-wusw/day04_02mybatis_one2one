package xiaowu.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import xiaowu.domain.Account;
import xiaowu.domain.User;

import java.util.List;

public interface IAccuntDao {
    /*
    查询所有
     */
    @Select(value = "select * from account")
    @Results(id = "true",
            value = {
                @Result(id=true,column = "id",property = "id"),
                @Result(column = "uid",property = "uid"),
                @Result(column = "money",property = "money"),
                @Result(column = "uid",property = "user",
                    one = @One(select = "xiaowu.dao.IUserDao.findById",fetchType = FetchType.LAZY ))

    })
    List<Account> findAll();

}
