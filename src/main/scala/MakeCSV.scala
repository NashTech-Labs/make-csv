
import java.io.{BufferedWriter, FileWriter}

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import scala.util.Random

import au.com.bytecode.opencsv.CSVWriter

object MakeCSV extends App {

  val outputFile = new BufferedWriter(new FileWriter("/home/deepak/Desktop/deepak19.csv"))
  val csvWriter = new CSVWriter(outputFile)
  val csvFields = Array("id", "name", "age", "city")
  val nameList = List("Deepak", "Sangeeta", "Geetika", "Anubhav", "Sahil", "Akshay")
  val ageList = (24 to 26).toList
  val cityList = List("Delhi", "Kolkata", "Chennai", "Mumbai")
  val random = new Random()
  var listOfRecords = new ListBuffer[Array[String]]()
  listOfRecords += csvFields
  for (i <- 0 until 10) {
    listOfRecords += Array(i.toString, nameList(random.nextInt(nameList.length))
      , ageList(random.nextInt(ageList.length)).toString, cityList(random.nextInt(cityList.length)))
  }
  csvWriter.writeAll(listOfRecords.toList)
  outputFile.close()
}

