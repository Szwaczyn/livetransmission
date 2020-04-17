package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import aspects.AspectMatchEvent;

@org.springframework.context.annotation.Configuration
@ComponentScan("utils")
@ComponentScan("dao")
@EnableAspectJAutoProxy
public class Configuration {
	
	@Bean
	public AspectMatchEvent aspectMatchEvent() {
		return new AspectMatchEvent();
	}
	
}
