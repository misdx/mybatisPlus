package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class StudentInfo  implements Serializable {
    private Integer stuid;
    private Integer stuint;
    private String stuname;
    private Integer stuage;
    private String stusex;
    private String stucard;
    private Date stujointime;
    private String stuaddress;
    private Integer sclassid;
}
