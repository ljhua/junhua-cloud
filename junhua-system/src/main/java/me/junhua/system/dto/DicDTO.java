package me.junhua.system.dto;

import lombok.Data;
import me.junhua.system.entity.SysDic;

@Data
public class DicDTO extends SysDic {
    private Boolean hasChildren;
}
