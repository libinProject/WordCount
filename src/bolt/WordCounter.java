package bolt;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class WordCounter extends BaseBasicBolt {
	
	private HashMap<String, Integer> counters=new HashMap<String, Integer>();
	
	public void prepare(Map stormConf,TopologyContext context) {
		final long timeOffset=Long.parseLong(stormConf.get("TIME_OFFSET").toString());
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					for (Entry<String, Integer> enter : counters.entrySet()) {
						System.out.println(enter.getKey()+":"+enter.getValue());
					}
					System.out.println("--------------------------------------------");
					try {
						Thread.sleep(timeOffset*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		// TODO Auto-generated method stub
		String str=input.getString(0);
		if (!counters.containsKey(str)) {
			counters.put(str, 1);
		}else {
			Integer c=counters.get(str)+1;
			counters.put(str, c);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
