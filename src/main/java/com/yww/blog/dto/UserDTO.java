package com.yww.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     用户传输对象
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/6 16:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;

    private String username;

    private String avatar;

    private String locked;

    private String name;

}
