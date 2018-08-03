import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
	
		/*int [] testArr = {40429431,33712950,12645255,87031961,95396599,86124050,47110346,71702278,78962712,77088801,73911491,86818928,21488967,69521816,95055341,81368774,87066165,74874590,22628070,73446219,39386996,64977034,21777112,89798401,36375793,50759408,51819738,96964201,96018034,25036975,98848070,51804810,67551679,80544119,99708869,32603654,80411100,12146002,93161717,60959055,37720633,82503207,75938862,51195691,18194267,89953465,91041343,95011968,17810002,49083959,33742358,18479078,29185296,44009309,15240042,19954666,53931188,78676265,10603695,79037108,19490528,55103818,72894779,23855020,10419764,63287183,37325182,18808788,82828948,44023203,17498880,27569684,96345185,42798165,99215229,17505653,76437004,58074675,58264157,19072985,20642941,91599884,28161750,39358332,38406475,96832654,60936092,45073352,48809100,24521366,68727738,81273645,86218730,94806773,49318474,30258723,67395879,99127046,36142468,43666212};*/
		List<String> messages = Arrays.asList("");
		/*List<String> messages2 = Arrays.asList("Two");
		List<String> messages3 = Arrays.asList("Three");
		List<String> messages4 = Arrays.asList("Four");
		List<String> messages5 = Arrays.asList("Five");
		List<String> messages6 = Arrays.asList("Six");
		List<String> messages7 = Arrays.asList("Seven");
		List<String> messages8 = Arrays.asList("Eight");
		List<String> messages9 = Arrays.asList("Nine");
		List<String> messages10 = Arrays.asList("Ten");
		List<String> messages11 = Arrays.asList("Eleven");*/
		
		/*test.add(test, 40429431, messages);
		test.add(test, 33712950, messages2);
		test.add(test, 12645255, messages3);
		test.add(test, 87031961, messages4);
		
		
		test.add(test, 86124050, messages5);
		test.add(test, 95396599, messages6);
		test.add(test, 47110346, messages7);
		test.add(test, 71702278, messages8);
		test.add(test, 78962712, messages9);
		
		
		test.add(test, 77088801, messages10);
		test.add(test, 77088901, messages10);
		test.add(test, 62811298, messages11);
		
test.remove(test, 47110346);
	test.remove(test, 95396599);
		test.remove(test, 78962712);*/
		
		Scanner scanner = new Scanner(new File("uls_test_file3.txt"));
		SmartULS test1 = new SmartULS();
		
		
		while(scanner.hasNextInt()){
			int key=scanner.nextInt();
		   test1.add(test1, key, messages);
		}
		
		scanner.close();
		//test1.remove(test1, 99995238);
		Vector sorted = new Vector ();
		sorted = test1.allKeys(test1);
		
		
		
		PrintWriter printWriter = new PrintWriter ("sorted3.txt");
		
	
		for(int i=0; i<sorted.size(); i++){
			int result=(int) sorted.elementAt(i);
			int length = (int)(Math.log10(result)+1);
			int zerosToPrint=8-length;
			
			if(zerosToPrint==0)
				printWriter.println(result);
			else
			{
				String zeroes="";
				
				for(int j=zerosToPrint;j>0;j--){
					zeroes=zeroes + "0";
				}
				printWriter.println(zeroes+result);
			}
			
		}
		
		printWriter.close (); 
		
		System.out.println("Done sorting. See sorted file.");
		
		/*System.out.println("Previous for 99962219 is " + test1.prevKey(test1, 99962219));
		System.out.println("Next for 99913022 is " + test1.nextKey(test1,99913022));
		
		System.out.println("Printing number of keys from 99986632 to 99997635:" + test1.rangeKey(99986632,99997635));
		
		/*test.print();
		System.out.println("Value of key" + 12645255 + " is: ");
		System.out.println(test.getvalues(test, 12645255));*/
		
		/*System.out.println("Previous for 40429431 is " + test.prevKey(test, 40429431));
		System.out.println("Next for 77088901 is " + test.nextKey(test,77088901 ));
		
		System.out.println("Printing number of keys from 40429431 to 62811298:" + test.rangeKey(40429431, 62811298));
		
		/*Vector sorted = new Vector ();
		sorted = test.allKeys(test);
		
		System.out.println();
		
		System.out.println("Sorted keys please:");
		for(int i=0; i<sorted.size(); i++){
			System.out.print(sorted.elementAt(i) + ",");
		}
		
		System.out.println();
		
		System.out.println("Now print againt DB but in sortd order");
		
		for(int i=0; i<sorted.size(); i++){
			int key = (int) sorted.elementAt(i);
			System.out.print(key + ", value: ");
			test.getvalues(test, key);
		}
		System.out.println();
		int result = test.rangeKey(33712950, 86124050);
		System.out.println(result);
		
		/*test.remove(test, 33712950);
		test.print();
		
		System.out.println("Value of key" + 12645255 + " is: ");
		test.getvalues(test, 12645255);
		
		System.out.println("Previous key for 40429431 is:" + test.prevKey(test, 40429431));
		System.out.println("Next key for 12645255 is:" + test.nextKey(test, 12645255));
		
		System.out.println("Value of key" + 40429431 + " is: ");
		test.getvalues(test, 40429431);*/
		//System.out.println(test.generate());
		
		/*Vector atest=new Vector();
		
		for(int i=0; i<100; i++){
			atest.addElement(test.generate());
		}
		
		SmartULS test2 = new SmartULS(atest);
		
				
		for(int i=0; i<test2.getVectorKeys().size(); i++){
			System.out.print(test2.getVectorKeys().elementAt(i) + ",");
		}*/
		
	}

}
