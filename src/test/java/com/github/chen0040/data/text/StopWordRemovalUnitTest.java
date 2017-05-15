package com.github.chen0040.data.text;


import com.github.chen0040.data.text.utils.FileUtils;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.*;


/**
 * Created by xschen on 15/5/2017.
 */
public class StopWordRemovalUnitTest {

   @Test
   public void test() throws IOException {
      TextFilter filter = new StopWordRemoval();



      InputStream inputStream = FileUtils.getResource("documents.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String content = reader.lines().collect(Collectors.joining("\n"));
      reader.close();

      List<String> before = BasicTokenizer.doTokenize(content);
      List<String> after = filter.filter(before);

      assertThat(before).isNotEqualTo(after);

   }
}
