package utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import aspects.AspectMatchEvent;
import match.execution.ExecutionManager;

@org.springframework.context.annotation.Configuration
@ComponentScan("utils")
@ComponentScan("dao")
@ComponentScan("match.execution")
//@ComponentScan("aspects")
@EnableAspectJAutoProxy
public class Configuration {
	
}
