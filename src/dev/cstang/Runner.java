package dev.cstang;

import java.lang.reflect.InvocationTargetException;

public class Runner {

  public static void main(String[] args)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
      InstantiationException, IllegalAccessException {

    Problem problem;

    if (System.getProperty("isLeetCode").equals("false")) {
      problem =
          (Problem)
              Class.forName("dev.cstang." + args[0]).getConstructor().newInstance();
    } else {
      problem =
          (Problem)
              Class.forName("dev.cstang.leetcode.Problem" + args[0]).getConstructor().newInstance();
    }

    problem.runTestCases();
  }
}
