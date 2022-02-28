package org.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5750631918876888367L;
    private Integer id;

    private String name;

    private Integer age;
}
