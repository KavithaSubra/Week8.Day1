package testcases;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features"
					,glue="pages"
					,monochrome=true)

public class Runner extends BaseClass{

}