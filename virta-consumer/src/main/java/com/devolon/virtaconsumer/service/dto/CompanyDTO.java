package com.devolon.virtaconsumer.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO {

    @NotNull
    @Size(max = 100)
    @ApiModelProperty(required = true, example = "F")
    private String name;

    @NotNull
    @Size(max = 100)
    @ApiModelProperty(required = true, example = "F")
    private String code;

    @ApiModelProperty(example = " Comment")
    private String comment;

    @ApiModelProperty(example = "1")
    private Long parentId;

    // ------------------------------

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    @ApiModel("CompanyInfo")
    public static class Info extends CompanyDTO {
        private Long id;
        private Date createdDate;
        private Date lastModifiedDate;
        private Integer version;
    }
    // ------------------------------

    @Getter
    @Setter
    @Accessors(chain = true)
    @ApiModel("CompanyCreateRq")
    public static class Create extends CompanyDTO {

    }

    // ------------------------------

    @Getter
    @Setter
    @Accessors(chain = true)
    @ApiModel("CompanyUpdateRq")
    public static class Update extends CompanyDTO {
        @NotNull
        @ApiModelProperty(required = true)
        private Integer version;
    }
}
