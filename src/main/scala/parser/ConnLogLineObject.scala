package parser

/**
  * Created by hungdv on 08/03/2017.
  */
/**
  *
  * @param time
  * @param sessID
  * @param conType
  * @param name
  * @param content1 [SignIn-LogOff - Content1 ~ NASName ] [Reject- Content1 ~ rejectCause]
  * @param content2 [unidentified or rejrectResult]
  */
case class ConnLogLineObject(
                      time:      String,
                      sessID:    String,
                      conType:   String,
                      name:      String,
                      content1:  String,
                      content2:  String
                      ) extends AbtractLogLine{

}
object ConnLogLineObject
{

}
