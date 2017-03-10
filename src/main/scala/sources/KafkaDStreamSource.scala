package sources
import core.KafkaPayLoad
import kafka.serializer.DefaultDecoder
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Seconds, StreamingContext}
import kafka.serializer.StringDecoder
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SaveMode, SparkSession}
/**
  * Created by hungdv on 10/03/2017.
  */
class KafkaDStreamSource(configs: Map[String,Object]) {

  def createSource(scc: StreamingContext,topic: String): DStream[KafkaPayLoad] ={
    val kafkaParams = configs
    val kafkaTopics = Set(topic)

    KafkaUtils.createDirectStream[String,String](
      scc,
      PreferConsistent,
      Subscribe[String,String](kafkaTopics,kafkaParams)
    ).map(dstream => KafkaPayLoad(Option(dstream.key),dstream.value))
  }
}
object KafkaDStreamSource{
  def apply(configs: Map[String, String]): KafkaDStreamSource = new KafkaDStreamSource(configs)
}
