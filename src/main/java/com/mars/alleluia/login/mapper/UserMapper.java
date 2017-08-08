package com.mars.alleluia.login.mapper;

import com.mars.alleluia.login.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(real_name, nick_name, gender, mobile, register_date, job)"
            +
            "VALUE(#{realname}, #{nickname}, #{gender}, #{mobile}, #{job})")
    int createUser(User user);

    @Select("SELECT * FROM user WHERE user_id = #{uid}")
    User queryUserById(@Param("uid") int uid);
}
