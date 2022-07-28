package com.clonelol.config.dto;

import com.clonelol.config.dto.property.VersionInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionDto {

    private List<VersionInfo> N = new ArrayList<>();
    private String V;
    private String L;
    private String cdn;
    private String dd;
    private String lg;
    private String css;
    private Integer profileiconmax;
}
