package logixtek.moitech.leetcode;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

/**
 * @author ngoclinh
 */
public class EmpConsumer {

    public static void main(String[] args) {
        String bootstrapServers = "10.20.199.3:9092";
        String topic = "test-employees-update";
        String groupId = "test-consumer-group";

        // Cấu hình Kafka consumer
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Cấu hình SASL_PLAINTEXT
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config",
                  "org.apache.kafka.common.security.plain.PlainLoginModule required " +
                  "username=\"kido\" password=\"h9juZYfFtfR\";");

        // Tạo consumer và subscribe topic
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(java.util.Collections.singletonList(topic));

        // Lấy và in thông tin các message từ topic
        while (true) {
            consumer.poll(java.time.Duration.ofMillis(1000))
                    .forEach(record -> {
                        System.out.println("Received message: " + record.value());
                    });
        }
    }
}
