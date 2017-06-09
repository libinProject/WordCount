package topology;

import spout.WordReader;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import bolt.WordCounter;
import bolt.WordSplider;

public class WordCountTopo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if(args.length!=2){
//			System.err.println("Usage:input path timeoffset!");
//			System.err.println("such as : java - jar WordCount.jar D://input/ 2");
//			System.exit(2);
//		}
//		//拓扑构建器
//		TopologyBuilder builder = new TopologyBuilder();
//		//消息源
//		builder.setSpout("word-reader", new WordReader());
//		builder.setBolt("word-splider", new WordSplider()).shuffleGrouping("word-reader");
//		builder.setBolt("word-count", new WordCounter()).shuffleGrouping("word-splider");
//		
//		String inputPath=args[0];
//		String timeOffset=args[1];
//		//配置信息
//		Config config=new Config();
//		config.put("INPUT_PATH", inputPath);
//		config.put("TIME_OFFSET", timeOffset);
//		config.setDebug(false);
//		
//		LocalCluster cluster=new LocalCluster();
//		cluster.submitTopology("WordCount", config, builder.createTopology());
		System.out.println("helloworld");
	}

}
