package test.service.provider.service;

import com.douyoudian.tx.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.service.api.model.Test;
import test.service.api.service.TestService;
import test.service.provider.mapper.TestMapper;
import test.service.provider.utils.IdFactory;
import java.util.Date;
import java.util.List;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 11:16
 * @Description 类描述:
 */

@RestController
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    @Transactional
    @TxTransaction
    public Boolean addTest(@RequestBody Test test) {
        test.setId(IdFactory.nextId());
        test.setBirthday(new Date());
        int insert = testMapper.insert(test);
        return insert >0 ? true : false;
    }

    @Override
    @Transactional
    @TxTransaction
    public Boolean delTestById(@PathVariable Long id) {
        int i = testMapper.deleteByPrimaryKey(id);

        return i >0 ? true : false;
    }

    @Override
    @Transactional
    @TxTransaction
    public Boolean updateTestById(@PathVariable Long id,@RequestBody  Test record) {

        Test test = testMapper.selectByPrimaryKey(id);
        test.setName(record.getName());
        test.setMoney(test.getMoney().add(record.getMoney().negate()));
        int i = testMapper.updateByPrimaryKey(test);

        return i >0 ? true : false;
    }

    @Override
    @Transactional
    @TxTransaction
    public Test findById(@PathVariable Long id) {
        Test test = testMapper.selectByPrimaryKey(id);
        return test;
    }

    @Override
    @Transactional
    @TxTransaction
    public List<Test> listTest() {
        List<Test> tests = testMapper.listTest();
        return tests;
    }
}
