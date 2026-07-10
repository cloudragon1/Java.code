package com.ruoyi.m;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.data.domain.CarCleaned;
import com.ruoyi.data.service.ICarCleanedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.Callback;
import java.util.Properties;



@RestController
@RequestMapping("/mobile")
public class MobileController extends BaseController
{
    @Autowired
    private ICarCleanedService carCleanedService;

    @GetMapping("/list")
    public String list()
    {
        return "a:'123',b:'234'";
    }

    @PostMapping("/add")
    public String add(@RequestBody CarCleaned carCleaned)
    {
        try {
            // 把实时模拟数据，插入到清洗后的表，也要影响离线分析解结果
            carCleanedService.insertCarCleaned(carCleaned);
            //把实时模拟数据，推入kafka(即当前代码作为kafka生产者)，以便spark streaming进行消费，分析
            Properties props = new Properties();
            props.put("bootstrap.servers", "10.218.7.100:9092");  // Kafka 地址
            props.put("acks", "0");             // 不等待 Broker 确认（最高吞吐）
            props.put("retries", 0);            // 失败不重试
            props.put("batch.size", 16384);     // 批量发送缓冲区 16KB
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            String message = JSON.toJSONString(carCleaned);
            java.util.UUID uuid = java.util.UUID.randomUUID();
            String key = uuid.toString();  // 随机生成key
            toKafka(key, message, props);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    /**
     * 发送单条消息到 Kafka
     * @param key       消息序号（作为 Key）
     * @param message 消息体
     * @param props   Producer 配置
     */
    public static void toKafka(String key, String message, Properties props) {
        try {
            Producer<String, String> producer = new KafkaProducer<>(props);
            ProducerRecord<String, String> record = new ProducerRecord<>("sale_count",key , message);

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    } else {
                        System.out.println("发送成功");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
