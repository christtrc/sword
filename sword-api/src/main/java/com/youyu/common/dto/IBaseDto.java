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
package com.youyu.common.dto;

import java.io.Serializable;

/**
 * dto 顶级接口
 * @author superwen
 * @date 2018/9/5 上午10:10
 */
public interface IBaseDto<E> extends Serializable {
    /**
     * 获得id
     * @return
     */
    E getId();

    /**
     * 设置id
     * @param id
     */
    void setId(E id);
}
