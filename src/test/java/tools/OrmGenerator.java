/**
 * @(#)OrmGenerator.java, 2017年3月16日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package tools;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hzwangdaxi
 *
 */
public class OrmGenerator {
	public static void main(String[] args) {
		try {
			System.out.println("start generate code");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File(OrmGenerator.class.getResource("/tools/generatorConfig.xml").getFile());
			ConfigurationParser cp = new ConfigurationParser(warnings);

			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
//			warnings.forEach(wa -> System.out.println(wa));
			for (String wa:warnings){
				System.out.println(wa);
			}
			System.out.println("generator code success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
