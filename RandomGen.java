import java.util.Random;
import java.util.ArrayList;
public class RandomGen{
	public ArrayList<Integer> arr = new ArrayList<Integer>();
	Random random = new Random();
	public RandomGen(){

	}
	public void isiAwal(){
		int panjang = 16;
		int angka;

		while(arr.size() < panjang){
			int jml = 0;
			angka = random.nextInt(8);
			for(int i= 0; i< arr.size(); i++){
				if(arr.get(i) == angka){
					jml += 1;
				}
			}
			if(jml < 2){  
					arr.add(angka);
			}
		}
	}
	public int getPanjang(){
		return arr.size(); 
	}
	public ArrayList<Integer> getAngka(){
		return arr;
	}

}