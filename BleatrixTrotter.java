package Bleatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 
 * @author Sneha Priya Ale
 * Problem Statement

Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) * N directly after i * N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.
What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.

Limits

1 <= T <= 100.
Small dataset

0 <= N <= 200.
Large dataset

0 <= N <= 106.
 *
 */
public class BleatrixTrotter {
	
	Scanner scan=null;
	File file;
	BufferedReader file_reader = null;
	FileInputStream input;
	FileWriter file_writer;
	BufferedWriter buffer_file_writer;	
	String line=null,digit=null;
	int record=0,N=0,flag=0,i=0,result=0,l=0,p=1;
	int[] records=null;
	boolean b0=false,b1=false,b2=false,b3=false,b4=false,b5=false,b6=false,b7=false,b8=false,b9=false;
	
	//Constructor
	BleatrixTrotter(){
		scan = new Scanner(System.in);
		file= new File("C://Users//aelay//workspace//GooGleIO//src//Bleatrix//Output.txt"); //Information About the Output File
		System.out.println("Please enter the filename for Output:"); //Providing the file name for the output data.
		try{
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.delete();
				file.createNewFile();
			}
		input = new FileInputStream("C://Users//aelay//workspace//GooGleIO//src//Bleatrix//A-large-practice.in");
		file_reader = new BufferedReader(new InputStreamReader(input));
		file_writer = new FileWriter(file.getAbsoluteFile());
		buffer_file_writer = new BufferedWriter(file_writer);
		line = file_reader.readLine();
		System.out.println(""+line);
		record=Integer.parseInt(line);
		
		while(true){
			line = file_reader.readLine();
			if(line==null) break;
			N= Integer.parseInt(line);
			flag=0;
			i=0;
			boolean b0=false,b1=false,b2=false,b3=false,b4=false,b5=false,b6=false,b7=false,b8=false,b9=false;
			
			while(flag<10 && N!=0){
				result=(i+1)*N;
				i++;
				String str = Integer.toString(result);
				l=0;
//				int length =getSize(result);
//				System.out.println(str.length()+" "+length);
				records = new int[str.length()];
				for(String str1: str.split("")){
					records[l] = Integer.parseInt(str1);
					l++;
				}
				
				for(int k=0;k<records.length;k++){
					
					switch(records[k]){
					
					case 1:
						if(b1==false){
						flag++;
						b1=true;
						}
						break;
					case 2:
						if(b2==false){
						flag++;
						b2=true;
						}
						break;
					case 3:
						if(b3==false){
						flag++;
						b3=true;
						}
						break;
					case 4:
						if(b4==false){
						flag++;
						b4=true;
						}
						break;
					case 5:
						if(b5==false){
						flag++;
						b5=true;
						}
						break;
					case 6:
						if(b6==false){
						flag++;
						b6=true;
						}
						break;
					case 7:
						if(b7==false){
						flag++;
						b7=true;
						}
						break;
					case 8:
						if(b8==false){
						flag++;
						b8=true;
						}
						break;
					case 9:
						if(b9==false){
						flag++;
						b9=true;
						}
						break;
					case 0:
						if(b0==false){
						flag++;
						b0=true;
						}
						break;
					
					}
					
				}
				
			}
			
			if(N ==0){
				buffer_file_writer.write("Case #"+p+": INSOMNIA");
				System.out.print("Case #"+p+": INSOMNIA");
				p++;
				buffer_file_writer.newLine();	
				System.out.println();
			}
			else{
			buffer_file_writer.write("Case #"+p+": "+result);
			System.out.print("Case #"+p+": "+result);
			p++;
			buffer_file_writer.newLine();
			System.out.println();
			}
			
			
		}
		buffer_file_writer.close();
		file_reader.close();
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public int getSize(long number) {
        int count = 0;
        while (number > 0) {
            count += 1;
            number = (number / 10);
        }
        return count;
    }
	
	//main class
	public static void main(String args[]){
		new BleatrixTrotter();
	}

}
