package xiaowu.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import xiaowu.domain.User;

import java.util.List;

public interface IUserDao {
    @Select(value = "select * from user")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday")
    })
    List<User> findAll();

    @Select(value = "select 8 from user where id=#{uid}")
    @ResultMap("userMap")
    User findById(Integer userId);
}
