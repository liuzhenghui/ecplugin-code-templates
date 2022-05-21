#set($className = ${NAME})
#set($classNameLower = $className.substring(0,1).toLowerCase() + ${className.substring(1)})
#set($packageName = ${PACKAGE_NAME})
#set($lastPackageName = ${PACKAGE_NAME})
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};
#set($start=$packageName.lastIndexOf(".") + 1)
    #set($lastPackageName=$packageName.substring($start))
#end
##
## 如果类名是xxxDto
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "$classNameLower", description = "请补充描述")
public class ${NAME} {
    @ApiModelProperty("id")
    Integer id;
}