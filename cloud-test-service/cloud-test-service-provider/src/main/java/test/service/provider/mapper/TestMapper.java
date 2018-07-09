package test.service.provider.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import test.service.api.model.Test;
import test.service.provider.sql.TestSqlProvider;

import java.util.List;


@Mapper
@Component
public interface TestMapper {
    /**
    * @method :方法名	deleteByPrimaryKey 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Long id] 
	* @return :返回值	int
    */
    @Delete({
        "delete from test",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
    * @method :方法名	insert 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	int
    */
    @Insert({
        "insert into test (id, birthday, ",
        "money, name)",
        "values (#{id,jdbcType=BIGINT}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{money,jdbcType=DECIMAL}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Test record);

    /**
    * @method :方法名	insertSelective 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	int
    */
    @InsertProvider(type=TestSqlProvider.class, method="insertSelective")
    int insertSelective(Test record);

    /**
    * @method :方法名	selectByPrimaryKey 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Long id] 
	* @return :返回值	test.service.api.model.Test
    */
    @Select({
        "select",
        "id, birthday, money, name",
        "from test",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="money", property="money", jdbcType=JdbcType.DECIMAL),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Test selectByPrimaryKey(Long id);

    /**
    * @method :方法名	updateByPrimaryKeySelective 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	int
    */
    @UpdateProvider(type=TestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Test record);

    /**
    * @method :方法名	updateByPrimaryKey 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	int
    */
    @Update({
        "update test",
        "set birthday = #{birthday,jdbcType=TIMESTAMP},",
          "money = #{money,jdbcType=DECIMAL},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Test record);

    @Select("select * from test")
    List<Test>  listTest();
}