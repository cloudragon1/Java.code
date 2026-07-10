package com.ruoyi.big;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/big")
public class BigController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    // 存入数据
    @GetMapping("/set")
    public AjaxResult setData() {
        redisTemplate.opsForValue().set("username", "zhangsan");
        return AjaxResult.success("存入成功");
    }

    // 读取累计销量
    @GetMapping("/get_count")
    public AjaxResult getCountData() {
        Object obj = redisTemplate.opsForValue().get("car_sale_total");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_gasoline")
    public AjaxResult getGasolineData() {
        Object obj = redisTemplate.opsForValue().get("fuel_gasoline");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_diesel")
    public AjaxResult getDieselData() {
        Object obj = redisTemplate.opsForValue().get("fuel_diesel");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_gas")
    public AjaxResult getGasData() {
        Object obj = redisTemplate.opsForValue().get("fuel_gas");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_hybrid")
    public AjaxResult getHybridData() {
        Object obj = redisTemplate.opsForValue().get("fuel_hybrid");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_male")
    public AjaxResult getMaleData() {
        Object obj = redisTemplate.opsForValue().get("gender_male");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_female")
    public AjaxResult getFemaleData() {
        Object obj = redisTemplate.opsForValue().get("gender_female");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_unknown")
    public AjaxResult getUnknownData() {
        Object obj = redisTemplate.opsForValue().get("gender_unknown");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_taiyuan")
    public AjaxResult taiyuanData() {
        Object obj = redisTemplate.opsForValue().get("city_taiyuan");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_datong")
    public AjaxResult datongData() {
        Object obj = redisTemplate.opsForValue().get("city_datong");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_shuozhou")
    public AjaxResult shuozhouData() {
        Object obj = redisTemplate.opsForValue().get("city_shuozhou");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_xinzhou")
    public AjaxResult xinzhouData() {
        Object obj = redisTemplate.opsForValue().get("city_xinzhou");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_yangquan")
    public AjaxResult yangquanData() {
        Object obj = redisTemplate.opsForValue().get("city_yangquan");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_lvliang")
    public AjaxResult lvliangData() {
        Object obj = redisTemplate.opsForValue().get("city_lüliang");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_jinzhong")
    public AjaxResult jinzhongData() {
        Object obj = redisTemplate.opsForValue().get("city_jinzhong");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_changzhi")
    public AjaxResult changzhiData() {
        Object obj = redisTemplate.opsForValue().get("city_changzhi");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_jincheng")
    public AjaxResult jinchengData() {
        Object obj = redisTemplate.opsForValue().get("city_jincheng");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_linfen")
    public AjaxResult linfenData() {
        Object obj = redisTemplate.opsForValue().get("city_linfen");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    @GetMapping("/get_yuncheng")
    public AjaxResult yunchengData() {
        Object obj = redisTemplate.opsForValue().get("city_yuncheng");
        String result = obj == null ? "0" : String.valueOf(obj);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("data", result);
        return ajax;
    }

    // 删除key
    @GetMapping("/del")
    public AjaxResult delKey() {
        redisTemplate.delete("username");
        return AjaxResult.success("删除完成");
    }

    // 判断key是否存在
    @GetMapping("/has")
    public AjaxResult hasKey() {
        boolean exist = Boolean.TRUE.equals(redisTemplate.hasKey("username"));
        String msg = exist ? "存在" : "不存在";
        return AjaxResult.success(msg);
    }
}