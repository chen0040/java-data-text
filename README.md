# java-data-text

Package provides java implementation of various text preprocessing methods such as tokenizers, vocabulary, text filter, stemmer, and so on

[![Build Status](https://travis-ci.org/chen0040/java-data-text.svg?branch=master)](https://travis-ci.org/chen0040/java-data-text) [![Coverage Status](https://coveralls.io/repos/github/chen0040/java-data-text/badge.svg?branch=master)](https://coveralls.io/github/chen0040/java-data-text?branch=master) [![Documentation Status](https://readthedocs.org/projects/java-data-text/badge/?version=latest)](http://java-data-text.readthedocs.io/en/latest/?badge=latest)
  
# Install

# Usage

To use any text filter, just create a new text filter and then calls its filter(...) method.

### Porter Stemmer

```java
import com.github.chen0040.data.text.TextFilter;
import com.github.chen0040.data.text.PorterStemmer;

TextFilter stemmer = new PorterStemmer();
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

List<String> result = stemmer.filter(words);
for (int i = 0; i < words.size(); ++i)
{
    System.out.println(String.format("%s -> %s", words.get(i), result.get(i)));
}
```

### StopWord Removal



