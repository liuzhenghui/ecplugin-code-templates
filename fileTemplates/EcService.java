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
import lombok.extern.slf4j.Slf4j;
##
#parse("File Header.java")
##
@Slf4j
public class ${NAME} {
    public static ${NAME} $classNameLower = new ${NAME}();
    
}