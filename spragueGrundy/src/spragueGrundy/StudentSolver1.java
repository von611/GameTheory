package spragueGrundy;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentSolver1 {
	public static void main(String args[]) {
		HashMap<Integer,HashSet<Integer>> graph = stringToGraph("{1=[33, 3, 36, 5, 7, 43, 46, 15, 17, 23, 26, 27, 30], 2=[1, 35,\r\n" + 
				"4, 37, 38, 7, 40, 46, 49, 19, 23, 27, 28, 30], 3=[0, 18, 20, 22, 27,\r\n" + 
				"13], 4=[16, 49, 18, 36, 20, 5, 22, 43, 45, 46], 5=[22], 6=[49, 17, 3,\r\n" + 
				"36, 5, 7, 43, 15], 7=[21, 26, 27, 46, 30], 8=[34, 3, 35, 36, 39, 41,\r\n" + 
				"10, 13, 45, 46, 47, 48, 49, 18, 19, 20, 22, 23, 27, 29, 30], 9=[1, 33,\r\n" + 
				"5, 37, 38, 6, 7, 41, 10, 42, 13, 45, 47, 15, 16, 48, 49, 18, 19, 20,\r\n" + 
				"26], 10=[3, 35, 4, 5, 38, 7, 43, 45, 47, 49, 17, 22, 23, 30], 11=[0,\r\n" + 
				"35, 36, 37, 39, 41, 15, 49, 18, 19, 22, 23, 24, 26, 27, 28, 29, 30],\r\n" + 
				"12=[0, 4, 5, 7, 9, 13, 14, 16, 17, 18, 19, 22, 23, 26, 30, 31, 32, 36,\r\n" + 
				"40, 41, 42, 43, 45, 47, 48], 13=[17, 18, 5, 21, 22, 46], 14=[33, 2, 3,\r\n" + 
				"36, 4, 5, 38, 39, 7, 10, 43, 13, 45, 15, 49, 17, 22, 25], 15=[0, 5],\r\n" + 
				"16=[49, 18, 20, 27], 17=[5], 18=[5, 22, 26], 19=[33, 36, 45, 46, 16,\r\n" + 
				"48, 49, 17, 18, 20, 26, 29], 20=[49, 5, 21, 15], 21=[49, 18, 5, 26],\r\n" + 
				"23=[16, 0, 20, 22, 26, 27, 28, 13, 46, 30, 15], 24=[32, 0, 1, 36, 4,\r\n" + 
				"5, 37, 6, 7, 10, 13, 45, 16, 49, 18, 19, 21, 23, 25, 28, 29, 30, 31],\r\n" + 
				"25=[32, 35, 4, 6, 7, 40, 13, 47, 48, 18, 22, 28, 29], 26=[22], 27=[18,\r\n" + 
				"21, 43, 28, 13, 30], 28=[17, 18, 26, 30, 15], 29=[16, 48, 18, 20, 5,\r\n" + 
				"38, 23, 27, 28, 13, 46], 30=[0, 18, 21, 22, 26, 46], 31=[0, 18, 5, 40,\r\n" + 
				"26, 43, 28, 45, 15], 32=[0, 48, 17, 3, 36, 21, 7, 40, 29, 31], 33=[16,\r\n" + 
				"36, 21, 6, 27, 45, 29], 34=[0, 36, 5, 37, 38, 6, 13, 47, 20, 21, 25,\r\n" + 
				"30], 35=[33, 3, 36, 4, 5, 7, 40, 13, 46, 15, 16, 20], 36=[16, 49, 17,\r\n" + 
				"20, 5, 38, 7, 26, 43, 13, 30], 37=[0, 33, 35, 4, 5, 6, 7, 40, 15, 20,\r\n" + 
				"21, 25, 26, 27, 28], 38=[49, 17, 3, 20, 5, 21, 7, 26, 43, 15], 39=[32,\r\n" + 
				"0, 34, 35, 36, 40, 13, 46, 47, 16, 17, 19, 20, 21, 22, 26, 27, 28,\r\n" + 
				"29], 40=[48, 17, 3, 36, 21, 22, 26, 27, 28, 46, 30], 41=[32, 2, 3, 4,\r\n" + 
				"6, 39, 7, 40, 10, 43, 15, 48, 49, 17, 19, 20, 22, 24, 28, 29, 31],\r\n" + 
				"42=[33, 34, 35, 5, 38, 6, 39, 10, 45, 16, 49, 18, 22, 25, 27, 30, 31],\r\n" + 
				"43=[0, 18, 20, 5, 22, 15], 44=[34, 3, 35, 4, 6, 39, 8, 10, 42, 43, 46,\r\n" + 
				"15, 49, 20, 22, 23, 27, 28], 45=[16, 49, 20, 21, 6, 23, 26, 27, 15],\r\n" + 
				"46=[5, 26], 47=[0, 1, 3, 4, 6, 45, 16, 17, 18, 19, 21, 27, 28, 30],\r\n" + 
				"48=[17, 3, 38, 7, 26, 43, 27, 28, 46, 15], 49=[5]}");
		System.out.println("Initial graph");
		for(Map.Entry map : graph.entrySet()) {
			System.out.println(map.getKey() + ":" + map.getValue());
		}
		System.out.println("SG value: " +solve(graph, 1));
	}
	public static HashMap<Integer,HashSet<Integer>> stringToGraph(String input){
        Pattern kptrn = Pattern.compile("[0-9]*=");
        Pattern valptrn = Pattern.compile("(?<=\\[)[^]]+(?=\\])");
        Matcher keys = kptrn.matcher(input);
        Matcher values = valptrn.matcher(input);
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
        while(keys.find()){
            // System.out.println(keys.group());
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
		int nimsum = 0;
		HashSet<Integer> spValues = new HashSet<Integer>();
		
		if(!graph.containsKey(x) || graph.get(x).size() == 0) {
			return 0;
		} else {

			System.out.println("Hello Graph.................");
			for(Map.Entry map : graph.entrySet()) {
				System.out.println(map.getKey() + ":" + map.getValue());
			}
			for(Integer vertex : graph.get(x)) {
				System.out.println("Integer vertex: " + vertex);
				spValues.add(solve(graph, vertex));
			}
		}
		int grundy = 0;
		Iterator<Integer> i = spValues.iterator(); 
    	System.out.println("Sp Values: " + spValues);
        while(spValues.contains(grundy)) {
        	grundy++;
        }
		System.out.println("Grundy: " + grundy);
		return grundy;
	}
	
}


