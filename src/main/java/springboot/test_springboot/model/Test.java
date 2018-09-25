package springboot.test_springboot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {
	 public static void main (String[] args){  
		 String string[]={"i","am","xiao","huang"};
		 
		// new Test().settest(string);
		 new Test().testList(string);
	    }  
	 
	 
     
     public void settest(String string[]){  
    	   
         Set<String> set=new HashSet<String>();  
         for(int i=0;i<string.length;i++){  
             set.add(string[i]);  
         }  
         Iterator iterator=set.iterator();  
         while(iterator.hasNext()){  
             System.out.println("set的输出结果是："+iterator.next());  
         }  
     }  
     public void testList(String[] str){  
  	   
         List<String> list=new ArrayList();  
         
         for(String l:str){  
           list.add(l);  
         } 
         //for(int i=0; i<list.size(); i++){
        //	 System.out.println(list.get(i));
//         }
//        list.forEach(e->System.out.println(e));
          list.forEach(e->{});
//        Iterator iterator=list.iterator();  
//        while(iterator.hasNext()){  
//             System.out.println("set的输出结果是："+iterator.next());  
//         }  
     }  
}
