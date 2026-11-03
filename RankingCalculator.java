package com.sathish.demo.utility;
import com.sathish.demo.entity.Result;import java.util.*;
public final class RankingCalculator {private RankingCalculator(){} public static void assignRanks(List<Result> results){results.sort(Comparator.comparing(Result::getObtainedMarks,Comparator.nullsLast(Comparator.reverseOrder())));int rank=0,last=-1;for(int i=0;i<results.size();i++){int score=results.get(i).getObtainedMarks()==null?0:results.get(i).getObtainedMarks();if(i==0||score!=last)rank=i+1;results.get(i).setRank(rank);last=score;}}}
