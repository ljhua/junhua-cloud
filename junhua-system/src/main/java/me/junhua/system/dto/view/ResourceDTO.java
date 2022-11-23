package me.junhua.system.dto.view;

import lombok.Data;
import me.junhua.system.entity.SysResource;

@Data
public class ResourceDTO extends SysResource {
    private Boolean hasChildren;
}
