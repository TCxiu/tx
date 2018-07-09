package test.service.provider.sql;

import org.apache.ibatis.jdbc.SQL;
import test.service.api.model.Test;

public class TestSqlProvider {

    /**
    * @method :方法名	insertSelective 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	java.lang.String
    */
    public String insertSelective(Test record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("test");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMoney() != null) {
            sql.VALUES("money", "#{money,jdbcType=DECIMAL}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
    * @method :方法名	updateByPrimaryKeySelective 
	* @description :方法作用描述	 
	* 
	* @param :参数	[Test record] 
	* @return :返回值	java.lang.String
    */
    public String updateByPrimaryKeySelective(Test record) {
        SQL sql = new SQL();
        sql.UPDATE("test");
        
        if (record.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMoney() != null) {
            sql.SET("money = #{money,jdbcType=DECIMAL}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}