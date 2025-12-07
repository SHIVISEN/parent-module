package com.shine.userservice.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

	@Bean
	public Config hazelcastConfig() {
		Config config = new Config();
		config.setInstanceName("user-hazelcast-instance");
		config.addMapConfig(new MapConfig().setName("profiles").setTimeToLiveSeconds(600)); // cache 10 minutes
		return config;
	}
}
