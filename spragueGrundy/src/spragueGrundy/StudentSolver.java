package spragueGrundy;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentSolver {
	public static void main(String args[]) {
		HashMap<Integer,HashSet<Integer>> graph = stringToGraph("{0=[32, 16, 35, 37, 21, 39, 42, 11, 47], 1=[0, 2, 35, 36, 4, 5, 37, 6, 40, 9, 42, 43, 13, 45, 49, 17, 18, 22, 23, 29, 31], 2=[5, 47], 3=[32, 37, 7, 39, 8, 10, 43, 44, 14, 46, 15, 19, 21, 25, 26, 27, 29], 4=[32, 17, 2, 19, 6, 29], 5=[19], \r\n" + 
				"6=[2, 5, 22, 8, 47], 7=[32, 1, 36, 39, 8, 40, 9, 46, 47, 20, 21, 27, 29, 31], 8=[29, 47], 9=[32, 49, 36, 37, 5, 8, 27, 12, 45], 10=[36, 6, 23, 8, 9, 11, 12, 14, 47, 31], 11=[2, 4, 8, 40, 9, 12, 13, 14, 47, 16, 17, 19, 29], 12=[49, 17, 4, \r\n" + 
				"5, 21, 6, 29, 13, 47], 13=[17, 5, 6, 8, 44, 47], 14=[32, 2, 36, 39, 8, 40, 44, 13, 45, 47, 19, 29, 31], 15=[2, 35, 38, 9, 42, 11, 13, 45, 47, 16, 17, 23, 29, 31], 16=[49, 37, 39, 40, 27, 43, 45, 13, 14], 17=[2, 5, 8, 44], 18=[36, 37, 39, \r\n" + 
				"8, 40, 9, 44, 14, 16, 49, 27, 29, 31], 20=[0, 36, 4, 8, 40, 45, 14, 47, 17, 18, 19, 23, 27, 29, 31], 21=[49, 17, 5, 22, 6, 29], 22=[2, 8, 47], 23=[16, 49, 17, 2, 19, 4, 40, 9, 44, 45, 29, 14], 24=[0, 1, 36, 4, 37, 6, 40, 9, 43, 11, 14, 47, 15, 18, 19, 20, 23, 29], 25=[0, 32, 36, 5, 38, 39, 9, 10, 44, 13, 16, 49, 18, 19, 21, 28, 30], 26=[32, 36, 37, 38, 39, 40, 9, 42, 44, 45, 14, 46, 15, 16, 18, 19, 20, 22, 27, 28, 29, 30], 27=[32, 19, 36, 5, 6, 40, 8, 29, 45, 47], 28=[0, \r\n" + 
				"2, 5, 39, 8, 40, 9, 42, 12, 46, 20, 22, 29, 31], 29=[5], 30=[32, 1, 5, 7, 39, 8, 11, 44, 12, 13, 46, 47, 20, 21, 31], 31=[32, 49, 37, 5, 21, 39, 12, 13], 32=[2, 44, 29], 33=[0, 1, 38, 6, 39, 43, 11, 12, 13, 16, 49, 18, 19, 20, 22, 23, 24, 29, 31], 34=[1, 2, 35, 36, 4, 5, 37, 6, 8, 40, 9, 10, 11, 44, 12, 17, 20, 23, 31], 35=[17, 18, 6, 23, 8, 9, 42, 27, 11, 44, 45], 36=[49, 2, 19, 5, 22, 6, 29, 47], 37=[49, 17, 19, 36, 4, 5, 39, 8, 44, 47], 38=[0, 2, 36, 7, 39, 8, 9, 43, 13, 46, 47, 16, 18, 21, 22, 27, 28], 39=[17, 19, 22, 29], 40=[32, 49, 37, 5, 39, 13, 47], 41=[34, 35, 3, 36, 37, 38, 8, 40, 9, 11, 12, 49, 18, 19, 20, 27, 28], 42=[32, 6, 39, 9, 11, 44, 12, 13, 14, 47, 49, 19, 21, 22, 23, 27], 43=[32, 36, \r\n" + 
				"39, 40, 8, 29, 45, 14, 47, 31], 44=[5, 29], 45=[2, 19, 36, 22, 40, 29], 46=[32, 2, 6, 39, 23, 40, 8, 29, 45], 48=[32, 33, 2, 4, 5, 38, 7, 39, 40, 41, 11, 44, 45, 14, 15, 17, 18, 20, 21, 24, 27, 28], 49=[29, 47]}");
		System.out.println("SG value: " +solve(graph, 0));
	}
	public static HashMap<Integer,HashSet<Integer>> stringToGraph(String input){
        Pattern kptrn = Pattern.compile("[0-9]*=");
        Pattern valptrn = Pattern.compile("(?<=\\[)[^]]+(?=\\])");
        Matcher keys = kptrn.matcher(input);
        Matcher values = valptrn.matcher(input);
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
        while(keys.find()){
            int key = Integer.parseInt(keys.group().substring(0,keys.group().length() - 1));
            values.find();
            String valuestobesplit = values.group();
            HashSet<Integer> valueSet = new HashSet<Integer>();
            for (String value : valuestobesplit.split(",")){
                valueSet.add(Integer.parseInt(value.trim()));
            }
            graph.put(key,valueSet);
        }
        return graph;
    }
	public static int solve(HashMap<Integer,HashSet<Integer>> graph, int x) {
		HashSet<Integer> spValues = new HashSet<Integer>();
		
		if(!graph.containsKey(x)) {
			return 0;
		} else {
			for(Integer vertex : graph.get(x)) {
				spValues.add(solve(graph, vertex));
			}
		}
		int grundy = 0;
        while(spValues.contains(grundy)) {
        	grundy++;
        }
		return grundy;
	}
	
}


