package com.github.chen0040.data.text;


import com.github.chen0040.data.text.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.*;


/**
 * Created by xschen on 15/5/2017.
 */
public class StopWordRemovalUnitTest {

   private static final Logger logger = LoggerFactory.getLogger(StopWordRemovalUnitTest.class);

   @Test
   public void test() throws IOException {
      StopWordRemoval filter = new StopWordRemoval();



      InputStream inputStream = FileUtils.getResource("documents.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String content = reader.lines().collect(Collectors.joining("\n"));
      reader.close();

      List<String> before = BasicTokenizer.doTokenize(content);
      List<String> after = filter.filter(before);

      assertThat(before).isNotEqualTo(after);




   }

   @Test
   public void test_xml_tag_filter() {
      StopWordRemoval filter = new StopWordRemoval();
      filter.setRemoveXmlTag(true);

      List<String> textWithXmlTags = Arrays.asList("<html>", "</html>", "hello World", "<test>", "<test", "<1>");

      List<String> result = filter.filter(textWithXmlTags);

      logger.info("test");

      result.forEach(e -> logger.info("{}", e));

      assertThat(result).size().isEqualTo(2);
      assertThat(result).contains("hello World");

   }
}
