package ru.users.ui.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import ru.users.api.ProjectConfig;
import org.testng.annotations.BeforeSuite;

public class BaseUITest {

    @BeforeSuite
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        Configuration.baseUrl = config.baseUrl();
    }

}
