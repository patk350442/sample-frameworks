package com.ecommerce.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/com/ecommerce/features", glue="com.ecommerce.stepDefinitions", monochrome=true, tags="@Regression", plugin= {"json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
