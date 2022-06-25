# kafka-basic-tech-primer

Refer to https://kafka.apache.org/quickstart to Start the Kafka environment
- Download the latest Kafka release and extract it
- Start the ZooKeeper service
- Start the Kafka broker service

Use the code from this repo 
- Produce to topic -  Run KafkaProducerApplication 
  * Producer app process events using event handler from api https://stream.wikimedia.org/v2/stream/recentchange
  * Producer app creates & produces events to topic _wikimedia_recentchange_
  * Refer to kafka-producer/application.properties file for producer config
  
- consume from topic - Run KafkaConsumerApplication 
  * Consumer app created consumer group _my-Wikimedia-CG_ 
  * Consumer app reads data from topic _wikimedia_recentchange_ and logs it
  * Refer to kafka-consumer/application.properties file for consumer config

