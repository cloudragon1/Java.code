package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("车辆大数据平台启动成功"+"\n"+
                "           ______________            " +"\n"+
                "         /  __      __   \\           " +"\n"+
                "   _____/  |__|    |__|   \\________     " +"\n"+
                "  /      ___            ___         \\    " +"\n"+
                " |______/ 。 \\_________/ 。 \\________|         " +"\n"+
                "        \\___/          \\___/              "



        );
    }
}
