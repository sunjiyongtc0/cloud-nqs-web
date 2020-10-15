import com.acsno.common.util.SnowflakeConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class test {

//    @Autowired
//    static SnowflakeConfig snowflakeConfig;

    public static void main(String[] args) {
        SnowflakeConfig snowflakeConfig=new SnowflakeConfig();
        Long l=snowflakeConfig.snowflakeId();
        System.out.println(l);
    }
}
