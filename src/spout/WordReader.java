package spout;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WordReader extends BaseRichSpout {
	
	private static final long serialVersionUID=2197521792014017918L;
	private String inputPath;
	
	private SpoutOutputCollector collector;
	@Override
	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector=collector;
		inputPath=(String) conf.get("INPUT_PATH");
	}

	@Override
	public void nextTuple() {
		// TODO Auto-generated method stub
		Collection<File> files= FileUtils.listFiles(new File(inputPath), new String[]{"txt"}, true);
		for (File f:files) {
			try {
				List<String> readLines=FileUtils.readLines(f,"UTF-8");
				for (String line : readLines) {
					this.collector.emit(new Values(line));
				}
				FileUtils.moveFile(f, new File(f.getPath()+System.currentTimeMillis()+".bak"));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("line"));
	}

}
