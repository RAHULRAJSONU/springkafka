## Launching the Application
```docker-compose up```

logs
```
Starting kafka-spring-example-app_kafka_1     ... done

Starting kafka-spring-example-app_zookeeper_1 ... done

Attaching to kafka-spring-example-app_kafka_1, kafka-spring-example-app_zookeeper_1
```

Then we run our spring application. Please note the message below. We can see that the example-group, according to our assumptions, assigned two partitions transaction-1-0 and transaction-1-1.
```
INFO 67372 --- [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : transation-topic: partitions assigned: [transaction-1-0, transaction-1-1]
```
Now let’s perform the POST operation
```
POST https://localhost:8081/api/kafka
Content-Type: application/json
Accept: application/json

{
"holder": "Tonny",
"funds": "2000"
}
```
The output should look like this
```
INFO 67372 --- [ntainer#0-0-C-1] com.kafka.example.app.kafka.Controller   : Topic [transaction-1] Received message from Tonny with 2000 PLN

INFO 67372 --- [ntainer#0-0-C-1] com.kafka.example.app.kafka.Controller   : ConsumerRecord(topic = transaction-1, partition = 0, leaderEpoch = 0, offset = 2, CreateTime = 1613718756987, serialized key size = -1, serialized value size = 33, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = com.kafka.example.app.kafka.Account@2538a849)
```

We can see that the message we sent earlier went to the first topic as first. You should pay attention to the next log, the topic and the allocated partition in particular. 