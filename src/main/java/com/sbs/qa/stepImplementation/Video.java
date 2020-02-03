package com.sbs.qa.stepImplementation;

import com.sbs.qa.base.TestBase;
import org.openqa.selenium.By;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Video extends TestBase {

    public Video(){
        super();
    }
    @BeforeMethod
    public void setup(){
      initialization();

      driver.get(prop.getProperty("video_url"));
    }

    @Test
    public void TestVideo() throws InterruptedException {


        try {

            Thread.sleep(20000);
            WebElement play = driver.findElement(By.cssSelector(".video-player__tile-play"));
            //play the content
            play.click();

            //play for 10 seconds (put a wait)
            Thread.sleep(10000);

            WebElement pause = driver.findElement(By.cssSelector(".video-player__play-pause-icon"));

            //pause the player
            pause.click();

            //wait for 5 seconds
            Thread.sleep(5000);

            //resume the player and play it for 2 mins
            pause.click();

            Thread.sleep(120000);

            //pause again
            pause.click();


        }catch(InterruptedException i){
            i.printStackTrace();
    }catch(ElementNotInteractableException e){
    e.printStackTrace();
}catch(TimeoutException t){
    t.printStackTrace();
} catch (Exception e){
    e.printStackTrace();
}
    }

    @AfterMethod
    public void tearDown(){

        //quit the driver
        driver.quit();
    }

}
