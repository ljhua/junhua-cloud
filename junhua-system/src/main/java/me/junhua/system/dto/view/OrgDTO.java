package me.junhua.system.dto.view;

import lombok.Data;
import me.junhua.system.entity.SysOrg;

@Data
public class OrgDTO extends SysOrg {
    private Boolean hasChildren;
}
