package com.tingli.autosizedemo;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    public int lengthOfLongestSubstring(String s) {
        int resultLength = s.length();
        int curLength = 0;
        if (resultLength >= 2)
        {
            resultLength = 0;
            int startIndex = 0;
            for (int i = 0; i < s.length(); i++)
            {
                int index = s.indexOf(s.charAt(i), startIndex);
                if (index < i)
                {
                    resultLength = Math.max(resultLength, curLength);
                    startIndex = index + 1;
                    curLength = i - startIndex + 1;
                }
                else
                {
                    curLength++;
                }
            }
        }
        return Math.max(curLength, resultLength);
    }

    String s = " ";

    private int[] nums1 = new int[]{1, 2};
    private int[] nums2 = new int[]{3, 4};

    @Test
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[]{};
        for (int i = 0; i < nums1.length; i++)
        {
            nums[i] = nums1[i];
        }
        for (int j = nums1.length; j < nums2.length; j++)
        {
            nums[j] = nums2[j];
        }

        Arrays.stream(nums).sorted();

        if (nums.length % 2 == 0)
        {
            return nums[nums.length / 2] / 2;
        }
        else
        {

        }


        return 0;

    }


    public void test() {

        int resultLength = s.length();
        if (resultLength >= 2)
        {
            resultLength = 0;
            int curLength = 0;
            int startIndex = 0;
            for (int i = 0; i < s.length(); i++)
            {
                int index = s.indexOf(s.charAt(i), startIndex);
                System.out.println("check string is " + s.charAt(i) + "， index from " + startIndex + " is：" + index);
                if (index < i)
                {
                    resultLength = Math.max(resultLength, curLength);
                    startIndex = index + 1;
                    curLength = i - startIndex + 1;
                }
                else
                {
                    curLength++;
                }
                System.out.println("check startIndex is " + startIndex + ",curLength:" + curLength + ",resultLength:" + resultLength);
            }

            System.out.println("got a result length is " + Math.max(curLength, resultLength));
        }
        System.out.println("got a result length is " + resultLength);
        //        return 0;
    }


    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 输入: s = "dvdf"
     * 输出: 3
     */

    public void lengthOfLongestSubstring() {
        String s = "pwwkew";

        String result = "";
        if (s.length() >= 2)
        {
            StringBuilder temp = new StringBuilder();
            String curStr;
            int startIndex = 0;
            for (int i = 1; i <= s.length(); i++)
            {

                int index = s.indexOf(s.charAt(i), startIndex);
                if (index < 0)
                {

                }
                else
                {

                }


                curStr = s.substring(i - 1, i);
                System.out.println("------------------>curStr: " + curStr);
                if (temp.toString().contains(curStr))
                {
                    startIndex = s.indexOf(curStr, startIndex);
                    if (temp.length() > result.length())
                    {
                        temp = new StringBuilder();
                        temp.append(s.substring(startIndex + 1, i));
                        result = temp.toString();
                        System.out.println("got a result is " + result);
                    }
                }
                else
                {
                    temp.append(curStr);
                }
                System.out.println("temp is " + temp + ",length:" + temp.length());
            }
            if (temp.length() > result.length())
            {
                result = temp.toString();
                System.out.println("end got a result is " + result);
            }
        }
        System.out.println("result is " + result + ",length:" + result.length());


        //        return 0;
    }
}