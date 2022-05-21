#set($className = ${NAME})
#set($classNameLower = $className.substring(0,1).toLowerCase() + ${className.substring(1)})
#set($packageName = ${PACKAGE_NAME})
#set($lastPackageName = ${PACKAGE_NAME})
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};
#set($start=$packageName.lastIndexOf(".") + 1)
    #set($lastPackageName=$packageName.substring($start))
#end

import lombok.extern.slf4j.Slf4j;
import com.ecplugin.common.dto.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

@Slf4j
@Api(value = "${NAME}", tags = "${NAME}")
@Path("/$lastPackageName/$classNameLower.replace("Api","")")
public class ${NAME} {

    @ApiOperation(value = "获取xx列表", notes = "获取xx列表", httpMethod = "GET")
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<String>> list(
            @ApiParam(value = "name") @QueryParam("name") String name,
            @Context HttpServletRequest request,
            @Context HttpServletResponse response
    ) {
        ApiResult<List<String>> result = new ApiResult<>();
        try {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("参数[name]不能为空");
            }

            result.success(null);
        } catch (IllegalArgumentException e) {
            // 入参异常
            log.warn(e.getMessage());
            result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("list", e);
            result.fail(e.getMessage());
        }
        return result;
    }


}