package com.sathish.demo.utility;
public final class ResultCalculator {private ResultCalculator(){} public static double percentage(int obtained,int total){return total<=0?0:(obtained*100.0)/total;} public static boolean passed(int obtained,int passing){return obtained>=passing;}}
