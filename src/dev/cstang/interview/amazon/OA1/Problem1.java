package dev.cstang.interview.amazon.OA1;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Amazon Hackerrank Online Assessment 1, Question 1 (5-11-2022)
 *
 * <p>Q2 in https://leetcode.com/discuss/interview-question/137291/amazon-sde2-interview-question
 *
 * @author Cheryl Tang
 */
public class Problem1 extends Problem {

  public List<String> sortBoxes(List<String> boxList) {
    if (boxList.size() == 0) {
      return boxList;
    }

    ArrayList<String> oldListVersions = new ArrayList<>(boxList.size());
    ArrayList<String> newListVersions = new ArrayList<>(boxList.size());

    for (String s : boxList) {
      String[] boxStrings = s.trim().split("\\s+");

      String version = (Arrays.copyOfRange(boxStrings, 1, boxStrings.length))[0];

      if (!version.matches("^[0-9]+$")) {
        oldListVersions.add(s);
      } else {
        newListVersions.add(s);
      }
    }

    oldListVersions.sort(
        (o1, o2) -> {
          String[] o1Strings = o1.trim().split("\\s+");
          String o1Version = Arrays.toString(Arrays.copyOfRange(o1Strings, 1, o1Strings.length));

          String[] o2Strings = o2.trim().split("\\s+");
          String o2Version = Arrays.toString(Arrays.copyOfRange(o2Strings, 1, o2Strings.length));

          if (o1Version.compareTo(o2Version) == 0) {
            return o1Strings[0].compareTo(o2Strings[0]);
          }

          return o1Version.compareTo(o2Version);
        });

    List<String> sortedBoxList = new ArrayList<>();

    sortedBoxList.addAll(oldListVersions);
    sortedBoxList.addAll(newListVersions);

    return sortedBoxList;
  }

  @Override
  public void runTestCases() {
    List<String> input1 = new ArrayList<>();
    input1.add("ykc 82 01");
    input1.add("eo first qpx");
    input1.add("09z cat hamster");
    input1.add("06f 12 25 6");
    input1.add("az0 first qpx");
    input1.add("236 cat dog rabbit snake");

    List<String> input2 = new ArrayList<>();
    input2.add("kb gil yum phi");
    input2.add("ac gil yum phi");
    input2.add("ac gil yum phi");
    input2.add("10 gil yum phi");
    input2.add("dd gil yum phi");
    input2.add("9 gil yum phi");

    List<String> input3 = new ArrayList<>();
    input1.add("ykc    82 01");
    input1.add("eo first   qpx");
    input1.add("09z cat hamster");
    input1.add("06f 12 25 6");
    input1.add("az0   first qpx");
    input1.add("236    cat   dog   rabbit  snake");

    Object[] testCaseSolutions = new Object[] {sortBoxes(input2)};

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
