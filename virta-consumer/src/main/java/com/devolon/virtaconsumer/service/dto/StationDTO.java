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
public class StationDTO {

    @NotNull
    @Size(max = 100)
    @ApiModelProperty(required = true, example = "S10")
    private String name;

    @NotNull
    @Size(max = 100)
    @ApiModelProperty(required = true, example = "S10")
    private String code;

    @NotNull
    @ApiModelProperty(required = true, example = "35.638397")
    private Double latitude;

    @NotNull
    @ApiModelProperty(required = true, example = "51.18324")
    private Double longitude;

    @ApiModelProperty(example = " Comment")
    private String comment;

    @NotNull
    @ApiModelProperty(required = true, example = "1")
    private Long companyId;

    // ------------------------------

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    @ApiModel("StationInfo")
    public static class Info extends StationDTO {
        private Long id;
        private Double distance;
        private String companyName;
        private Date createdDate;
        private Date lastModifiedDate;
        private Integer version;
    }
    // ------------------------------

    @Getter
    @Setter
    @Accessors(chain = true)
    @ApiModel("StationCreateRq")
    public static class Create extends StationDTO {

    }

    // ------------------------------

    @Getter
    @Setter
    @Accessors(chain = true)
    @ApiModel("StationUpdateRq")
    public static class Update extends StationDTO {
        @NotNull
        @ApiModelProperty(required = true)
        private Integer version;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    @ApiModel("StationDistanceRq")
    public static class Distance {

        private Double latitude;

        private Double longitude;

        private Double radius;
    }
}
