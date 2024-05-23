package cn.guruguru.template.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @TableField
    private String username;

    @TableField
    private String password;
}
