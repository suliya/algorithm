

package com.hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();//组合 

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));//每个商品的个数
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();//组合方案

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[i], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
    	 Map<String, Integer> map = new HashMap<String, Integer>();
    	 Integer[][] bom = null;
    	 int i=0;
    	 Iterator<String> key=boms.keySet().iterator();
    	 if(key.hasNext()){
    		  List<Integer> list=boms.get(key.next());
    		  bom[i] =(Integer[]) list.toArray();
    		  bom[i][4]=sum(list);
    		  i++;
    	 }
    	 
    	 for(int j=0;j<boms.size();j++){
    		 int sum=new Test().sum(order);
    	 }
    	 
		return map;
    	 
    }


	private static Integer sum(List<Integer> list) {
		int sum=0;
		for(int i=0;i<list.size();i++){
			sum+=list.get(i).intValue();
		}
		return sum;
	}
}