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

import com.youyu.common.bean.SpringContextBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pqq
 * @version v1.0
 * @date 2019年7月18日 17:00:00
 * @work SpringContextBean自动装配
 */
@Configuration
@ConditionalOnClass(SpringContextBean.class)
public class SpringContextBeanConfiguration {

    @Bean
    @ConditionalOnMissingBean(SpringContextBean.class)
    public SpringContextBean springContextBean() {
        SpringContextBean springContextBean = new SpringContextBean();
        return springContextBean;
    }
}
