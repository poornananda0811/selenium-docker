package com.searchmodule.tests;

import com.searchmodule.pages.searchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


@Test
@Parameters({"keyword"})
  public void searchPage(String keyword){
    searchPage searchpage= new searchPage(driver);
    searchpage.goTo();
    searchpage.doSearch(keyword);
    searchpage.gotToVideos();
    int actualResult=searchpage.getResult();
  Assert.assertTrue(actualResult>0);
  }


}
