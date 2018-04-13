/**
 * Project Name:goldChannel
 * File Name:TransactionDaoImpl.java
 * Package Name:com.golden.transaction.dao.impl
 * Date:2016年11月16日下午3:55:55
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.transaction.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.transaction.dao.TransactionDao;


/**
 * ClassName:TransactionDaoImpl <br/>
 * Function: 交易记录Dao 实现层
 * Date:     2016年11月16日 下午3:55:55 <br/>
 * @author   wusihao
 * @version  
 * @since    JDK 1.7
 * @see      
 */
@Component
public class TransactionDaoImpl extends BaseDao implements TransactionDao {

    @Override
    public void createTransaction(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().insert("TransactionSqlMap.createTransaction", map);
    }

}

