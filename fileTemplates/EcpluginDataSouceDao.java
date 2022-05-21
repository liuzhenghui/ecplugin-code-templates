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
import weaver.conn.RecordSetDataSource;
##
#parse("File Header.java")
##
@Slf4j
public class ${NAME} {
    public static ${NAME} $classNameLower = new ${NAME}();
    
    static final String DATA_SROUECE_NAME = "mes";
        public String checkSyzdm(String syzdm) {
        String szygh = "";
        RecordSetDataSource recordSetDataSource = new RecordSetDataSource(DATA_SROUECE_NAME);
        String sql = "select user_lname from V_MES_ROLE_DEPARTMENT_INFO WHERE user_id = '" + syzdm +"'";
        log.info(sql);
        recordSetDataSource.executeQueryWithDatasource(sql, DATA_SROUECE_NAME);

        if (recordSetDataSource.next()) {
            szygh = Util.null2String(recordSetDataSource.getString("user_lname"));
        }
        return szygh;
    }
}
