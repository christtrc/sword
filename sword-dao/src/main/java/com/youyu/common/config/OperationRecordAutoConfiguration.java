/*
 *    Copyright 2018-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.youyu.common.config;

import com.youyu.common.constant.CommonConfigConstant;
import com.youyu.common.interceptor.OperationRecordInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

/**
 * 启用操作记录拦截注入
 *
 * @see com.youyu.common.interceptor.OperationRecordInterceptor
 *
 * @author WangSongJun
 * @date 2019-08-30
 */
@Slf4j
@Configuration
@ConditionalOnBean({SqlSessionFactory.class})
@EnableConfigurationProperties({PageHelperProperties.class})
@AutoConfigureAfter({MybatisAutoConfiguration.class})
@ConditionalOnProperty(name = CommonConfigConstant.COMMON_PREFIX + "operationRecord.enabled", matchIfMissing = true)
public class OperationRecordAutoConfiguration {
    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void addPageInterceptor() {
        log.info("启用操作记录拦截注入");
        Iterator var3 = this.sqlSessionFactoryList.iterator();
        OperationRecordInterceptor operationRecordInterceptor = new OperationRecordInterceptor();
        while (var3.hasNext()) {
            SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) var3.next();
            sqlSessionFactory.getConfiguration().addInterceptor(operationRecordInterceptor);
        }
    }
}
