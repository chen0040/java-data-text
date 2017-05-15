package com.github.chen0040.data.text;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


/**
 * Created by root on 9/10/15.
 */
public class PorterStemmerUnitTest {
    @Test
    public void testBasic(){
        TextFilter filter = new PorterStemmer();

        ///     caresses  ->  caress
        ///     ponies    ->  poni
        ///     ties      ->  ti
        ///     caress    ->  caress
        ///     cats      ->  cat
        ///     feed      ->  feed
        ///     agreed    ->  agree
        ///     disabled  ->  disable
        ///     matting   ->  mat
        ///     mating    ->  mate
        ///     meeting   ->  meet
        ///     milling   ->  mill
        ///     messing   ->  mess
        ///     meetings  ->  meet
        List<String> words = Arrays.asList(
                "caresses",
                "ponies",
                "ties",
                "caress",
                "cats",
                "feed",
                "agreed",
                "disabled",
                "matting",
                "mating",
                "meeting",
                "milling",
                "messing",
                "meetings"
        );

        List<String> result = filter.filter(words);
        for (int i = 0; i < words.size(); ++i)
        {
            System.out.println(String.format("%s -> %s", words.get(i), result.get(i)));
        }
    }
}
