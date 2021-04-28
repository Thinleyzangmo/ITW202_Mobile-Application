package edu.gcit.debug;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calculator mcalculator;
    @Before
    public void setUp(){
        mcalculator = new calculator();
    }
    @Test
    public void addTwoNumber(){
        double result = mcalculator.add(1d,2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNumberFloat(){
        double result = mcalculator.add(1.111f,1.111d);
        assertThat(result, is(closeTo(2.222, 0.01)));
    }
    @Test
    public void subTwoNumber(){
        double result = mcalculator.sub(2d,1d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void subWorksWithNegativeResults(){
        double result = mcalculator.sub(1d,2d);
        assertThat(result, is(equalTo(-1d)));
    }
    @Test
    public void mulTwoNumber(){
        double result = mcalculator.mul(2d,2d);
        assertThat(result, is(equalTo(4d)));
    }
    @Test
    public void mulTwoNumberForZero(){
        double result = mcalculator.mul(0d,3d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumber(){
        double result = mcalculator.div(4d,2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumberZero(){
        double result = mcalculator.div(4d,0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}