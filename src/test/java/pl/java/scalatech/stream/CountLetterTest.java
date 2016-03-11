package pl.java.scalatech.stream;

import static java.lang.Character.isUpperCase;

import java.util.function.Predicate;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CountLetterTest {

    
    private final static String TEXT = "Hello World";
    
    
    @SuppressWarnings("boxing")
    @Test
    public void shouldCountAllCapitalLetterInSentence(){
       // TEXT.chars().forEach(letter -> log.info("{}",Character.isUpperCase(letter)));
        log.info("capital letter : {}",TEXT.chars().filter(letter->isUpperCase(letter)).count());
        log.info("capital letter : {}",TEXT.codePoints().filter(letter->isUpperCase(letter)).count());               
    }
    @SuppressWarnings("boxing")
    @Test
    public void shouldWorkMapToObj(){
        Predicate<Integer> isBetweenA_M = c -> c> 'a' && c < 'm';        
        log.info("{}",TEXT.codePoints().mapToObj(Integer::valueOf).filter(isBetweenA_M).count());
    }
    
    @SuppressWarnings("boxing")
    @Test
    public void shouldBoxedWork(){
        Predicate<Integer> isBetweenA_M = c -> c> 'a' && c < 'm';
        log.info("{}",TEXT.codePoints().boxed().filter(isBetweenA_M).count());
    }
    
    @Test
    public void guavaCharSetTest(){        
        Assertions.assertThat("ello orld").isEqualTo(CharMatcher.JAVA_UPPER_CASE.removeFrom(TEXT));
        Assertions.assertThat("ello orld").isEqualTo(CharMatcher.JAVA_LOWER_CASE.or(CharMatcher.BREAKING_WHITESPACE).retainFrom(TEXT));
        
    }
    @Test
    public void guavaCharMatcherTest(){
        log.info("only digit from sentence : {}",CharMatcher.DIGIT.retainFrom("abc12d32"));
    }
}
