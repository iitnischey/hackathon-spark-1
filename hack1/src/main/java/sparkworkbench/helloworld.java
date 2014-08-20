package sparkworkbench;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class helloworld {

	public String getName() {
		return "Nischey 111a";
	}

	public int job() {
		SparkConf conf = new SparkConf().setAppName("hack1").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile("c:\\abc.txt");
		JavaRDD<Integer> lineLengths = lines.map(new GetLength());
		int totalLength = lineLengths.reduce(new Sum());
		return totalLength;
	}
}

class GetLength implements Function<String, Integer> {
	public Integer call(String s) {
		return s.length();
	}
}

class Sum implements Function2<Integer, Integer, Integer> {
	public Integer call(Integer a, Integer b) {
		return a + b;
	}
}
